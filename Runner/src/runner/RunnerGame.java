package runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunnerGame extends JApplet implements ActionListener {

    private final int BOARDWIDTH = 300, BOARDHEIGHT = 400;
    private JButton startRun;
    private RunnerPanel game;
    private JPanel appletPanel, button;

    public void init()
    {
        button = new JPanel();
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(BOARDWIDTH, 40));
        button.setBackground(Color.white);

        startRun = new JButton("Start Race");
        startRun.setBackground(Color.cyan);
        startRun.addActionListener(this);

        button.add(startRun);

        game = new RunnerPanel();
        appletPanel = new JPanel();
        appletPanel.add(button);
        appletPanel.add(game);

        getContentPane().add(appletPanel);
        setSize(BOARDWIDTH, BOARDHEIGHT);
    }

    public void actionPerformed (ActionEvent event)
    {
        if(event.getSource() == startRun)
        {
            startRun.setEnabled(false);
            game.startRace();
            repaint();
        }
    }
}
