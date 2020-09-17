package ru.asd;

import ru.asd.search.SearchUsingByteArray;
import ru.asd.search.SearchUsingHashMap;
import ru.asd.search.SearchUsingString;

import java.util.HashMap;
import java.util.Map;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "C:\\JAVA\\Search\\HW01-gradle";
//        SearchUsingByteArray.startSearch(PATH_OF_FOLDER);
//        SearchUsingString.startSearch(PATH_OF_FOLDER);
        SearchUsingHashMap.startSearch(PATH_OF_FOLDER);
//            Map<String, String> asd = new HashMap<>();
//            asd.put("key1", "asdas");
//            asd.put("key1","fghfgbfgbfvfvb");
//        System.out.println(asd);
    }
}
