package ru.asd.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchUsingHashMapTest {
    final static String PATH = "D:\\AUTORUN\\AUTORUNX";
    SearchUsingHashMap searchUsingHashMap;

    @BeforeEach
    void setUp() {
        searchUsingHashMap = new SearchUsingHashMap();

    }

    @Test
    void startSearch() {
        List<Path> actualDuplicat= searchUsingHashMap.startSearch(PATH);
    }
}