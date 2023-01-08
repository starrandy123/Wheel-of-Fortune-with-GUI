import java.net.URL;
import java.lang.Math.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
class WordPanel extends JPanel{

    void main(){};
    static boolean wheelspun;
    static String sentence;
    JLabel[] tiles1 = new JLabel[12];
    JLabel[] tiles2 = new JLabel[12];
    JLabel[] tiles3 = new JLabel[14];
    JLabel[] tiles4 = new JLabel[14];                                   //arrays for logic of each row of wordpanel

    JPanel row1 = new JPanel(new FlowLayout());
    JPanel row2 = new JPanel(new FlowLayout());
    JPanel row3 = new JPanel(new FlowLayout());
    JPanel row4 = new JPanel(new FlowLayout());

    URL url1 = this.getClass().getResource("images/A.png");
    URL url2 = this.getClass().getResource("images/B.png");
    URL url3 = this.getClass().getResource("images/C.png");
    URL url4 = this.getClass().getResource("images/D.png");
    URL url5 = this.getClass().getResource("images/E.png");
    URL url6 = this.getClass().getResource("images/F.png");
    URL url7 = this.getClass().getResource("images/G.png");
    URL url8 = this.getClass().getResource("images/H.png");
    URL url9 = this.getClass().getResource("images/I.png");
    URL url10 = this.getClass().getResource("images/J.png");
    URL url11 = this.getClass().getResource("images/K.png");
    URL url12 = this.getClass().getResource("images/L.png");
    URL url13 =this.getClass().getResource("images/M.png");
    URL url14 = this.getClass().getResource("images/N.png");
    URL url15 = this.getClass().getResource("images/O.png");
    URL url16 = this.getClass().getResource("images/P.png");
    URL url17 = this.getClass().getResource("images/Q.png");
    URL url18 = this.getClass().getResource("images/R.png");
    URL url19 = this.getClass().getResource("images/S.png");
    URL url20 = this.getClass().getResource("images/T.png");
    URL url21 = this.getClass().getResource("images/U.png");
    URL url22 = this.getClass().getResource("images/V.png");
    URL url23 = this.getClass().getResource("images/W.png");
    URL url24 = this.getClass().getResource("images/X.png");
    URL url25 = this.getClass().getResource("images/Y.png");
    URL url26 = this.getClass().getResource("images/Z.png");
    URL url27 = this.getClass().getResource("images/BLANK.png");
    URL url28 = this.getClass().getResource("images/BLANK2.png");
    ImageIcon A1 = new ImageIcon(url1);
    ImageIcon B1 = new ImageIcon(url2);
    ImageIcon C1 = new ImageIcon(url3);
    ImageIcon D1 = new ImageIcon(url4);
    ImageIcon E1 = new ImageIcon(url5);
    ImageIcon F1 = new ImageIcon(url6);
    ImageIcon G1 = new ImageIcon(url7);
    ImageIcon H1 = new ImageIcon(url8);                        //images for letters of the alphabet
    ImageIcon I1 = new ImageIcon(url9);
    ImageIcon J1 = new ImageIcon(url10);
    ImageIcon K1 = new ImageIcon(url11);
    ImageIcon L1 = new ImageIcon(url12);
    ImageIcon M1 = new ImageIcon(url13);
    ImageIcon N1 = new ImageIcon(url14);
    ImageIcon O1 = new ImageIcon(url15);
    ImageIcon P1 = new ImageIcon(url16);
    ImageIcon Q1 = new ImageIcon(url17);
    ImageIcon R1 = new ImageIcon(url18);
    ImageIcon S1 = new ImageIcon(url19);
    ImageIcon T1 = new ImageIcon(url20);
    ImageIcon U1 = new ImageIcon(url21);
    ImageIcon V1 = new ImageIcon(url22);
    ImageIcon W1 = new ImageIcon(url23);
    ImageIcon X1 = new ImageIcon(url24);
    ImageIcon Y1 = new ImageIcon(url25);
    ImageIcon Z1 = new ImageIcon(url26);
    ImageIcon BLANK1 = new ImageIcon(url27);
    ImageIcon BLANK2 = new ImageIcon(url28);

