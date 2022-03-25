//package com.javarush.task.task33.task3309;
//
////необходимо исправить
//import org.w3c.dom.Comment;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.StringReader;
//import java.io.StringWriter;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Комментарий внутри xml
//*/
//
//
////        Комментарий внутри xml
////        Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
////        В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
////        Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.
////
////        Пример вызова:
////        toXmlWithComment(firstSecondObject, "second", "it's a comment")
////
////        Пример результата:
////        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
////        <first>
////        <!--it's a comment-->
////        <second>some string</second>
////        <!--it's a comment-->
////        <second>some string</second>
////        <!--it's a comment-->
////        <second><![CDATA[need CDATA because of < and >]]></second>
////        <!--it's a comment-->
////        <second/>
////        </first>
////
////
////        Requirements:
////        1. Метод toXmlWithComment должен быть статическим.
////        2. Метод toXmlWithComment должен быть публичным.
////        3. Если во входящем xml отсутствует искомый тег, то добавлять комментарии не нужно.
////        4. Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
////        5. Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.
//
//
//public class Solution {
//    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
//
//        StringWriter writer = new StringWriter();
//        JAXBContext context = JAXBContext.newInstance(obj.getClass());
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(obj, writer);
//        String result = writer.toString();
////        StringReader reader = new StringReader(result);
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(result.getBytes(StandardCharsets.UTF_8));
//
//
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        dbf.setCoalescing(true);
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document document = db.parse(byteArrayInputStream);
//        document.getDocumentElement().normalize();
////        Node root = document.getDocumentElement();
//
////        NodeList listNode = root.getChildNodes();
//        NodeList listNode = document.getElementsByTagName(tagName);
//        Comment com = document.createComment(comment);
//        for (int i = 0; i < listNode.getLength(); i++) {
//            Node node = listNode.item(i);
//            node.getParentNode().insertBefore(com, node);
//        }
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
//        StringWriter stringWriter = new StringWriter();
//        transformer.transform(new DOMSource(document), new StreamResult(writer));
//        return stringWriter.toString();
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/

public class Solution {

    private static String[] escapeSymbols = {"<", ">", "'", "\"", "&"};

    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        try {
            return addCommentToTag(convertObjectToXML(obj), tagName, comment);
        } catch (Exception ignored) {
            ignored.toString();
        }
        return null;
    }

    private static String addCommentToTag(String xml, String tagName, String comment) throws Exception {
        Document document = getDocument(xml);
        document.normalizeDocument();

        addCdataBlocks(document, document.getDocumentElement());
        addComments(tagName, comment, document);

        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.toString();
    }

    private static void addCdataBlocks(Document document, Node rootElement) {
        if (rootElement.hasChildNodes()) {
            NodeList childNodes = rootElement.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                addCdataBlocks(document, childNodes.item(i));
            }
        } else {
            String textContent = rootElement.getTextContent();
            if (containsEscapeSymbols(textContent)) {
                rootElement.setTextContent("");
                rootElement.getParentNode().appendChild(document.createCDATASection(textContent));
            }
        }
    }


    private static void addComments(String tagName, String comment, Document document) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Comment documentComment = document.createComment(comment);
            documentComment.normalize();
            Node item = nodeList.item(i);
            item.getParentNode().insertBefore(documentComment, item);
        }
    }

    private static Document getDocument(String xml) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        return documentBuilder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
    }


    private static String convertObjectToXML(Object o) throws Exception {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(o.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(o, writer);
        return writer.toString();
    }

    private static boolean containsEscapeSymbols(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        } else {
            for (String character : escapeSymbols) {
                if (s.contains(character))
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        AnExample obj = new AnExample();
        System.out.println(toXmlWithComment(obj, "needCDATA", "comment"));
    }

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        @XmlElement(name = "needCDATA", type = String.class)
        public String[] needCDATA = new String[]{"<needCDATA><![CDATA[need CDATA because of < <>& and >]]></needCDATA>", ""};

        public List<String> characters = new ArrayList<>();
    }

}
