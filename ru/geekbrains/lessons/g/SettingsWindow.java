package ru.geekbrains.lessons.g;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;//230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";
    private static int gameMode;
    private static int fieldSize;
    private static int winLen;

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    SettingsWindow(GameWindow gameWindow) {
        SetDefaulthSetting();
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));
        addGameModeControls();
        addFieldControls();
        JButton btnAccept = new JButton("Accept changes");
        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAcceptClick();
            }
        });

        JButton btnReset = new JButton("Default setting");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnResetClick();
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnAccept);
        panelBottom.add(btnReset);
       // panelBottom.add(btnCancel);

        add(panelBottom, BorderLayout.SOUTH);

        //add(btnAccept);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose gaming mode"));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControls() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });
        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void btnAcceptClick() {
        //int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.GM_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.GM_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        fieldSize = slideFieldSize.getValue();
        winLen = slideWinLen.getValue();

       // gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);

        setVisible(false);
    }

    private void btnResetClick() {
        SetDefaulthSetting();
        slideWinLen.setValue(winLen);
        slideFieldSize.setValue(fieldSize);
        humVSAI.setSelected(true);
        //setVisible(false);
    }

    private void SetDefaulthSetting() {
        gameMode = Map.GM_HVA;
        fieldSize = MIN_FIELD_SIZE;
        winLen = MIN_WIN_LENGTH;
    }

    public static int getFieldSize() {
        return fieldSize;
    }

    public static int getGameMode() {
        return gameMode;
    }

    public static int getWinLen() {
        return winLen;
    }
}
