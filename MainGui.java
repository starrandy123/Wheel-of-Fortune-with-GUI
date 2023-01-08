import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

class MainGUI extends GUI{
    static int turn;
    private String Sentence;
    static int players;
    static PlayerBar pb;
    static WheelPanel w;
    static GuessBar gb;
    static boolean buttons = true;

    WordPanel wp;
    JPanel wf;

    void gameready() throws IOException {
        WheelOfFortune.sb.stopmainmusic();
        WheelOfFortune.sb.music2();
        turn = 0;
        GUI.frame.getContentPane().removeAll();
        players = GUI.players;
        wp = new WordPanel();
        w = new WheelPanel();
        GUI.frame.setTitle("Wheel Of Fortune");
        GUI.frame.setBackground(Color.BLACK);

        wf = new JPanel();
        wf.setBackground(Color.BLACK);
        wf.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        pb = new PlayerBar();
        pb.setPreferredSize(new Dimension(130,550));
        wf.add(pb,c);
        c.insets = new Insets(25,100,0,0);
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 0;
        w.setPreferredSize(new Dimension(510,510));
        wf.add(w, c);
        c.gridx = 1;
        c.gridy = 1;

        wp.setPreferredSize(new Dimension(510, 20));
        gb = new GuessBar();
        wf.add(gb, c);

        c.gridx = 1;
        c.gridy = 2;
        wp.setPreferredSize(new Dimension(550, 200));
        wf.add(wp, c);

        c.insets = new Insets(25,70,0,0);
        c.gridheight = 3;
        c.gridx = 2;
        c.gridy = 0;
        OtherBar zb = new OtherBar();
        zb.setPreferredSize(new Dimension(110,550));
        wf.add(zb,c);
        GUI.frame.setLayout(new BorderLayout());
        GUI.frame.add(wf, BorderLayout.CENTER);
        GUI.frame.pack();
        GUI.frame.setLocationRelativeTo(null);
        GUI.frame.setVisible(true);
        GUI.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void gameended(){
       EndBar end = new EndBar();
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.CENTER;
       c.gridx = 1;
       c.gridy = 1;
       end.setPreferredSize(new Dimension(510,60));
       wf.remove(gb);
       wf.add(end, c);
    }

class PlayerBar extends JPanel{
   static int playercount;
   int audioj = 1;
   JLabel[] labels = new JLabel[5];
   Player [] players;

   URL url1 = this.getClass().getResource("images/b12.png");
   URL url2 = this.getClass().getResource("images/b11.png");
   ImageIcon icon12 = new ImageIcon(url1);
   ImageIcon icon11 = new ImageIcon(url2);

   PlayerBar(){
      setBackground(Color.BLACK);
      playercount = MainGUI.players;
      players = new Player[playercount];
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      JToggleButton audio = new JToggleButton(icon11);
      audio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {              //audiobutton
               if(audioj % 2 == 0){
                    audio.setIcon(icon11);
                     WheelOfFortune.sb.startmusic();
                     WheelOfFortune.sb.music2();
                }

                else if(audioj % 2 == 1){
                    audio.setIcon(icon12);
                     WheelOfFortune.sb.stopmusic();
                     WheelOfFortune.sb.stopmainmusic2();
                }
                audioj++;
            }
        });
      audio.setPreferredSize(new Dimension(30, 200));
      audio.setBorder(BorderFactory.createEmptyBorder());
      audio.setContentAreaFilled(false);
      add(audio);


      for(int j = 0; j < playercount; j++){
         players[j] = new Player();
      }
      labels[0] = new JLabel("TURN: P1");

      for(int i = 0; i < playercount; i++){
         labels[i] = new JLabel("P" + (i+1) + ":" + " " + players[i].getpoints());
         labels[i].setFont(new Font("Verdana", Font.BOLD, 22));
         labels[i].setForeground(Color.white);
         labels[i].setPreferredSize(new Dimension(150, 200));
         add(labels[i]);
      }
    }

