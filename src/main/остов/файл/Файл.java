package main.остов.файл;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Файл  {
    private String полноеИмя;

    public Файл(String полноеИмя) {
        this.полноеИмя = полноеИмя;
    }

    public String получитьПолноеИмя() {
        return  полноеИмя;
    }

    public void установитьПолноеИмя(String полноеИмя) {
        this.полноеИмя = полноеИмя;
    }

    @Override
    public String toString(){
        StringBuilder текст = new StringBuilder();
        if (полноеИмя != null) {
            if (полноеИмя.contains(".txt")) {
                try (BufferedReader буферЧтения = new BufferedReader(new FileReader(полноеИмя))) {
                    //чтение построчно
                    String строка;
                    while ((строка = буферЧтения.readLine()) != null) {
                        текст.append(строка);
                        текст.append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return текст.toString();
    }
}
