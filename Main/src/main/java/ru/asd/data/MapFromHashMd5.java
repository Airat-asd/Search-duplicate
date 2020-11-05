package ru.asd.data;

import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.Map;

public class MapFromHashMd5 {

    public static Map<Path, String> getMapFromHashMd5(String path) {
        DataStorage dataStorage = new DataStorageImpl();
        Map<Path, String> mapFromHashMd5 = dataStorage.getMapFromHashMd5(new ListOfFilesImpl(path));
        return mapFromHashMd5;
    }
}
