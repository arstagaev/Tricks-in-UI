import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

/*
Made by @arstagaev in 2020
 */
public class DrawWaveTrying {

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
        new DrawWaveTrying().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //drawPanel = new CircleAndCubic().DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel4);

        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        //heartanim();
    }



    class DrawPanel4 extends JPanel
    {
        //private static final long serialVersionUID = 1L;

        public DrawPanel4() {
            ActionListener animate = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    moveIt();
                    repaint();
                }

            };
            Timer timer = new Timer(10,animate);
            timer.setRepeats(true);
            timer.start();
        }

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
            Graphics2D g2 = (Graphics2D) g;
            int x = 0;
            int y = 0;
            int rectWidth = 100;
            int rectHeight = 100;

            // Black is cubic
            g.setColor(Color.BLUE);
            // fill and stroke GeneralPath
            int x3Points[] = {x, x+rectWidth, x, x+rectWidth};
            int y3Points[] = {y, y+rectHeight, y+rectHeight, y};

            GeneralPath filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x3Points.length);
            filledPolygon.moveTo(x3Points[0], y3Points[0]);
            filledPolygon.curveTo(0,0,100,0,100,100);
            filledPolygon.curveTo(100,100,100,200,200,200);
            filledPolygon.lineTo(300,200);
            filledPolygon.curveTo(300,200,400,200,400,100);
            filledPolygon.curveTo(400,100,400,0,500,0);
            filledPolygon.lineTo(0,0);

//            for (int index = 1; index < x3Points.length; index++) {
//
//                filledPolygon.lineTo(x3Points[index], y3Points[index]);
//                //filledPolygon.curveTo();
//
//            }
            filledPolygon.closePath();
            g2.setPaint(Color.RED);
            g2.fill(filledPolygon);
            //XY upper , XY downer

            //g.fillRect(oneX, oneY, 60, 60);
            //g.fillPolygon(xCoord(),yCoord(),4);
            int radius = 40;
//            int centerX = 50;
//            int centerY = 100;
//            int angle = 30;
//
//            int dx = (int) (radius * Math.cos(angle * Math.PI / 180));
//            int dy = (int) (radius * Math.sin(angle * Math.PI / 180));


//            Polygon p = new Polygon();
//            //p = new Polygon();
//            //centerX = 250;
//            p.addPoint(0,0);
//            p.addPoint(100,0);
//            p.addPoint(0,100);
//
////            for (int i = 0; i < 360; i++) {
////                p.addPoint(dx,dy);
////                p.contains(1,2);
//////                double t = i / 360.0;
//////                p.addPoint((int) (centerX + radius * t * Math.cos(8 * t * Math.PI)),
//////                        (int) (centerY + radius * t * Math.sin(8 * t * Math.PI)));
////
////            }
////            g.setColor(Color.RED);
//            g.fillPolygon(p);
            g.setColor(Color.BLACK);
            Polygon p2 = new Polygon();
            for (int i = 0; i < 5; i++) p2.addPoint((int) (
                    100 + 50 * Math.cos(i * 2 * Math.PI / 5)),(int) (
                    100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

            g.drawPolygon(p2);

            g.setColor(Color.RED);
            g.fillOval(ovalX-sizeoval/2,ovalY-sizeoval/2,1+sizeoval,1+sizeoval);



            //repaint();
        }
    }

    public static int [] xCoord(){
        int [] xCoord = {0,0,50,50};
        return xCoord;
    }

    public static int [] yCoord(){
        int [] yCoord = {0,50,50,4};
        return yCoord;
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

        if (increase){
            increaseOval();
        }else{
            decreaseOval();
        }

        if (oneX==230){
            goToRight = false;
            // a = 0;
        } else if(oneX == 0){
            goToRight = true;
            // a = 0;
        }

        if (goToRight){
            toRight();
        }else {
            toLeft();
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
