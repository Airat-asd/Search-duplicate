package ru.asd;

import ru.asd.search.SearchUsingByteArray;
import ru.asd.search.SearchUsingHashMap;
import ru.asd.search.SearchUsingString;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "Main\\src\\test\\resources\\Search";
//        SearchUsingByteArray.startSearch(PATH_OF_FOLDER);
//        SearchUsingString.startSearch(PATH_OF_FOLDER);
        SearchUsingHashMap.startSearch(PATH_OF_FOLDER);

    }
}
