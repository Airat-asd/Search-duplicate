package ru.asd.code;

import java.io.InputStream;

public interface ConvertToMd5 {
    String md5ConvertToByte(InputStream data);

    String md5ConvertToHex(InputStream data);
}