    WordPanel() throws IOException {

        row1.setBackground(Color.BLACK);
        row2.setBackground(Color.BLACK);
        row3.setBackground(Color.BLACK);
        row4.setBackground(Color.BLACK);

        System.out.println(sl);

        InputStream input = getClass().getResourceAsStream("Sentence.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        ArrayList<String> FileLines = new ArrayList<String>();
        String lineRead = reader.readLine();
        while(lineRead!=null){
            FileLines.add(lineRead);
            lineRead=reader.readLine();
        }
        Random r= new Random();
        sentence = (String) FileLines.get(r.nextInt(FileLines.size())); //this is the random sentence from file
        System.out.println(sentence);

        sl = sentence.length();
        for(int q = 0; q < sentence.length(); q++){
           if(sentence.charAt(q) == ' '){
              sl--;
           }
        }

        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NORTHEAST;

        keylayout();
        setdefault();
        for(int i = 0; i < 12; i ++){
           row1.add(tiles1[i]);
        }
        for(int j = 0; j < 14; j ++){
           row3.add(tiles3[j]);
        }
        for(int k = 0; k < 14; k ++){                     //initializes the char arrays that control word bank
           row4.add(tiles4[k]);
        }
        for(int l = 0; l < 12; l ++){
           row2.add(tiles2[l]);
        }

        add(row1,c);
        c.gridx = 0;
        c.gridy = 1;
        add(row3,c);
        c.gridx = 0;
        c.gridy = 2;
        add(row4,c);
        c.gridx = 0;
        c.gridy = 3;
        add(row2,c);
    }

    char[] r1 = new char[12];
    char[] r2 = new char[12];
    char[] r3 = new char[14];
    char[] r4 = new char[14];
    int ii = 0;

    void keylayout(){
        double rows = sentence.length();
        rows = Math.ceil(rows / 12);
        System.out.println(rows);

        if(rows == 2){
        for(int j = 0;  j < 14; j ++){
           if(ii >= sentence.length()){ return;}
           r3[j] = sentence.charAt(ii);
           ii++;
           }
           for(int k = 0;  k < 14; k ++){
           if(ii >= sentence.length()){ return;}                 //initializes word bank with white spaces and blanks
           r4[k] = sentence.charAt(ii);
           ii++;
           }
        }

        if(rows >= 0){
        for(ii = 0;  ii < 12; ii ++){
           if(ii >= sentence.length()) {return;}
           r1[ii] = sentence.charAt(ii);
        }
        }

        if(rows > 1){
        for(int j = 0;  j < 14; j ++){
           if(ii >= sentence.length()){ return;}
           r3[j] = sentence.charAt(ii);
           ii++;
        }
        }

        if(rows > 2){
        for(int k = 0;  k < 14; k ++){
           if(ii >= sentence.length()){ return;}
           r4[k] = sentence.charAt(ii);
           ii++;
        }
        }

        if(rows > 3){
        for(int l = 0;  l < 12; l++){
           if(ii >= sentence.length()) {return;}
           r2[l] = sentence.charAt(ii);
           ii++;
        }
        }

    }
    void setdefault(){
       for( int m = 0; m < 12;  m++){
          tiles1[m]  =  charchooser1(r1[m]);
       }
       for( int j = 0; j < 14;  j++){
          tiles3[j]  =  charchooser1(r3[j]);                  //initializes word bank
       }
       for( int k = 0; k < 14;  k++){
          tiles4[k]  =  charchooser1(r4[k]);
       }
       for( int l = 0; l < 12;  l++){
          tiles2[l]  =  charchooser1(r2[l]);
       }
    }
    JLabel charchooser1(char c){
       if(c == '$'){
          return(new JLabel(BLANK1));
       }
       else if(c == ' '){
          return(new JLabel(BLANK1));                      //for initialization, only contains blanks
       }
       else if( Character.isLetter(c)){
          return(new JLabel(BLANK2));
       }
       else return(new JLabel(BLANK1));

    }
    JLabel charchooser2(char c){
       switch(c){
          case  'A':   return(new JLabel(A1));
          case  'B':   return(new JLabel(B1));
          case  'C':   return(new JLabel(C1));
          case  'D':   return(new JLabel(D1));
          case  'E':   return(new JLabel(E1));
          case  'F':   return(new JLabel(F1));
          case  'G':   return(new JLabel(G1));
          case  'H':   return(new JLabel(H1));
          case  'I':   return(new JLabel(I1));
          case  'J':   return(new JLabel(J1));
          case  'K':   return(new JLabel(K1));
          case  'L':   return(new JLabel(L1));
          case  'M':   return(new JLabel(M1));                      //creates jlabels based on the arrays completion
          case  'N':   return(new JLabel(N1));
          case  'O':   return(new JLabel(O1));
          case  'P':   return(new JLabel(P1));
          case  'Q':   return(new JLabel(Q1));
          case  'R':   return(new JLabel(R1));
          case  'S':   return(new JLabel(S1));
          case  'T':   return(new JLabel(T1));
          case  'U':   return(new JLabel(U1));
          case  'V':   return(new JLabel(V1));
          case  'W':   return(new JLabel(W1));
          case  'X':   return(new JLabel(X1));
          case  'Y':   return(new JLabel(Y1));
          case  'Z':   return(new JLabel(Z1));
          default:     return(new JLabel(BLANK1));
       }
   }

   int guessedcount;
   int sl;
   void finishwp(){
       int guess2points = 0;
       for( int m = 0; m < 12;  m++){
          if(tiles1[m]  !=  charchooser2(r1[m])){
             tiles1[m]  =  charchooser2(r1[m]);
             guess2points++;
          }
       }
       for( int j = 0; j < 14;  j++){
          if(tiles3[j]  !=  charchooser2(r3[j])){
            tiles3[j]  =  charchooser2(r3[j]);
            guess2points++;
          }
       }
       for( int k = 0; k < 14;  k++){
          if(tiles4[k]  !=  charchooser2(r4[k])){            //for when someone guesses the whole sentence, finishes word bank
            tiles4[k]  =  charchooser2(r4[k]);
            guess2points++;
          }
       }
       for( int l = 0; l < 12;  l++){
          if(tiles2[l]  !=  charchooser2(r2[l])){
            tiles2[l]  =  charchooser2(r2[l]);
            guess2points++;
          }
       }

       row1.removeAll();
       row2.removeAll();
       row3.removeAll();
       row4.removeAll();

        for(int i = 0; i < 12; i ++){
           row1.add(tiles1[i]);
        }
        for(int j = 0; j < 14; j ++){
           row3.add(tiles3[j]);
        }
        for(int k = 0; k < 14; k ++){
           row4.add(tiles4[k]);
        }
        for(int l = 0; l < 12; l ++){
           row2.add(tiles2[l]);
        }
       int extra = 52 - sl;
       guess2points = guess2points - extra;
       guess2points = guess2points - guessedcount;
       guessedcount = 0;
       System.out.println("POINTS: " + guess2points);
       guess2points = guess2points * MainGUI.w.getpoint();
       MainGUI.pb.players[MainGUI.turn].addpoints(guess2points);        //gets points from last wheel spin and does logic
       if(guess2points <= 0){
           WheelOfFortune.sb.result(0);
       }
       MainGUI.pb.update();
       revalidate();
    }

    int lf = 0;
    static int chosensize = 0;
    static char[] guessed = new char[100];

  boolean guess(char c){
       int guesspoints = 0;

       for (int r = 0; r < chosensize; r ++){
          if( guessed[r] == c){
             return false;
          }
       }

       for (int i = 0; i < 12; i++){
          if(c == r1[i]){
             tiles1[i] = charchooser2(r1[i]);
             row1.removeAll();
             lf++;

             guessed[chosensize] = c;
             chosensize++;

             System.out.println(lf);
             guesspoints++;
             for(int m = 0; m < 12; m++){
                row1.add(tiles1[m]);
             }
          }
       }
       for (int j = 0; j < 12; j++){
          if(c == r2[j]){
             tiles2[j] = charchooser2(r2[j]);
             row2.removeAll();
             lf++;

             guessed[chosensize] = c;
             chosensize++;                                         // Takes the char and checks to see
                                                                  //if theres any matches, then fills word bank
             System.out.println(lf);
             guesspoints++;
             for(int n = 0; n < 12; n ++){
                row2.add(tiles2[n]);
             }
          }
       }
       for (int k = 0; k < 14; k++){
          if(c == r3[k]){
             tiles3[k] = charchooser2(r3[k]);
             row3.removeAll();
             lf++;

             guessed[chosensize] = c;
             chosensize++;

             System.out.println(lf);
             guesspoints++;
             for(int o = 0; o < 14; o ++){
               row3.add(tiles3[o]);
             }
          }
       }
       for (int l = 0; l < 14; l++){
          if(c == r4[l]){
             tiles4[l] = charchooser2(r4[l]);
             row4.removeAll();
             lf++;

             guessed[chosensize] = c;
             chosensize++;

             System.out.println(lf);
             guesspoints++;
             for(int p = 0; p < 14; p ++){
                 row4.add(tiles4[p]);
             }
          }
        }

        guessedcount = guesspoints + guessedcount;
        System.out.println("POINTS THIS MOVE: " + guesspoints);
        guesspoints = guesspoints * MainGUI.w.getpoint();
        MainGUI.pb.players[MainGUI.turn].addpoints(guesspoints);     //points system
        if(guesspoints <= 0){
           WheelOfFortune.sb.result(0);
        }
        else WheelOfFortune.sb.result(1);
        MainGUI.pb.update();
        revalidate();

        if(lf == (sl - 1)) return true;
        else return false;
     }

}
