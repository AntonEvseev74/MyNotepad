package main.остов.файл;

public class Файл {
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
}
