package main.программа;

import main.остов.текст.Метка;
import main.остов.текст.ТекстоваяПлощадь;
import main.остов.текст.ТекстовоеОкно;
import main.остов.файл.Файл;
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

    private Файл файл;

    private МоёМеню моёМеню;

    private ТекстовоеОкно текстовоеОкно;
    private Метка метка;
    private ТекстоваяПлощадь текстоваяПлощадь;

    public ГлавноеОкно() throws HeadlessException {
        установитьЗаголовокОкна(имяПрограммы);
        установитьКнопкуЗакрытияОкна();
        установитьРазмерОкна(ширинаОкна, высотаОкна);

        файл = new Файл(null);

        //меню
        моёМеню = new МоёМеню(this, файл);
        установитьМенюБар(моёМеню.получитьМенюБар());

        //окно для ввода текста
        добавитьТекстовоеОкно();

        setLayout(null);

        установитьВидимостьОкна(true);
    }

    public void добавитьТекстовоеОкно() {
        текстовоеОкно = new ТекстовоеОкно(ширинаОкна, высотаОкна);
        метка = (Метка) текстовоеОкно.получитьМетку();
        add(метка);
        текстоваяПлощадь = (ТекстоваяПлощадь) текстовоеОкно.получитьТекстовуюПлощадь();
        add(текстоваяПлощадь);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        моёМеню.actionPerformed(e);
    }

    public ТекстоваяПлощадь получитьТекстовуюПлощадь() {
        return текстоваяПлощадь;
    }

    private void установитьЗаголовокОкна(String заголовок) {
        setTitle(заголовок);
    }

    private void установитьКнопкуЗакрытияОкна() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                моёМеню.закрытьПрограмму();
            }
        });
    }

    private void установитьРазмерОкна(int ширина, int высота) {
        setSize(ширина, высота);
    }

    private void установитьВидимостьОкна(boolean этоВидимое) {
        setVisible(этоВидимое);
    }

    public void установитьМенюБар(MenuBar мб) {
        setMenuBar(мб);
    }
}
