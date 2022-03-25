package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy{
    //for https://grc.ua/ и https://hh.ru/
//    private static final String URL_FORMAT = "https://spb.hh.ru/search/vacancy?clusters=true&area=2&ored_clusters=true&enable_snippets=true&salary=&st=searchVacancy&text=java+ADDITIONAL_VALUE&page=PAGE_VALUE";
//    private static final String URL_FORMAT = "https://spb.hh.ru/search/vacancy?clusters=true&area=2&ored_clusters=true&enable_snippets=true&salary=&st=searchVacancy&text=java+%s&page=%d";
//    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException{
        searchString = URLEncoder.encode(searchString, "UTF-8");
        Document doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:91.0) Gecko/20100101 Firefox/91.0").
                referrer("https://hh.ru/").get();
        return doc;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> allVacancies = new ArrayList<>();
//        int page = 0;
//do {
//    try {
//        Document doc = getDocument(searchString, page);
//        Elements vacanciesHtmlList = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
//        for (Element element : vacanciesHtmlList) {
//            Elements links = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
//            Elements locations = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
//            Elements companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");
//            Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
//
//            Vacancy vacancy = new Vacancy();
//            vacancy.setSiteName("hh.ru");
//            vacancy.setTitle(links.get(0).text());
//            vacancy.setUrl(links.get(0).attr("href"));
//            vacancy.setCity(locations.get(0).text());
//            vacancy.setCompanyName(companyName.get(0).text());
//            vacancy.setSalary(salary.size() > 0 ? salary.get(0).text() : "");
//
//            page++;
//        }
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}while ();
        int page = 0;
        try {
            do {
                Document doc = getDocument(searchString, page);

                Elements vacanciesHtmlList = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

                if (vacanciesHtmlList.isEmpty()) break;

                for (Element element : vacanciesHtmlList) {
                    Elements links = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                    Elements locations = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
                    Elements companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");
                    Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("hh.ru");
                    vacancy.setTitle(links.get(0).text());
                    vacancy.setUrl(links.get(0).attr("href"));
                    vacancy.setCity(locations.get(0).text());
                    vacancy.setCompanyName(companyName.get(0).text());
                    vacancy.setSalary(salary.size() > 0 ? salary.get(0).text() : "");

                    allVacancies.add(vacancy);
                }

                page++;
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allVacancies;
    }
}
