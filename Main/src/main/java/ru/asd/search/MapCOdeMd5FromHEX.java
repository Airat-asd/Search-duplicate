package ru.asd.search;

import ru.asd.data.DataStorage;
import ru.asd.data.DataStorageImpl;
import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.Map;

public class MapCOdeMd5FromHEX {
    public static Map<Path, String> getCodeHEX(String path) {
        DataStorage dataStorage = new DataStorageImpl();
        return dataStorage.getMapCodeMd5ThroughHEX(new ListOfFilesImpl(path));
    }
}
