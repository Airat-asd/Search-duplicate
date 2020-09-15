package ru.asd;

import ru.asd.search.SearchUsingByteArray;
import ru.asd.search.SearchUsingString;

public class SearchMain {
    public static void main(String[] args) {
        final String PATH_OF_FOLDER = "D:\\AUTORUN\\AUTORUNX";
//        SearchUsingByteArray.startSearch(PATH_OF_FOLDER);
        SearchUsingString.startSearch(PATH_OF_FOLDER);
    }
}
