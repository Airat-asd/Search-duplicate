package ru.asd.data;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchOfDuplicatesImplTest {
    SearchOfDuplicatesImpl searchOfDuplicates;
    HashMap<Path, String> mapMd5 = new HashMap<>();
    static final String PATH1 = "Main\\src\\test\\resources\\Search\\hw3text.txt";
    static final String PATH2 = "Main\\src\\test\\resources\\Search\\hw3text1.txt";
    static final String PATH3 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\HW02-DIYArrayList\\src\\main\\java\\DIYArrayList.java";
    static final String PATH4 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\HW02-DIYArrayList\\src\\main\\java\\DIYArrayList1.java";
    static final String PATH5 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\HW03-testFramework\\src\\main\\java\\testClass\\TestClass.java";
    static final String PATH6 = "Main\\src\\test\\resources\\Search\\HW01-gradle\\HW03-testFramework\\src\\main\\java\\testClass\\TesteeClassTest.java";
    static final String CODEMD5_1 = "";
    static final String CODEMD5_2 = "";
    static final String CODEMD5_3 = "";
    static final String CODEMD5_4 = "";
    static final String CODEMD5_5 = "";
    static final String CODEMD5_6 = "";


    @BeforeEach
    void setUp() {
        searchOfDuplicates = new SearchOfDuplicatesImpl();
        mapMd5.put(Paths.get(PATH1), CODEMD5_1);
        mapMd5.put(Paths.get(PATH1), CODEMD5_2);
        mapMd5.put(Paths.get(PATH1), CODEMD5_3);
        mapMd5.put(Paths.get(PATH1), CODEMD5_4);
        mapMd5.put(Paths.get(PATH1), CODEMD5_5);
        mapMd5.put(Paths.get(PATH1), CODEMD5_6);
    }

    @Test
    void getListOfDuplicatesUsingHashMap() {
        List<Path> actualDuplicate = searchOfDuplicates.getListOfDuplicatesUsingHashMap(mapMd5);
    }

    @Test
    void getListOfDuplicates() {
    }
}