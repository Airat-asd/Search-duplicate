package ru.asd.file;

import java.io.InputStream;
import java.nio.file.Path;

public interface ReadFile {
    InputStream getReadFile(Path file);

}
