package com.johnsaylor.chdq;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Http {

    public static void main(String[] args) {
//        getTopArticles("olalonde", 10);
        int result = getTotal("{\"page\":1,\"per_page\":10,\"total\":2,\"total_pages\":1,\"data\":[{\"title\":\"Show HN: This up votes itself\",\"url\":\"http://news.ycombinator.com/vote?for=3742902&dir=up&whence=%6e%65%77%65%73%74\",\"author\":\"olalonde\",\"num_comments\":83,\"story_id\":null,\"story_title\":null,\"story_url\":null,\"parent_id\":null,\"created_at\":1332463239},{\"title\":null,\"url\":null,\"author\":\"olalonde\",\"num_comments\":null,\"story_id\":null,\"story_title\":\"Guacamole – A clientless remote desktop gateway\",\"story_url\":\"https://guacamole.incubator.apache.org/\",\"parent_id\":6547669,\"created_at\":1381763543}]}");
        System.out.println(result);
    }


    class Title implements Comparable<Title>{
        public String title;
        public int comments;

        @Override
        public int compareTo(Title title) {
            return title.comments - comments;
        }
    }

    public static List<String> getTopArticles(String author, int limit) {

//        do {
//
//        } while ();
    return null;
    }

    public static List<Title> getPage(String author, int page) throws IOException {
        String tempURL = "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=" + page;
        URL url = new URL(tempURL);

        URLConnection connection = url.openConnection();
        connection.addRequestProperty("accept", "application/json");



        String result = new String(connection.getInputStream().readAllBytes());

        System.out.println(result);

        return  null;
    }

    public static int getTotal(String json){
        System.out.println(json);
        Pattern pattern = Pattern.compile("total.*?([0-9]+)");

        Matcher matcher = pattern.matcher(json);

        matcher.find();

        return Integer.parseInt(matcher.group(1));
    }

}
