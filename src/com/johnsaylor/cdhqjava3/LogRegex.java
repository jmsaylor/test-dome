package com.johnsaylor.cdhqjava3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRegex {

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename = "/home/john/Documents/input001.txt";
        File file = new File(filename);
        Scanner reader = new Scanner(file);

        HashMap<String, Integer> hosts = new HashMap<>();

        Pattern pattern = Pattern.compile("^(.*?[.].*?[.][a-z]{3}).*");



        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);
            if (pattern.matcher(line).matches()) {
                System.out.println("true");
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                String hostName = matcher.group(1);
                if (hosts.containsKey(hostName)) {
                    int temp = hosts.get(hostName);
                    hosts.put(hostName, temp + 1);
                } else {
                    hosts.put(hostName, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : hosts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
