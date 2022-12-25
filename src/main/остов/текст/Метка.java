package main.остов.текст;

import java.awt.*;

public class Метка extends Label {
    public static final int ЛЕВО       = 0;
    public static final int ЦЕНТР      = 1;
    public static final int ПРАВО      = 2;

    public Метка(String текст, int настройкаВыравнивания) {
        setText(текст);
        setAlignment(настройкаВыравнивания);
    }

    public void установитьТекст(String текст) {
        setText(текст);
    }
}
