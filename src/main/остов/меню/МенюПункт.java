package main.остов.меню;

import java.awt.*;

public class МенюПункт extends MenuItem {

    String имя;
    public МенюПункт(String имя) {
        setLabel(имя);
        this.имя = имя;
    }

    public String получитьИмя() {
        return имя;
    }
}
