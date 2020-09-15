package ru.asd.code;

import java.io.InputStream;

public interface ConvertToMd5 {
    byte[] md5ConvertToByte(InputStream data);

    String md5ConvertToHex(InputStream data);
}
