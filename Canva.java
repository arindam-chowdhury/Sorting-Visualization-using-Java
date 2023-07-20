import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Canva extends JPanel {
    private final Color barColor = new Color(61,61,61);
    private ArrayList<Integer> arrX;
    private int x;
    private ArrayList<Integer> arrHeight;


    public Canva() {
        arrX = new ArrayList<>();
        arrHeight = new ArrayList<>();
        x=10;
    }

    public void createEmptyArrayLists() {
        arrX = new ArrayList<>();
        arrHeight = new ArrayList<>();
        x=10;
    }

    public void addRectangle() {
        arrX.add(x);
        x+=10;
        int HEIGHT = (int) (Math.random()*700);
        arrHeight.add(HEIGHT);
        repaint();
    }

    public void bubbleSort() {
        Thread t = new Thread(() -> {
            for(int i=0; i<arrHeight.size(); i++) {
                for(int j=1; j<arrHeight.size()-i; j++) {
                    if(arrHeight.get(j-1) > arrHeight.get(j)) {
                        int temp = arrHeight.get(j-1);
                        arrHeight.set(j-1, arrHeight.get(j));
                        arrHeight.set(j, temp);
                        repaint();
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t.start();
    }

    public void selectionSort() {
        Thread t = new Thread(() -> {
            for(int i=0; i<arrHeight.size()-1; i++) {
                int min = i;
                for(int j=i+1; j<arrHeight.size(); j++) {
                    if(arrHeight.get(j) < arrHeight.get(min)) {
                        min = j;
                    }
                }
                int temp = arrHeight.get(i);
                arrHeight.set(i, arrHeight.get(min));
                arrHeight.set(min, temp);
                repaint();
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void insertionSort() {
        Thread t = new Thread(() -> {
            for(int i=1; i<arrHeight.size(); i++) {
                int temp = arrHeight.get(i);
                int j = i-1;
                while(j>=0 && arrHeight.get(j)>temp) {
                    arrHeight.set(j+1, arrHeight.get(j));
                    j--;
                    repaint();
                    try{
                        Thread.sleep(80);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                arrHeight.set(j+1, temp);
                repaint();
                try{
                    Thread.sleep(80);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i=0; i<arrX.size(); i++) {
            g.setColor(barColor);
            g.fillRect(arrX.get(i), JFrame.MAXIMIZED_VERT, 5,arrHeight.get(i));
        }

    }


}
















