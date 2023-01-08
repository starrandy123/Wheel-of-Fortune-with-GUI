import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class GUI {

    JFrame WheelFrame;
    static JFrame frame;
    JPanel panel1;                                 //Intro panel (game title, asks player count)
    JPanel panel2;
    JToggleButton audio;                           //Actual game panel

    boolean playerchoice;
    private String Sentence;                       //Sentence to be found
    private String Progress;                       //How much of the sentence players have uncovered
    static int players;
    static int audioi = 1;

    public GUI(){

        frame = new JFrame("Wheel of Fortune");
        frame.setSize(930,480);                                                    //Jframe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());                 //Intro jpanel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.NORTHEAST;
        panel1.setBackground(Color.BLACK);

        JLabel img = new JLabel();
        URL uWheel = this.getClass().getResource("images/wheel-of-fortune-logo.jpg");
        ImageIcon iconLogo = new ImageIcon(uWheel);    //Adds intro image
        img.setIcon(iconLogo);
        panel1.add(img,c);

        URL uI1= this.getClass().getResource("images/b1.png");
        ImageIcon icon1 = new ImageIcon(uI1);

        URL uI2= this.getClass().getResource("images/b2.png");
        ImageIcon icon2 = new ImageIcon(uI2);

        URL uI3= this.getClass().getResource("images/b3.png");
        ImageIcon icon3 = new ImageIcon(uI3);

        URL uI4= this.getClass().getResource("images/b4.png");
        ImageIcon icon4 = new ImageIcon(uI4);

        URL uI5= this.getClass().getResource("images/b5.png");
        ImageIcon instruction = new ImageIcon(uI5);

        URL uI6= this.getClass().getResource("images/b6.png");
        ImageIcon iconx = new ImageIcon(uI6);

        URL uI7= this.getClass().getResource("images/b7.png");
        ImageIcon icon7 = new ImageIcon(uI7);

        URL uI8= this.getClass().getResource("images/b8.png");
        ImageIcon icon8 = new ImageIcon(uI8);                     //PRESSED BUTTON ICONS

        URL uI9= this.getClass().getResource("images/b9.png");
        ImageIcon icon9 = new ImageIcon(uI9);

        URL uI10= this.getClass().getResource("images/b10.png");
        ImageIcon icon10 = new ImageIcon(uI10);

        URL uS2= this.getClass().getResource("images/start2.png");
        ImageIcon start2 = new ImageIcon(uS2);

        URL uI11= this.getClass().getResource("images/b11.png");
        ImageIcon icon11 = new ImageIcon(uI11);

        URL uI12= this.getClass().getResource("images/b12.png");
        ImageIcon icon12 = new ImageIcon(uI12);

        JToggleButton audio = new JToggleButton(icon11);
        audio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {              //audiobutton
                if(audioi % 2 == 0){
                    audio.setIcon(icon11);
                    WheelOfFortune.sb.startmusic();
                    WheelOfFortune.sb.music();
                }

                else if(audioi % 2 == 1){
                    audio.setIcon(icon12);
                    WheelOfFortune.sb.stopmusic();
                    WheelOfFortune.sb.stopmainmusic();
                }
                audioi++;
            }
        });

        ButtonGroup group = new ButtonGroup();
        JToggleButton button1 = new JToggleButton(icon1);
        JToggleButton button2 = new JToggleButton(icon2);
        JToggleButton button3 = new JToggleButton(icon3);
        JToggleButton button4 = new JToggleButton(icon4);
        group.add(button1);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerchoice = true;
                button1.setSelected(true);
                button1.setIcon(iconx);
                button2.setIcon(icon2);
                button3.setIcon(icon3);
                button4.setIcon(icon4);
                players = 1;
                WheelOfFortune.sb.buttonpress();
            }
        });
        group.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players = 2;
                playerchoice = true;
                button2.setIcon(icon7);
                button1.setIcon(icon1);
                button3.setIcon(icon3);
                button4.setIcon(icon4);
                WheelOfFortune.sb.buttonpress();
            }
        });
        group.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                 //Button functions for player count
                players = 3;
                playerchoice = true;
                button3.setIcon(icon8);
                button1.setIcon(icon1);
                button2.setIcon(icon2);
                button4.setIcon(icon4);
                WheelOfFortune.sb.buttonpress();
            }
        });
        group.add(button4);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players = 4;
                playerchoice = true;
                button4.setIcon(icon9);
                button1.setIcon(icon1);
                button3.setIcon(icon3);
                button2.setIcon(icon2);
                WheelOfFortune.sb.buttonpress();
            }
        });

        JButton button5 = new JButton(instruction);
        button1.setRolloverIcon(iconx);
        button1.setPressedIcon(iconx);
        button2.setRolloverIcon(icon7);
        button2.setPressedIcon(icon7);
        button3.setRolloverIcon(icon8);
        button3.setPressedIcon(icon8);
        button4.setRolloverIcon(icon9);
        button4.setPressedIcon(icon9);
        button5.setRolloverIcon(icon10);

        button1.setBorder(BorderFactory.createEmptyBorder());
        button2.setBorder(BorderFactory.createEmptyBorder());
        button3.setBorder(BorderFactory.createEmptyBorder());

        button4.setBorder(BorderFactory.createEmptyBorder());
        button5.setBorder(BorderFactory.createEmptyBorder());
        button1.setContentAreaFilled(false);
        button2.setContentAreaFilled(false);
        button3.setContentAreaFilled(false);
        button4.setContentAreaFilled(false);
        button5.setContentAreaFilled(false);                          //Generating buttons
        audio.setBorder(BorderFactory.createEmptyBorder());
        audio.setContentAreaFilled(false);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setPreferredSize(new Dimension(48, 480));
        panel2.add(audio);
        panel2.add(Box.createRigidArea(new Dimension(0, 120)));
        panel2.add(button5);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);

        URL ic6= this.getClass().getResource("images/button_start.png");
        ImageIcon icon6 = new ImageIcon(ic6);
        JButton start = new JButton(icon6);
        start.setPressedIcon(start2);
        start.setRolloverIcon(start2);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(playerchoice == false) return;
                WheelOfFortune.sb.startpress();                       //starts the actual game
                frame.setVisible(false);
                MainGUI newgame = new MainGUI();
                try {
                    newgame.gameready();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        start.setBorder(BorderFactory.createEmptyBorder());
        start.setContentAreaFilled(false);
        c.gridx = 9;
        c.gridy = 3;
        panel2.add(start);
        panel1.add(panel2,c);

        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                WheelOfFortune.sb.buttonpress();
                JLabel bl = new JLabel();

                URL iPage= this.getClass().getResource("images/backg.png");
                ImageIcon instPage = new ImageIcon(iPage);
                bl.setIcon( instPage );

                JLayeredPane lp = new JLayeredPane();
                lp.setPreferredSize(new Dimension( 930, 480));
                lp.setLayout(null);

                JPanel layerone = new JPanel();
                bl.setBounds(0,0, 930, 480);
                layerone.add(bl);
                layerone.setBounds(0,0, 930, 480);
                layerone.setOpaque(true);
                lp.add(layerone, 1, 0 );
                frame.setContentPane(lp);
                frame.revalidate();

                URL i15= this.getClass().getResource("images/back.png");
                ImageIcon icon15 = new ImageIcon(i15);                   //moved to here because panel1 needed  to be finished first

                URL i16= this.getClass().getResource("images/back2.png");
                ImageIcon icon16 = new ImageIcon(i16);
                //shows the instructions page
                final JButton button6;
                button6 = new JButton(icon15);
                button6.setBounds(15,15,25,39);
                button6.setBorder(BorderFactory.createEmptyBorder());
                button6.setContentAreaFilled(false);
                button6.setRolloverIcon(icon16);
                lp.add(button6,JLayeredPane.PALETTE_LAYER);
                button6.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frame.setContentPane(panel1);
                        WheelOfFortune.sb.buttonpress();
                    }
                });
            }
        });

        frame.setContentPane(panel1);
        frame.setVisible(true);
    }
};
