package ru.asd.data;

import ru.asd.code.*;
import ru.asd.file.*;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class DataStorageImpl implements DataStorage {
    @Override
    public Map<Path, String> getMapCodeMd5ThroughByteArray(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        Map<Path, String> mapMd5 = new HashMap<>();

        for (Path file : listOfFiles.getListOfFiles()) {
            if (readFile.getReadFile(file) != null) {
                var code = ConvertToMd5.md5ConvertToByte(readFile.getReadFile(file));
                mapMd5.put(file, code);
            }
        }
        return mapMd5;
    }

    @Override
    public Map<Path, String> getMapCodeMd5ThroughHEX(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        Map<Path, String> mapMd5 = new HashMap<>();

        for (Path file : listOfFiles.getListOfFiles()) {
            if (readFile.getReadFile(file) != null) {
                var code = ConvertToMd5.md5ConvertToHex(readFile.getReadFile(file));
                mapMd5.put(file, code);
            }
        }
        return mapMd5;
    }

    @Override
    public Map<Path, String> mapSorted(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        List<String> code = listOfFiles.getListOfFiles().stream().map(list -> ConvertToMd5.md5ConvertToHex(readFile.getReadFile(list))).collect(Collectors.toList());
        return null;
    }


}
