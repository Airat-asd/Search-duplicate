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
        Map<Path, String> mapMd5 = new HashMap<>();
        List<PathAndMd5> listFromHashMd5 = getListFromHashMd5(listOfFiles);
        listFromHashMd5.stream()
                .reduce(0,
                        (x, y) -> {
                            mapMd5.put(x.getPath(), x.getMd5());
                        },
                        0);
        return mapMd5;
    }

    @Override
    public List<PathAndMd5> getListFromHashMd5(ListOfFiles listOfFiles) {
        ReadFile readFile = new ReadFileImpl();
        List<PathAndMd5> pathAndMd5 = new ArrayList<>();
        List<SizeAndPath> sizeAndPath = getListFromSizeAndPath(listOfFiles);
        Long bufferSize = -1L;
        Path bufferPath = Paths.get("");
        String code, codeBuffer;
        for (int i = 0; i < sizeAndPath.size(); i++) {
            if (sizeAndPath.get(i).getSize().equals(bufferSize)) {
                code = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(sizeAndPath.get(i).getPath()));
                pathAndMd5.add(new PathAndMd5(sizeAndPath.get(i).getPath(), code));
//                mapMd5.put(sizeAndPath.get(i).getPath(), code);
                codeBuffer = new ConvertToMd5Impl().md5ConvertToHex(readFile.getReadFile(bufferPath));
                pathAndMd5.add(new PathAndMd5(bufferPath, codeBuffer));
//                mapMd5.put(bufferPath, codeBuffer);
            }
//            bufferSize = sizeAndPath.get(i).getSize();
//            bufferPath = sizeAndPath.get(i).getPath();
        }
        return pathAndMd5;
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
        sizeAndPath.sort((o1, o2) -> {
            if ((o1.getSize() - o2.getSize()) > 0) {
                return 1;
            }
            if ((o1.getSize() - o2.getSize()) < 0) {
                return 1;
            } else {
                return 0;
            }
        });
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