    void update(){
       removeAll();
      JToggleButton audio = new JToggleButton(icon11);
      audio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {              //audiobutton
               if(audioj % 2 == 0){
                    audio.setIcon(icon11);
                     WheelOfFortune.sb.startmusic();
                     WheelOfFortune.sb.music2();
                }

                else if(audioj % 2 == 1){
                    audio.setIcon(icon12);
                     WheelOfFortune.sb.stopmusic();
                     WheelOfFortune.sb.stopmainmusic2();
                }
                audioj++;
            }
        });
      audio.setPreferredSize(new Dimension(150, 200));
      audio.setBorder(BorderFactory.createEmptyBorder());
      audio.setContentAreaFilled(false);
      add(audio);
       for(int i = 0; i < playercount; i++){
         labels[i] = new JLabel("P" + (i+1) + ":" + " " + players[i].getpoints());
         labels[i].setFont(new Font("Verdana", Font.BOLD, 22));
         labels[i].setForeground(Color.white);
         labels[i].setPreferredSize(new Dimension(150, 200));
         add(labels[i]);
      }
      revalidate();
    }
}

class OtherBar extends JPanel{
   JButton guess;
   static JLabel turn;
   OtherBar() throws IOException {
      setBackground(Color.BLACK);
      turn =  new JLabel();
      turn.setText("    P1:");
      turn.setFont(new Font("Verdana", Font.BOLD, 22));
      turn.setForeground(Color.white);
      turn.setPreferredSize(new Dimension(105, 30));
      JLabel turn2 = new JLabel("   Pick a letter");
      turn2.setFont(new Font("Verdana", Font.BOLD, 11));
      turn2.setForeground(Color.white);
      turn2.setPreferredSize(new Dimension(105, 30));

      add(turn);
      add(turn2);

      JTextField lletter = new JTextField();
      lletter.setPreferredSize(new Dimension(50, 30));
      add(lletter);
      lletter.addKeyListener(new java.awt.event.KeyAdapter() {

     public void keyTyped(java.awt.event.KeyEvent evt) {
        if(lletter.getText().length() == 0) return;
        if(lletter.getText().length()>=1 &&! (evt.getKeyChar()==KeyEvent.VK_DELETE ||
        evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();
         }
     }
     });


      URL url3 = this.getClass().getResource("images/ok1.png");
      URL url4 = this.getClass().getResource("images/ok2.png");
      ImageIcon icon1 = new ImageIcon(url3);
      ImageIcon icon2 = new ImageIcon(url4);
      JButton ok = new JButton(icon1);
      ok.setRolloverIcon(icon2);
      ok.setPressedIcon(icon2);
      ok.setBorder(BorderFactory.createEmptyBorder());
      ok.setContentAreaFilled(false);
      ok.setPreferredSize(new Dimension(82, 30));
      ok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            WheelOfFortune.sb.buttonpress();
            if (w.hasspun == false || MainGUI.buttons == false){
               return;
           }
           w.hasspun = false;
            if(lletter.getText().length() == 0) return;

            String input = lletter.getText();
            Character c = input.charAt(0);
            char upc = Character.toUpperCase(c);
            boolean nextmove = wp.guess(upc);

            if (nextmove == true){
              System.out.println("Game over");
              gameended();
              WheelOfFortune.sb.win();
            }
            MainGUI.turn++;
            if(MainGUI.turn == players){
                MainGUI.turn = 0;
            }
            if(MainGUI.players > 1) turn.setText("    P" + (MainGUI.turn+1) + ":");
            if(MainGUI.players == 1) turn.setText("    P1:");
            revalidate();
         }
      });
      add(ok);

       JLabel Points = new JLabel();
       Points.setPreferredSize(new Dimension(50,50));
       Points.setOpaque(false);
       Points.setFont(new Font("Verdana",Font.PLAIN,15));
       Points.setForeground(Color.RED);


       URL url5 = this.getClass().getResource("images/spin1.png");
       URL url6 = this.getClass().getResource("images/spin2.png");
       ImageIcon icon = new ImageIcon(url5);
       ImageIcon icon2S = new ImageIcon(url6);

       JButton spin;
       spin = new JButton(icon);
       spin.setPressedIcon(icon2S);
       spin.setFocusable(false);
       spin.setOpaque(false);
       spin.setRolloverIcon(icon2S);
       spin.setBorder(BorderFactory.createEmptyBorder());
       spin.setContentAreaFilled(false);
       spin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(w.ispin == true || w.hasspun == true){
                   return;
               }
               w.ispin = true;
               WheelOfFortune.sb.buttonpress();
               WheelOfFortune.sb.spinning();
               Timer time= new Timer();
               TimerTask t= new TimerTask() {
                   int tiime = 0;
                   double a=0;
                   double d=15;
                   int Spins= (int)(Math.random()*(84-60))+60;
                   @Override
                   public void run() {
                       tiime++;
                       a+=d;
                       w.rotatedWheel= w.spinWheel(w.Wheel,a);
                       Points.setText(String.valueOf(((tiime-1)*15)%360));
                       w.repaint();
                       if(tiime > Spins){
                           w.ispin = false;
                           WheelOfFortune.sb.endspin();
                           time.cancel();
                           time.purge();
                           w.PlayerPoint(tiime,Spins);
                           Points.setText(String.valueOf((w.GetPlayerPoint(tiime,Spins))));
                           w.hasspun = true;
                           return;
                       }
                   }
               };
               time.schedule(t,1,40);
         }
       });
       add(spin);
       add(Box.createRigidArea(new Dimension(0, 200)));
       add(Points);
    }
}

