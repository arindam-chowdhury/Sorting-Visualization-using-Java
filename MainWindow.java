import javax.swing.*;

public class MainWindow {
    public MainWindow() {
        JFrame jf = new JFrame("Soring Visualization");
        JButton btn = new JButton("Generate");
        JButton btn1 = new JButton("BubbleSort");
        JButton btn2 = new JButton("SelectionSort");
        JButton btn3 = new JButton("InsertionSort");
        JTextField text = new JTextField();

        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canva rect = new Canva();

        text.setBounds(10,750, 150,30);

        btn.setBounds(170,750, 95, 30);
        btn.addActionListener(e -> {
            rect.createEmptyArrayLists();

            int num = Integer.parseInt(text.getText());

            for(int i=0; i<num; i++) {
                rect.addRectangle();
            }
        });

        btn1.setBounds(275, 750, 125, 30);
        btn1.addActionListener( e -> rect.bubbleSort());


        btn2.setBounds(410, 750, 125, 30);
        btn2.addActionListener(e -> rect.selectionSort());

        btn3.setBounds(545, 750, 125, 30);
        btn3.addActionListener(e -> rect.insertionSort());

        jf.add(text);
        jf.add(btn);
        jf.add(btn1);
        jf.add(btn2);
        jf.add(btn3);
        jf.add(rect);

        jf.setVisible(true);

    }
}
