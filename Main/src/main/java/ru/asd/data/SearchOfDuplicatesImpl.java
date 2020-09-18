package ru.asd.data;

import java.nio.file.Path;
import java.util.*;

public class SearchOfDuplicatesImpl implements SearchOfDuplicates {

    @Override
    public List<Path> getListOfDuplicatesUsingHashMap(Map<Path, String> mapMd5) {
        List<Path> listOfDuplicateKey = new ArrayList<>();
        Map<String, Path> mapMd5NotDuplicate = new HashMap<>();
        mapMd5.forEach((k, v) -> mapMd5NotDuplicate.put(v, k));
        mapMd5NotDuplicate.forEach((k, v) -> mapMd5.remove(v));
        mapMd5.forEach((k, v) -> listOfDuplicateKey.add(k));
        return listOfDuplicateKey;
    }

    @Override
    public List<Path> getListOfDuplicates(Map<Path, String> mapMd5) {
        String bufferValueMd5;
        List<Path> listOfDuplicateKey = new ArrayList<>();
        int counterFirst = 0;
        int counterSecond;
        for (Map.Entry<Path, String> entryFirst : mapMd5.entrySet()) {
            bufferValueMd5 = entryFirst.getValue();
            counterFirst++;
            counterSecond = 0;
            for (Map.Entry<Path, String> entrySecond : mapMd5.entrySet()) {
                counterSecond++;
                if (counterSecond > counterFirst) {
                    if (entrySecond.getValue().equals(bufferValueMd5)) {
                        if (!entrySecond.getValue().equals("")) {
                            listOfDuplicateKey.add(entrySecond.getKey());
                            entrySecond.setValue("");
                        }
                    }
                }
            }

        }
        return listOfDuplicateKey;
    }
}