class GuessBar extends JPanel{
   GuessBar(){
   setBackground(Color.BLACK);
   setLayout(new FlowLayout());

   URL url7 = this.getClass().getResource("images/guess1.png");
   URL url8 = this.getClass().getResource("images/guess2.png");
   ImageIcon icon2 = new ImageIcon(url7);
   ImageIcon icon4 = new ImageIcon(url8);
   JButton guess = new JButton(icon2);
   guess.setRolloverIcon(icon4);
   guess.setPressedIcon(icon4);
   guess.setBorder(BorderFactory.createEmptyBorder());
   guess.setContentAreaFilled(false);
   guess.setPreferredSize(new Dimension(82, 30));
   JTextField tf = new JTextField(25);
   guess.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
           if (w.hasspun == false){
               return;
           }
           w.hasspun = false;
           WheelOfFortune.sb.buttonpress();

           String input = tf.getText();
           tf.setText("");

           if(input.toUpperCase().equals(WordPanel.sentence)){
               wp.finishwp();
               WheelOfFortune.sb.win();
               gameended();
           }
           MainGUI.turn++;

           if(w.getpoint() == 0){
               MainGUI.turn++;
           }
           if(MainGUI.turn == players){
                MainGUI.turn = 0;
                if(players == 1){
                   MainGUI.turn = 0;
                }
            }
           OtherBar.turn.setText("    P" + (MainGUI.turn+1) + ":");
         }
         });
   this.add(guess);
   add(tf);
   }
}
}

class EndBar extends JPanel{
    JLabel winner;
    EndBar(){
      MainGUI.buttons = false;
      setLayout(new FlowLayout(FlowLayout.CENTER));
      setBackground(Color.BLACK);
      winner = new JLabel("P" + (MainGUI.turn + 1)+ " WINS THE GAME WITH " + MainGUI.pb.players[MainGUI.turn].
      getpoints() + " POINTS!");
      winner.setFont(new Font("Verdana", Font.BOLD, 18));
      winner.setForeground(Color.white);
      add(winner);
    };
};


class Player{
    Player(){points = 0;};
    private int points;

    int getpoints(){
      return points;
    }
    void addpoints(int p){
      points += p;
    }
};

