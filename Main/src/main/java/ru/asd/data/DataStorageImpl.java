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
        List<SizeAndPath> sizeAndPath = getListFromSizeAndPath(listOfFiles);
        Long bufferSize = -1L;
        Path bufferPath = Paths.get("");
        Long a;
        String code, codeBuffer;
        for (int i = 0; i < sizeAndPath.size(); i++) {
            a = sizeAndPath.get(i).getSize();
            if (a.equals(bufferSize)) {
                code = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(sizeAndPath.get(i).getPath()));
                mapMd5.put(sizeAndPath.get(i).getPath(), code);
                codeBuffer = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(bufferPath));
                mapMd5.put(bufferPath, codeBuffer);
            }
            bufferSize = sizeAndPath.get(i).getSize();
            bufferPath = sizeAndPath.get(i).getPath();
        }
        System.out.println(mapMd5);
//        for (Path file : listOfFiles.getListOfFiles()) {
//            if (readFile.getReadFile(file) != null) {
//                var code = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(file));
//                mapMd5.put(file, code);
//
//            }
//        }
        return mapMd5;
    }

    private List<SizeAndPath> getListFromSizeAndPath(ListOfFiles listOfFiles) {
        List<SizeAndPath> sizeAndPath = new ArrayList<>(listOfFiles.getListOfFiles().size());
        for (Path file : listOfFiles.getListOfFiles()) {
            try {
                sizeAndPath.add(new SizeAndPath(file, Files.size(file)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sizeAndPath.sort(new Comparator<SizeAndPath>() {
            @Override
            public int compare(SizeAndPath o1, SizeAndPath o2) {
                if ((o1.getSize() - o2.getSize()) > 0) {
                    return 1;
                }
                if ((o1.getSize() - o2.getSize()) < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(sizeAndPath);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SizeAndPath)) return false;
        SizeAndPath that = (SizeAndPath) o;
        return path.equals(that.path) &&
                size.equals(that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, size);
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SizeAndPath{" +
                "path=" + path +
                ", size=" + size +
                '}' + "/\n";
    }
}
