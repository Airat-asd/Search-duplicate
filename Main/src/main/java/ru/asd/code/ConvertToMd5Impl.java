package ru.asd.code;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;

public class ConvertToMd5Impl implements ConvertToMd5 {
    private InputStream data;

    @Override
    public byte[] md5ConvertToByte(InputStream data) {
        try {
            return DigestUtils.md5(data);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[]{0};
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
