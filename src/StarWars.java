package starwars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
Made by @arstagaev in 2020
 */

public class StarWars {

    private JFrame frame;
    private DrawPanel6 drawPanel = new DrawPanel6();
    private int sizeoval = 2;

    private int numOfFlakes = 1000;
    private int FALLINGSPEED = 4;
    private int REFRESHING = 300;


    ArrayList<Double> radiansArray = new ArrayList<>();
    ArrayList<Double> speedArray = new ArrayList<>();
    ArrayList<Double> orbitArrayX = new ArrayList<>();
    Random rand = new Random();

    public static void main(String... args)
    {
        new StarWars().go();
    }

    private void go()
    {
        frame = new JFrame("by ars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(true);
        frame.setSize(700, 700);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        initArray();
        moveIt();
    }
    public void initArray(){
        for (int o = 0; o<numOfFlakes; o++){

            radiansArray.add(Math.toRadians(rand.nextDouble()*360)); //***
            speedArray.add(rand.nextDouble()*4);
            orbitArrayX.add(rand.nextDouble()*100);

        }

    }


    int timeInterval = 0;


    class DrawPanel6 extends JPanel
    {
        public DrawPanel6() {
            ActionListener animate = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {


                    moveIt();
                    repaint();

                }

            };
            Timer timer = new Timer(FALLINGSPEED,animate);
            timer.setRepeats(true);
            timer.start();
        }


        private static final long serialVersionUID = 1L;
        public void paintComponent(Graphics g) {
           /*
           Parameters:
              x - the x coordinate of the rectangle to be filled.
              y - the y coordinate of the rectangle to be filled.
              width - the width of the rectangle to be filled.
              height - the height of the rectangle to be filled.
            */
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            for (int i = 0; i<orbitArrayX.size(); i++){

//                g.setColor(Color.GREEN);
//                g.drawLine(50,50,150,50);

                g.setColor(Color.WHITE);


                g.fillOval((int)(350+1+orbitArrayX.get(i)*(speedArray.get(i)) * Math.cos(radiansArray.get(i))),
                        (int)(350+1+orbitArrayX.get(i)*(speedArray.get(i)) * Math.sin(radiansArray.get(i))),
                        sizeoval,sizeoval);

                orbitArrayX.set(i,orbitArrayX.get(i)+1);
                if (orbitArrayX.get(i)>REFRESHING){
                    if (i!=0){
                        orbitArrayX.set(i,rand.nextDouble()*REFRESHING);
                    }
                }

            }

            timeInterval++;
            //g.dispose();
            System.out.println("Orbit R = "+orbitArrayX  );
        }
    }

    private void moveIt() {
//        for (int turn = 0; turn<360;turn++ ){
//            try
//            { Thread.sleep(FALLINGSPEED); }
//            catch (Exception e) { e.printStackTrace(); }
//            frame.repaint();
//            if (turn>330){
//                turn = 0;
//            }
//        }
    }
}



