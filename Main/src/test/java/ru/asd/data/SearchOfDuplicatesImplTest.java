package ru.asd.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchOfDuplicatesImplTest {
    SearchOfDuplicatesImpl searchOfDuplicates;
    HashMap<Path, String> mapMd5 = new HashMap<>();
    List<Path> expectedHashMapDuplicate = new ArrayList<>();
    List<Path> expectedBubbleDuplicate = new ArrayList<>();
    static final String PATH1 = "Main\\src\\test\\resources\\Search\\hw3text.txt";
    static final String PATH2 = "Main\\src\\test\\resources\\Search\\Gradle\\hw3text1.txt";
    static final String PATH3 = "Main\\src\\test\\resources\\Search\\Gradle\\gradle-6.3\\hw3text2.txt";
    static final String PATH4 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\HW02-DIYArrayList\\src\\main\\java\\DIYArrayList.java";
    static final String PATH5 = "Main\\src\\test\\resources\\Search\\DIYArrayList1.java";
    static final String PATH6 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\TestClass.java";
    static final String PATH7 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\TesteeClassTest.java";
    static final String CODEMD5_1 = "hash1";
    static final String CODEMD5_2 = "hash2";
    static final String CODEMD5_3 = "hash3";
    static final String CODEMD5_4 = "hash4";

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
        expectedHashMapDuplicate.add(Paths.get(PATH2));
        expectedHashMapDuplicate.add(Paths.get(PATH1));
        expectedHashMapDuplicate.add(Paths.get(PATH4));
        expectedBubbleDuplicate.add(Paths.get(PATH1));
        expectedBubbleDuplicate.add(Paths.get(PATH3));
        expectedBubbleDuplicate.add(Paths.get(PATH5));

        System.out.println("Test map: " + mapMd5);
    }

    @Test
    void getListOfDuplicatesUsingHashMap() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesUsingHashMap(mapMd5);
        assertEquals(expectedHashMapDuplicate,actualDuplicate);
    }

    @Test
    void getListOfDuplicatesBubbleMethod() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesBubbleMethod(mapMd5);
        assertEquals(expectedBubbleDuplicate,actualDuplicate);

    }
}