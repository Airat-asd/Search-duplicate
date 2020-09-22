package ru.asd.search;

import ru.asd.data.DataStorage;
import ru.asd.data.DataStorageImpl;
import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.Map;

public class MapCodeMd5FromByteArray {
    public static Map<Path, String> getCodeByteArray(String path) {
        DataStorage dataStorage = new DataStorageImpl();
        return dataStorage.getMapCodeMd5ThroughByteArray(new ListOfFilesImpl(path));
    }
}
