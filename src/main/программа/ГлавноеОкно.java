package main.программа;

import main.программа.мое_меню.МоёМеню;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ГлавноеОкно extends Frame implements ActionListener {
    private String имяПрограммы = "Блокнот";
    private int ширинаОкна = 500;
    private int высотаОкна = 500;

    private МоёМеню моёМеню;

    public ГлавноеОкно() throws HeadlessException {
        установитьЗаголовокОкна(имяПрограммы);
        установитьКнопкуЗакрытияОкна();
        установитьРазмерОкна(ширинаОкна, высотаОкна);
        установитьВидимостьОкна(true);

        моёМеню = new МоёМеню(this);
        установитьМенюБар(моёМеню.получитьМенюБар());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void установитьЗаголовокОкна(String заголовок) {
        setTitle(заголовок);
    }

    private void установитьКнопкуЗакрытияОкна() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void установитьРазмерОкна(int ширина, int высота) {
        setSize(ширина, высота);
    }

    private void установитьВидимостьОкна(boolean этоВидимое) {
        setVisible(этоВидимое);
    }

    public void установитьМенюБар(MenuBar мб){
        setMenuBar(мб);
    }
}
