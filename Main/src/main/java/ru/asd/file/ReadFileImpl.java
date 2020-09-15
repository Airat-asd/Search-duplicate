package ru.asd.file;

import java.io.*;
import java.nio.file.Path;

public class ReadFileImpl implements ReadFile {
    @Override
    public InputStream getReadFile(Path pathOfFile) {
        File file = new File(String.valueOf(pathOfFile.toFile()));
        if (file.exists()) {
            try {
                InputStream in =
                        new DataInputStream(
                                new BufferedInputStream(
                                        new FileInputStream(
                                                String.valueOf(pathOfFile.toFile()))));
                return in;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
