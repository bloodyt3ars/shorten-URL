package com.example.shorten_url.component;
import java.io.*;
import java.util.Base64;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
public class Tokenizer {
    public static String compressString(String text) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            deflaterOutputStream.write(text.getBytes());
            deflaterOutputStream.close();
            return Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decompressString(String compressedText) {
        try {
            byte[] compressedData = Base64.getUrlDecoder().decode(compressedText);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int data;
            while ((data = inflaterInputStream.read()) != -1) {
                byteArrayOutputStream.write(data);
            }
            inflaterInputStream.close();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String originalText = "https://hashids.org/java/";
        System.out.println("Original Text: " + originalText);

        String compressedText = compressString(originalText);
        System.out.println("Compressed Text: " + compressedText);

        String decompressedText = decompressString(compressedText);
        System.out.println("Decompressed Text: " + decompressedText);
    }
}
