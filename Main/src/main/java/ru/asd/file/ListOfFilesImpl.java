package ru.asd.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ListOfFilesImpl implements ListOfFiles {
    private String pathName;
    private Map<Long, Path> mapPath = new TreeMap<>();

    public ListOfFilesImpl(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public List<Path> getListOfFiles() {
        try {
            List<Path> asList = Files.walk(Paths.get(pathName)).filter(Files::isRegularFile).collect(Collectors.toList());
            return asList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
