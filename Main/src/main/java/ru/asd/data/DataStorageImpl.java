package ru.asd.data;

import ru.asd.code.*;
import ru.asd.file.*;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataStorageImpl implements DataStorage {
    @Override
    public Map<Path, String> mapByteNotSorted(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        ConvertToMd5 convertToMd5 = new ConvertToMd5Impl();
        Map<Path, String> mapMd5 = new HashMap<>();

        for (Path file : listOfFiles.getListOfFiles()) {
            if (readFile.getReadFile(file) != null) {
                var code = convertToMd5.md5ConvertToByte(readFile.getReadFile(file));
                mapMd5.put(file, code);
            }
        }
        return mapMd5;
    }

    @Override
    public Map<Path, String> mapStringNotSorted(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        ConvertToMd5 convertToMd5 = new ConvertToMd5Impl();
        Map<Path, String> mapMd5 = new HashMap<>();

        for (Path file : listOfFiles.getListOfFiles()) {
            if (readFile.getReadFile(file) != null) {
                var code = convertToMd5.md5ConvertToHex(readFile.getReadFile(file));
                mapMd5.put(file, code);
            }
        }
        return mapMd5;
    }

    @Override
    public Map<Path, String> mapSorted(ListOfFiles listOfFiles) {
        //        if (readFile.getReadFile(file) != null) {
//            int summ = 0;
//            var code = convertToMd5.md5ConvertToByte(readFile.getReadFile(file));
//            for (int i = 0; i < code.length; i++) {
//                summ = summ + code[i];
//            }
//            System.out.println("Summ = " + summ);
//            System.out.println(Arrays.toString(convertToMd5.md5ConvertToByte(readFile.getReadFile(file))) + "==" + convertToMd5.md5ConvertToHex(readFile.getReadFile(file)));
//        }

        //        Comparator<byte[]> comparator = new Comparator<byte[]>() {
//            @Override
//            public int compare(byte[] o1, byte[] o2) {
//                if ((o1.)) {
//                    return 1;
//                }
//                return 0;
//            }
//        }
        return null;
    }

    @Override
    public Map<Path, String> mapStringSorted(ListOfFiles listOfFiles) {
        return null;
    }
}
