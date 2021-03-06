package ru.asd.code;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author Zagretdinov Airat
 * @version 1.0 date 02.11.2020
 **/

public class ConvertToMd5Impl implements ConvertToMd5 {

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
            return DigestUtils.md5Hex(data);
        } catch (IOException e) {
            e.printStackTrace();
            return "Fault";
        }
    }

}
