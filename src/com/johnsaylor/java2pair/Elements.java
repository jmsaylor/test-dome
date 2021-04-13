package com.johnsaylor.java2pair;
import java.io.*;
import java.util.*;

public class Elements {
}

class BaseConfigElement {}

class ConfigElement extends BaseConfigElement {}

class DynamicConfigElement extends ConfigElement {}

class ConfigCreator {
    void createConfig(List<? extends ConfigElement> elements) {
        // returns stream
    }
}

class ConfigurationHelper {
    public void createConfiguration(List<ConfigElement> data) {
        ConfigCreator creator = new ConfigCreator();
        creator.createConfig(data);
    }
}
/*
0 N
1 Y
2 Y
3 N
4 Y
5 N
6 Y
7 N
*/

class JavaFiddle
{
    public static void main(String[] args)
    {

    }
}
