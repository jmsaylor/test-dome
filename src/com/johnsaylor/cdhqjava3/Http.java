package com.johnsaylor.cdhqjava3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Http {

    public static void main(String[] args) {
        getArticleTitles("patricktomas");
    }
    /*
     * Complete the 'getArticleTitles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING author as parameter.
     *
     * URL for cut and paste:
     * https://jsonmock.hackerrank.com/api/articles?author=<authorName>&page=<num>
     *
     */

    public static List<String> getArticleTitles(String author) {
        List<String> result = new ArrayList<>();
        int pageNumber = 1;
        String baseURL = "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=";

        try {
            java.net.URL url = new java.net.URL(baseURL.concat(String.valueOf(pageNumber)));
            java.net.URLConnection connection = url.openConnection();
            connection.addRequestProperty("accept", "application/json");

            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuffer buffer = new StringBuffer();

            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }

            String firstPage = new String(buffer);
            System.out.println(firstPage);

            int totalPages = getTotalPages(firstPage);

            result = getTitlesOnPage(firstPage);

            pageNumber++;

            do {
                url = new java.net.URL(baseURL.concat(String.valueOf(pageNumber)));
                connection = url.openConnection();
                connection.addRequestProperty("accept", "application/json");

                scanner = new Scanner(connection.getInputStream());
                buffer = new StringBuffer();

                while (scanner.hasNextLine()) {
                    buffer.append(scanner.nextLine());
                }

                String page = new String(buffer);

                List<String> localResult = getTitlesOnPage(page);

                for (String title : localResult) {
                    result.add(title);
                }

                pageNumber++;
            } while (pageNumber <= totalPages);
        } catch (Exception e) {

        }


        return result;
    }

    public static int getTotalPages(String json) {
        Pattern pattern = Pattern.compile("total_pages.*?([0-9]+)");
        Matcher matcher = pattern.matcher(json);
        matcher.find();
        return Integer.parseInt(matcher.group(1));
    }

    public static int getResultCount(String json) {
        Pattern pattern = Pattern.compile("per_page.*?([0-9]+)");
        Matcher matcher = pattern.matcher(json);
        matcher.find();
        return Integer.parseInt(matcher.group(1));
    }

    public static List<String> getTitlesOnPage(String json) {
        Pattern pattern = Pattern.compile("[^_]title.*?[:](.*?)[,]");
        Matcher matcher = pattern.matcher(json);

        List<String> result = new ArrayList<>();

        while (matcher.find()) {
            String temp = matcher.group(1);
            result.add(temp.substring(1, temp.length() - 1));
        }

        return result;
    }

}
