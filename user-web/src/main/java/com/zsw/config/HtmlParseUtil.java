package com.zsw.config;

import com.zsw.respondVo.ParseDemo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author zsw
 * @date 2021/2/25 16:31
 * @description : jsoup 爬数据工具
 */
@Component
public class HtmlParseUtil {

    public ArrayList<ParseDemo> parse (String keyword) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyword + "&enc=utf-8";
        Document document = Jsoup.parse(new URL(url), 3000);
        Element j_goodsList = document.getElementById("J_goodsList");
        Elements tag_li = j_goodsList.getElementsByTag("li");
//        System.out.println(tag_li);
        ArrayList<ParseDemo> parseDemos = new ArrayList<>();
        // 遍历所有的 li 元素
        for(Element el : tag_li){
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String name = el.getElementsByClass("p-name").eq(0).text();
            String price = el.getElementsByClass("p-price").eq(0).text();
            ParseDemo parseDemo = new ParseDemo();
            parseDemo.setImg(img);
            parseDemo.setName(name);
            parseDemo.setPrice(price);
            parseDemos.add(parseDemo);
            System.out.println("---------------------------------------------");
            System.out.println(img);
            System.out.println(name);
            System.out.println(price);
        }

        return parseDemos;
    }
}
