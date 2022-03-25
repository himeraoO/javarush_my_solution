package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{

    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
    //./4.JavaCollections/src/com/javarush/task/task28/task2810/view/vacancies.html

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(filePath);
        String body = getUpdatedFileContent(vacancies);
        updateFile(body);
        //System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){

        try {
            Document document = getDocument();
            Elements elements = document.getElementsByClass("template");
            Elements elementsCopy = elements.clone();
            elementsCopy.removeAttr("style");
            elementsCopy.removeClass("template");
            Element template = elements.get(0);
//            document.removeClass("vacancy");
            Elements prevVacancies = document.getElementsByClass("vacancy");

            for (Element redundant : prevVacancies) {
                if (!redundant.hasClass("template")) {
                    redundant.remove();
                }
            }
            for (Vacancy v:vacancies) {
                Element element = template.clone();
                Element elementCity = element.getElementsByClass("city").get(0);
                elementCity.appendText(v.getCity());
                Element elementCompanyName = element.getElementsByClass("companyName").get(0);
                elementCompanyName.appendText(v.getCompanyName());
                Element elementSalary = element.getElementsByClass("salary").get(0);
                elementSalary.appendText(v.getSalary());
                Element elementLink = element.getElementsByTag("a").get(0);
                elementLink.appendText(v.getTitle());
                elementLink.attr("href", v.getUrl());
//                Element vacancyLink = vacancyElement.getElementsByAttribute("href").get(0);
//                vacancyLink.appendText(vacancy.getTitle());
//                vacancyLink.attr("href", vacancy.getUrl());
                elements.before(element.outerHtml());
            }
            return document.html();
            } catch (IOException e) {
            e.printStackTrace();
        }

        return "Some exception occurred";
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }


    private void updateFile(String s){
        try(FileWriter writer = new FileWriter(filePath, false))
        {
            writer.write(s);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
//        Path file = Paths.get(filePath);
//        Files.write(file, s, StandardCharsets.UTF_8);
    }
}
