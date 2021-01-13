package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Blog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BlogSpiderController {
    public void Run() throws Exception {
        Document doc = null;

        for (int i = 1; i <= 200; i++) {
            doc = getUrlDocument("https://www.cnblogs.com/#p" + i);

            for (Blog blog : getBlogListByDocument(doc)) {
                System.out.println(blog.getTitle()+":"+blog.getUrl());
                bindBlogDetail(blog);
            }
            System.out.println("page:"+i);
        }
        System.out.println("Task Finished!");
    }

    public Document getUrlDocument(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        return doc;
    }

    public List<Blog> getBlogListByDocument(Document doc) throws Exception{
        List<Blog> list = new ArrayList<Blog>();
        Element pageList = doc.getElementById("post_list");
        Elements blogs = pageList.getElementsByClass("post-item");

        Blog b;
        for (Element blog : blogs) {
            b = new Blog();
            b.setDetail(blog.getElementsByClass("post-item-summary").text());
            b.setTitle(blog.getElementsByClass("post-item-title").text());
            b.setUrl(blog.getElementsByClass("post-item-title").get(0).attr("href"));
            list.add(b);
        }

        return list;
    }

    public void bindBlogDetail( Blog blog) throws Exception{
        //Do data bind
    }
}