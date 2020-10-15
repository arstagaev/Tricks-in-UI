
import javax.swing.*;
import java.awt.*;
/*
Made by @arstagaev in 2020
 */

public class PlanetAnim {

    private JFrame frame;
    private DrawPanel2 drawPanel = new DrawPanel2();

    private int oneX = 7;
    private int oneY = 7;

    private int ovalX = 180;
    private int ovalY = 120;

    private int sizeoval = 60;
    private int pillarOval = 1;
    private boolean increase = true;

    boolean goToRight = true;

    //int a = 0;

    public static void main(String... args)
    {
        new PlanetAnim().go();
    }

    private void go()
    {
        frame = new JFrame("Test2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //drawPanel = new AnimTest2().drawPanel;

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(true);
        frame.setSize(360, 360);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        moveIt();
        //heartanim();
    }




    class DrawPanel2 extends JPanel
    {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g)
        {
           /*
           Parameters:
              x - the x coordinate of the rectangle to be filled.
              y - the y coordinate of the rectangle to be filled.
              width - the width of the rectangle to be filled.
              height - the height of the rectangle to be filled.
            */
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
//            g.setColor(Color.RED);
//            g.fillRect(3, 3, this.getWidth() - 6, this.getHeight() - 6);
//            g.setColor(Color.WHITE);
//            g.fillRect(6, 6, this.getWidth() - 12, this.getHeight() - 12);

            // Black is cubic
            g.setColor(Color.BLACK);
            //XY upper , XY downer

            g.fillRect(oneX, oneY, 60, 60);
            if (goToRight){
                g.setColor(Color.YELLOW);
                g.fillOval(120,90,1+80,1+80);
            }

            if (sizeoval>60){
                sizeoval =60;
            }

            g.setColor(Color.RED);
            g.fillOval(ovalX-sizeoval/2,ovalY-sizeoval/2,sizeoval,sizeoval);
            if (!goToRight) {
                g.setColor(Color.YELLOW);
                g.fillOval(120,90,1+80,1+80);
            }

        }
    }

    private void moveIt() {

        for (int turn = 0; turn<360;turn++ ){

            if (goToRight){
                rightGo();
            }else {
                leftGo();
                turn = 0;
            }


            if (ovalX>288 | ovalX < 12){
                try
                { Thread.sleep(20); }
                catch (Exception e) { e.printStackTrace(); }
            }else if (ovalX >280| ovalX < 20){
                try
                { Thread.sleep(15); }
                catch (Exception e) { e.printStackTrace(); }
            }else{
                try
                { Thread.sleep(10); }
                catch (Exception e) { e.printStackTrace(); }
            }
            frame.repaint();
        }
    }

    private void rightGo(){
        if (ovalX < 300){
            ovalX++;
            if (ovalX%5==0 & ovalX>180){
                sizeoval--;
            }else if (ovalX%5==0 & ovalX <180){
                sizeoval++;
            }

        }else {
            goToRight = false;

        }


    }

    public void leftGo(){
        if (ovalX > 1){
            ovalX--;
            if (ovalX%5==0 & ovalX>180){
                sizeoval--;
            }else if (ovalX%10==0 & ovalX <180){
                sizeoval++;
            }

        }else {
            goToRight = true;
        }
    }



}

