package ru.asd.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.asd.search.SearchOfDuplicatesImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchOfDuplicatesImplTest {
    SearchOfDuplicatesImpl searchOfDuplicates;
    HashMap<Path, String> mapMd5 = new HashMap<>();
    List<Path> expectedGetListOfDuplicatesUsingHashMap = new ArrayList<>();
    List<Path> expectedGetListOfDuplicatesUsingStream = new ArrayList<>();
    List<Path> expectedGetListOfDuplicatesUsingSorted = new ArrayList<>();

    static final String PATH1 = "Main\\src\\test\\resources\\Search\\hw3text.txt";
    static final String PATH2 = "Main\\src\\test\\resources\\Search\\Gradle\\hw3text1.txt";
    static final String PATH3 = "Main\\src\\test\\resources\\Search\\hw3text2.txt";
    static final String PATH4 = "Main\\src\\test\\resources\\Search\\DIYArrayList.java";
    static final String PATH5 = "Main\\src\\test\\resources\\Search\\DIYArrayList1.java";
    static final String PATH6 = "Main\\src\\test\\resources\\Search\\No duplicates\\TestClass.java";
    static final String PATH7 = "Main\\src\\test\\resources\\Search\\No duplicates\\TesteeClassTest.java";
    static final String CODEMD5_1 = "code1";
    static final String CODEMD5_2 = "code2";
    static final String CODEMD5_3 = "code3";
    static final String CODEMD5_4 = "code4";

    @BeforeEach
    void setUp() {
        searchOfDuplicates = new SearchOfDuplicatesImpl();
        mapMd5.put(Paths.get(PATH1), CODEMD5_1);
        mapMd5.put(Paths.get(PATH2), CODEMD5_1);
        mapMd5.put(Paths.get(PATH3), CODEMD5_1);
        mapMd5.put(Paths.get(PATH4), CODEMD5_2);
        mapMd5.put(Paths.get(PATH5), CODEMD5_2);
        mapMd5.put(Paths.get(PATH6), CODEMD5_3);
        mapMd5.put(Paths.get(PATH7), CODEMD5_4);
        expectedGetListOfDuplicatesUsingHashMap.add(Paths.get(PATH2));
        expectedGetListOfDuplicatesUsingHashMap.add(Paths.get(PATH1));
        expectedGetListOfDuplicatesUsingHashMap.add(Paths.get(PATH4));
        expectedGetListOfDuplicatesUsingStream.add(Paths.get(PATH1));
        expectedGetListOfDuplicatesUsingStream.add(Paths.get(PATH3));
        expectedGetListOfDuplicatesUsingStream.add(Paths.get(PATH5));
        expectedGetListOfDuplicatesUsingSorted.add(Paths.get(PATH5));
        expectedGetListOfDuplicatesUsingSorted.add(Paths.get(PATH1));
        expectedGetListOfDuplicatesUsingSorted.add(Paths.get(PATH3));

    }

    @Test
    void getListOfDuplicatesUsingHashMap() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesUsingHashMap(mapMd5);
        assertEquals(expectedGetListOfDuplicatesUsingHashMap, actualDuplicate);

    }

    @Test
    void getListOfDuplicatesUsingStream() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesUsingStream(mapMd5);
        assertEquals(expectedGetListOfDuplicatesUsingStream, actualDuplicate);

    }

    @Test
    void getListOfDuplicatesUsingHashSet() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesUsingHashSet(mapMd5);
        assertEquals(expectedGetListOfDuplicatesUsingStream, actualDuplicate);
    }

    @Test
    void getListOfDuplicatesUsingSorted() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesUsingSorted(mapMd5);
        assertEquals(expectedGetListOfDuplicatesUsingSorted, actualDuplicate);
    }

}