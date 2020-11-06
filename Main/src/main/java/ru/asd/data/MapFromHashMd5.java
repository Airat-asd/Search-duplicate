package ru.asd.data;

import ru.asd.file.ListOfFilesImpl;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class MapFromHashMd5 {

    public static Map<Path, String> getMapFromHashMd5(String path) {
        DataStorage dataStorage = new DataStorageImpl();
        Map<Path, String> mapFromHashMd5 = dataStorage.getMapFromHashMd5(new ListOfFilesImpl(path));
        return mapFromHashMd5;
    }

    public static List<PathAndMd5> getListFromHashMd5(String path) {
        DataStorage dataStorage = new DataStorageImpl();
        List<PathAndMd5> listFromHashMd5 = dataStorage.getListFromHashMd5(new ListOfFilesImpl(path));
        return listFromHashMd5;
    }
}
