package com.revature;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ImgDataHelper {
    public static byte[] getByteArray(InputStream is) throws Exception {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        BufferedOutputStream os = new BufferedOutputStream(b);
        while (true) {
            int i = is.read();
            if (i == -1) break;
            os.write(i);
        }
        os.flush();
        os.close();
        return b.toByteArray();
    }

}
