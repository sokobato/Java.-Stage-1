package ru.geekbrains.lessons.g;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    private static int WIN_WIDTH; //= 507;
    public static final int GM_HVA = 0;
    public static final int GM_HVH = 1;
    //private int cellSize;
    private int componentCount;
    private JPanel mainPanel;
    private JButton buttons[];

        /*
        1. Полностью разобраться с кодом
        (попробовать полностью самостоятельно переписать одно из окон)

        2. Составить список вопросов и приложить в виде комментария к домашней работе

        3. * Рачертить панель Map на поле для игры, согласно fieldSize

        */

    Map() {
//        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int fieldSize, int winLength) {

        //зачистим все, что было
        removeAll();

        Dimension dimension = getSize();
        WIN_WIDTH = dimension.width;
        //cellSize = WIN_WIDTH / fieldSize;
        componentCount = fieldSize;

        //если эту ню не переопределить, компоновать будет как такое-себе ...
        mainPanel = new JPanel(){
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIN_WIDTH, WIN_WIDTH);
            }
        };

        GridLayout layout = new GridLayout(componentCount, componentCount);
        mainPanel.setLayout(layout);
        buttons = new JButton[componentCount * componentCount];

        for (int i = 0; i < componentCount * componentCount; i++) {
            buttons[i] = new JButton("");
            mainPanel.add(buttons[i]);
        }

        add(mainPanel);
        //перерисовка грязных регионов ... (в майне был эффект далеких краев ...)
        revalidate();
    }

}
