package main.остов.файл;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class ХудожникСтраницыФайла implements Printable {

    private String printData;

    public ХудожникСтраницыФайла(String printDataIn) {
        this.printData = printDataIn;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) {
        // Должна быть только одна страница, а страница # основана на нуле.
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        // Добавление "Imageable" к x и y приводит к увеличению полей на странице.
        // Чтобы сделать его безопасным для печати.
        Graphics2D g2d = (Graphics2D) g;
        int x = (int) pf.getImageableX();
        int y = (int) pf.getImageableY();
        g2d.translate(x, y);

        // Вычислите высоту линии
        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        BufferedReader br = new BufferedReader(new StringReader(printData));

        // Нарисуйте страницу:
        try {
            String line;
            // Просто подстраховка на случай, если маржа не была добавлена.
            x += 50;
            y += 50;
            while ((line = br.readLine()) != null) {
                y += lineHeight;
                g2d.drawString(line, x, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PAGE_EXISTS;
    }
}