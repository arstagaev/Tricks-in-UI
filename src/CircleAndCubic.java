
import javax.swing.*;
import java.awt.*;
/*
Made by @arstagaev in 2020
 */
public class CircleAndCubic {

    JFrame frame;
    private DrawPanel4 drawPanel4 = new DrawPanel4();

    private int oneX = 7;
    private int oneY = 7;

    private int ovalX = 60;
    private int ovalY = 120;

    private int sizeoval = 1;
    private int antisize = -1;
    private boolean increase = true;

    boolean goToRight = true;



    //int a = 0;

    public static void main(String... args)
    {
        new CircleAndCubic().go();
    }

    private void go()
    {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //drawPanel = new CircleAndCubic().DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel4);

        frame.setResizable(false);
        frame.setSize(300, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        moveIt();
        //heartanim();
    }



    class DrawPanel4 extends JPanel
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

            g.setColor(Color.RED);
            g.fillOval(ovalX-sizeoval/2,ovalY-sizeoval/2,1+sizeoval,1+sizeoval);
        }
    }

    private void increaseOval(){
        if (sizeoval<60){
            sizeoval++;
            antisize = sizeoval*(-1);
        }else{
            increase = false;
        }
        System.out.println(sizeoval);
    }

    private void decreaseOval(){
        if (sizeoval>1){
            sizeoval--;
            antisize = sizeoval*(-1);
        }else{
            increase = true;
        }
        System.out.println(sizeoval);
    }


    private void moveIt() {

        for (int a = 0; a<300; a++){


            if (increase){
                increaseOval();
            }else{
                decreaseOval();
            }

            if (oneX==230){
                goToRight = false;
                a = 0;
            } else if(oneX == 0){
                goToRight = true;
                a = 0;
            }

            if (goToRight){
                toRight();
            }else {
                toLeft();
            }


            try
            { Thread.sleep(10); }
            catch (Exception e) { e.printStackTrace(); }


            frame.repaint();
        }

    }

    private void toRight(){
        oneX++;
        //ovalX++;
    }
    private void toLeft(){
        oneX--;
        //ovalX--;
    }
}

