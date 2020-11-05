package ru.asd.data;

import java.nio.file.Path;
import java.util.Objects;

/**
 * @author Ayrat Zagretdinov
 * created on 05.11.2020
 */
public class PathAndMd5 {
    private Path path;
    private String md5;

    public PathAndMd5(Path path, String md5) {
        this.path = path;
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "PathAndMd5{" +
                "path=" + path +
                ", md5='" + md5 + '\'' +
                '}'  + "/\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathAndMd5)) return false;
        PathAndMd5 that = (PathAndMd5) o;
        return path.equals(that.path) &&
                md5.equals(that.md5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, md5);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
