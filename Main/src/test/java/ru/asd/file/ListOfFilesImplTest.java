package ru.asd.file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOfFilesImplTest {
    ListOfFilesImpl listOfFiles;
    final static String PATH = "D:\\AUTORUN\\AUTORUNX";

    @BeforeEach
    void setUp() {
        listOfFiles = new ListOfFilesImpl(PATH);
    }

    @Test
    void getListOfFiles() {
        List<Path> actualList = listOfFiles.getListOfFiles();
        assertArrayEquals(expected; actualList);
    }
}