package com.bkb.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionJFrameWithToolbar extends JFrame{

    private ImageIcon newFileImage = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/newFile.png");
    private ImageIcon openFileImage = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/openFile.png");
    private ImageIcon saveFileImage = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/saveFile.png");
    private ImageIcon cutImage = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/cutImage.png");
    private ImageIcon copyImage = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/copyImage.png");
    private ImageIcon pasteImage = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/pasteImage.png");
    private ImageIcon itCrowdGif = new ImageIcon("/home/bariskbayram/Masaüstü/SwingExample1/src/main/resources/itcrowd.gif");
    private JLabel statusBar = new JLabel("Status: Ready!");
    private JTextArea textArea = new JTextArea("Text");
    private JButton itCrowd = new JButton(itCrowdGif);
    private JMenuBar menuBar = new JMenuBar();
    private JToolBar toolBar = new JToolBar();
    private JButton newButton = new JButton(newFileImage);
    private JButton openButton = new JButton(openFileImage);
    private JButton saveButton = new JButton(saveFileImage);


    public ActionJFrameWithToolbar(){
        setBounds(100,100,640,480);
        setLayout(new BorderLayout());
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        putActions();

        add(toolBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(itCrowd, BorderLayout.AFTER_LINE_ENDS);
        add(statusBar, BorderLayout.PAGE_END);

    }

    private void putActions(){

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);
        newItem.addActionListener(ActionEvent -> statusBar.setText("'New' executed!"));
        toolBar.add(newButton);
        newButton.addActionListener(ActionEvent -> statusBar.setText("'New' executed!"));

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.addActionListener(ActionEvent -> statusBar.setText("'Open' executed!"));
        toolBar.add(openButton);
        openButton.addActionListener(ActionEvent -> statusBar.setText("'Open' executed!"));

        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.addActionListener(ActionEvent -> statusBar.setText("'Save' executed!"));
        toolBar.add(saveButton);
        saveButton.addActionListener(ActionEvent -> statusBar.setText("'Save' executed!"));

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        Action openAction = new AbstractAction("Cut", cutImage) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statusBar.setText("'Cut' executed!");
            }
        };
        openAction.putValue(Action.SHORT_DESCRIPTION, "Performs cutting.");
        editMenu.add(openAction);
        toolBar.add(openAction);

        Action copyAction = new AbstractAction("Copy", copyImage) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statusBar.setText("'Copy' executed!");;
            }
        };
        copyAction.putValue(Action.SHORT_DESCRIPTION, "Performs copying.");
        editMenu.add(copyAction);
        toolBar.add(copyAction);

        Action pasteAction = new AbstractAction("Paste", pasteImage) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statusBar.setText("'Paste' executed!");;
            }
        };
        pasteAction.putValue(Action.SHORT_DESCRIPTION, "Performs pasting.");
        editMenu.add(pasteAction);
        toolBar.add(pasteAction);

        itCrowd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statusBar.setText("BURNED!");
                JOptionPane.showMessageDialog(itCrowd, "Have you tried turning it of and on again?");
            }
        });

    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        ActionJFrameWithToolbar actionJFrameWithToolbar = new ActionJFrameWithToolbar();
        actionJFrameWithToolbar.setVisible(true);
    }
}
