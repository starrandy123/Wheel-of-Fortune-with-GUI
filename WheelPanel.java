import java.awt.geom.AffineTransform;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

class WheelPanel extends JPanel{                    //CLASS TO BUILD THE WHEEL
    Clip clip, clip1,clip2,clip3;
    static boolean wheelmade;
    static boolean ispin;
    static boolean hasspun;
    static boolean spiin = false;
    private int cpoint = 0;
    URL url1 = this.getClass().getResource("images/wheel-image.png");

    void main(){}
    int radius= 250;
    double angle= 20;
    BufferedImage Wheel = ImageIO.read(url1);
    BufferedImage rotatedWheel=spinWheel(Wheel,30);

    JButton spin;

    WheelPanel() throws IOException {
        ispin = false;
        setLayout(null);
        this.setSize(510,510);
        this.setBackground(Color.BLACK);
        this.LoadWheel();
    }



    void ShowWheel() throws IOException {
        Wheel = ImageIO.read(url1);
    }

    public int PlayerPoint(int cycle, int turns){
        cycle= turns* 15;
        int point=cycle % 360;
        System.out.println("Rotation: " + point);
        switch(point){
            case 0:
            case 105:
                System.out.println("land: Bankrupt");
                cpoint=-200;
                return -200;

            case 15:
            case 90:
                System.out.println("land: 550");
                cpoint=550;
                return 550;

            case 30:
                System.out.println("land: 200");
                cpoint=200;
                return 200;

            case 45:
            case 270:
                System.out.println("land: 350");
                cpoint=350;
                return 350;
            case 60:
            case 360:
                System.out.println("land: 900");
                cpoint=900;
                return 900;
            case 75:
                System.out.println("land: 150");
                cpoint=150;
                return 150;

            case 120:
            case 255:
                System.out.println("land: 600");
                cpoint=600;
                return 600;

            case 135:
            case 240:
            case 315:
                System.out.println("land: 250");
                cpoint=250;
                return 250;

            case 150:
            case 345:
                System.out.println("land: 300");
                cpoint=300;
                return 300;

            case 165:
                System.out.println("land: 700");
                cpoint=700;
                return 700;

            case 180:
                System.out.println("land: 100");
                cpoint=100;
                return 100;

            case 195:
                System.out.println("land: 450");
                cpoint=450;
                return 450;

            case 210:
                System.out.println("land: 5000");
                cpoint=5000;
                return 5000;

            case 225:
                System.out.println("land: 800");
                cpoint=800;
                return 800;

            case 285:
                System.out.println("land: 750");
                cpoint=750;
                return 750;

            case 300:
                System.out.println("land: You lost this spin... No points will be given");
                cpoint=0;
                return 0;

            case 330:
                System.out.println("land: 400");
                cpoint=400;
                return 400;
        }

        return point;
    }
    public int getpoint(){
        int points = cpoint;
        cpoint = 0;
        return points;
    }
    public int GetPlayerPoint(int cycle, int turns){
        cycle= turns* 15;
        int point=cycle % 360;
        switch(point){
            case 0:
            case 105:
                return -200;

            case 15:
            case 90:
                return 550;

            case 30:
                return 200;

            case 45:
            case 270:
                return 350;
            case 60:
            case 360:
                return 900;
            case 75:
                return 150;

            case 120:
            case 255:
                return 600;

            case 135:
            case 240:
            case 315:
                return 250;

            case 150:
            case 345:
                return 300;

            case 165:
                return 700;

            case 180:
                return 100;

            case 195:
                return 450;

            case 210:
                return 5000;

            case 225:
                return 800;

            case 285:
                return 750;

            case 300:
                return 0;

            case 330:
                return 400;
        }
        return point;
    }
    public void LoadWheel() throws IOException {
        Wheel = new BufferedImage (450, 450, BufferedImage.TYPE_INT_ARGB);
        Graphics2D  g2d = (Graphics2D) Wheel.getGraphics();
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ShowWheel();
    }

    @Override
    public Dimension getPreferredSize(){
        return Wheel==null
                ? new Dimension(70,33)
                :new Dimension(Wheel.getWidth(),Wheel.getHeight());
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        if (spiin == true){

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int x=(getWidth()-rotatedWheel.getWidth()/2);
            int y=(getHeight()-rotatedWheel.getHeight()/2);
            g2d.translate(-225,-225);
            g2d.drawImage(rotatedWheel, x, y, this); //this one draws the regular circle w 2 lines. Comment out rotate above to see it spin
            g2d.dispose();
        }
    }

    public BufferedImage spinWheel(BufferedImage wh,double angle){
        spiin = true;
        double rads = angle;
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = wh.getWidth();
        int h = wh.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotatedWheel = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedWheel.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(wh, 0, 0, this);
        g2d.dispose();


        return rotatedWheel;
    }

}

