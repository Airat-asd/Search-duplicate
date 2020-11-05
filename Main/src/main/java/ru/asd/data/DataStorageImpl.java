package ru.asd.data;

import ru.asd.code.*;
import ru.asd.file.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DataStorageImpl implements DataStorage {

    @Override
    public Map<Path, String> getMapFromHashMd5(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        Map<Path, String> mapMd5 = new HashMap<>();
        TreeSet<SizeAndPath> pathAndSize = getSetFromSizeAndPath(listOfFiles);
        Long bufferSize = -1L;
//        Long bufferSize = pathAndSize.first().getSize();
        Path bufferPath = pathAndSize.first().getPath();
        for (SizeAndPath sizeAndPath : pathAndSize) {
            if (sizeAndPath.getSize() == bufferSize) {
                var code = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(sizeAndPath.getPath()));
                mapMd5.put(sizeAndPath.getPath(), code);
                var codeBuffer = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(bufferPath));
                mapMd5.put(bufferPath, codeBuffer);
            }
            bufferSize = sizeAndPath.getSize();
            bufferPath = sizeAndPath.getPath();
        }

//        for (Path file : listOfFiles.getListOfFiles()) {
//            if (readFile.getReadFile(file) != null) {
//                var code = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(file));
//                mapMd5.put(file, code);
//
//            }
//        }
        return mapMd5;
    }

    private TreeSet<SizeAndPath> getSetFromSizeAndPath(ListOfFiles listOfFiles) {
        TreeSet<SizeAndPath> sizeAndPath = new TreeSet<>(new Comparator<SizeAndPath>() {
            @Override
            public int compare(SizeAndPath o1, SizeAndPath o2) {
                if ((o1.getSize() - o2.getSize()) > 0) {
                    return 1;
                }
                if ((o1.getSize() - o2.getSize()) < 0) {
                    return -1;
                } else return 0;
            }
        });

        for (Path file : listOfFiles.getListOfFiles()) {
            try {
                System.out.println(file+", " + Files.size(file));
                var asd = new SizeAndPath(file, Files.size(file));
                System.out.println(sizeAndPath.add(asd));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sizeAndPath;
    }
}

class SizeAndPath {
    private Path path;
    private Long size;

    public SizeAndPath(Path path, Long size) {
        this.path = path;
        this.size = size;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeAndPath that = (SizeAndPath) o;
        return Objects.equals(path, that.path) &&
                (size == that.size);
    }

    @Override
    public int hashCode() {
        System.out.println(path);
        var hash = Objects.hash(path);
        System.out.println(hash);
        return hash;
    }
}
