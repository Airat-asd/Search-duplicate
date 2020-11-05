package ru.asd.code;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public interface ConvertToMd5 {
    String md5ConvertToByte(InputStream data);

    String md5ConvertToHex(InputStream data);
}
