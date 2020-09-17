package ru.asd.code;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ConvertToMd5Impl implements ConvertToMd5 {
    private InputStream data;

    @Override
    public String md5ConvertToByte(InputStream data) {
        try {
            return Arrays.toString(DigestUtils.md5(data));
        } catch (IOException e) {
            e.printStackTrace();
            return "Fault!";
        }
    }

    @Override
    public String md5ConvertToHex(InputStream data) {
        try {
            return DigestUtils.md2Hex(data);
        } catch (IOException e) {
            e.printStackTrace();
            return "Fault";
        }
    }
}
