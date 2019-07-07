package ru.geekbrains.lessons.f;

import java.io.*;

public class FileManager {

    private static String errmess;

    public static String getErrorMessage() {
        return errmess;
    }

    private static boolean errorMessageIsEmpty() {
        return errmess.isEmpty();
    }

    private static void setErrMess(String errmess) {
        FileManager.errmess = errmess;
    }

    public static boolean createFile(String fileName, String text) {
        setErrMess("");
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.write(text);
            pw.close();

        } catch (FileNotFoundException e) {
            setErrMess(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean mergeFiles(String[] names, String outfilename) {
        setErrMess("");
        try {
            FileOutputStream fos = new FileOutputStream(outfilename);
            for (String name : names) {
                FileInputStream fis = new FileInputStream(name);
                int i;
                do {
                    i = fis.read();
                    if (i != -1) {
                        fos.write(i);
                    }
                } while (i != -1);
            }
        } catch (Exception e) {
            setErrMess(e.getMessage());
            return false;
        }
        return true;
    }

    public static int serchInFile(String fileName, String word) {
        setErrMess("");
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int symbol = 0;
            int index = 0;
            byte[] wordBytes = word.getBytes();
            int wordlen = wordBytes.length;
            do {
                symbol = fis.read();
                if (wordBytes[index] == symbol) {
                    index++;
                    if (index == wordlen) {
                        // System.out.println("Нашли слово");
                        return index - wordlen + 1;
                    }
                } else {
                    index = 0;
                }
            } while (symbol != -1);
        } catch (FileNotFoundException e) {
            setErrMess(e.getMessage());
        } catch (IOException e) {
            setErrMess(e.getMessage());
        } catch (Exception e) {
            setErrMess(e.getMessage());
        }
        return (errorMessageIsEmpty()) ? 0 : -1;
    }

    public static String getFilesNameFromFolder(String folderName) {
        setErrMess("");
        try {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < listOfFiles.length; i++) {
                sb.append(listOfFiles[i].getName() + " ");
            }
            return sb.toString();
        } catch (Exception e) {
            setErrMess(e.getMessage());
            return "";
        }
    }

    public static int findWordInFolder(String folderName, String word) {
        setErrMess("");
        try {
            String fileName = getFilesNameFromFolder(folderName);
            int result = fileName.indexOf(word);
            return (result < 0) ? 0 : result;
        } catch (Exception e) {
        setErrMess(e.getMessage());
        return -1;
    }

}
}
