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

    @Override
    public List<Path> getListOfDuplicatesUsingHashMap(Map<Path, byte[]> mapMd5Byte) {
        List<Path> listOfDuplicateKey = new ArrayList<>();
        Map<byte[], Path> mapMd5NotDuplicate = new HashMap<>();
        mapMd5Byte.forEach((k, v) -> mapMd5NotDuplicate.put(v,k));
        System.out.println("----mapMd5Byte------");
        mapMd5Byte.forEach((k, v) -> System.out.println(v+"="+k));
        System.out.println("-----mapMd5NotDuplicate----------");
        mapMd5NotDuplicate.forEach((k, v) -> System.out.println(k+"="+v));
//        mapMd5NotDuplicate.forEach((k, v) -> mapMd5Byte.remove(v));
        mapMd5Byte.forEach((k, v) -> listOfDuplicateKey.add(k));
        return listOfDuplicateKey;
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
