package org.example.utils;

import java.io.*;

public class FileUtils {

    public static String basePath = "D:\\BankData\\";

    public static void writeObjectToFile(String filename, Serializable object) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(basePath+filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Exception occurred!");
        }
    }

    public static Object readObjectFromFile(String filename) throws IOException, ClassNotFoundException{
            FileInputStream fileInputStream = new FileInputStream(basePath+filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
    }
}
