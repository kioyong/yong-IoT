package com.yong.iot;

import org.junit.Test;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ImageTest {

    @Test
    public void test(){
        System.out.println("test");
        byte[] bytes = image2byte("C:\\Users\\liangyong\\Pictures\\Camera Roll\\xianyu.jpg");
        System.out.println(bytes);
    }

    private byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }
}
