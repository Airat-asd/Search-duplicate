package ru.asd.data;

import java.nio.file.Path;
import java.util.*;

public class SearchOfDuplicatesImpl implements SearchOfDuplicates {
    private Map<Path, String> mapMd5 = new HashMap<>();

    @Override
    public List<Path> getListOfDuplicatesFromByte(Map<Path, byte[]> mapMd5Byte) {
        for (Map.Entry<Path, byte[]> entry : mapMd5Byte.entrySet()) {
            mapMd5.put(entry.getKey(), Arrays.toString(entry.getValue()));
        }
        return getListOfDuplicates();
    }

    @Override
    public List<Path> getListOfDuplicatesFromString(Map<Path, String> mapMd5Byte) {
        mapMd5 = mapMd5Byte;
        return getListOfDuplicates();
    }

    private List<Path> getListOfDuplicates() {
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
