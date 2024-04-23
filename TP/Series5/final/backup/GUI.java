import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class GUI extends Canvas {

    private static final int xDim = 600;
    private static final int yDim = 600;
    
    private MyColor currentColor = MyColor.RED;

    private Grid grid;

    public GUI(Grid g) {
        this.grid = g;
    }

    public void start() throws Exception {
        JFrame frame = new JFrame("Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xDim, yDim+20);
        frame.setResizable(false);
        frame.add(this);
        frame.setVisible(true);
        setFocusable(true);
        KeyListener kl = new KeyListener() {
        
            @Override
            public void keyPressed(KeyEvent e) { }

            @Override
            public void keyReleased(KeyEvent e) { }

            @Override
            public void keyTyped(KeyEvent e) {
                //System.out.println(e.getKeyChar());
                if (e.getKeyChar() == 'r') {
                    grid.rotate(currentColor);
                    repaint();
                }
                if (e.getKeyChar() == 'c') {
                    if (currentColor == MyColor.RED) currentColor = MyColor.BLUE;
                    else if (currentColor == MyColor.BLUE) currentColor = MyColor.GREEN;
                    else if (currentColor == MyColor.GREEN) currentColor = MyColor.RED;
                    System.out.println("Current color changed to: " + currentColor);
                    repaint();
                }
                
            }
        };
        this.addKeyListener(kl);
    }

    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.drawLine(xDim/2, 0, xDim/2, yDim);
        g.drawLine(0, yDim/2, xDim, yDim/2);
        Rectangle[] ar = grid.getRectangles();
        for (int i = 0; i< ar.length; i++) {
            Rectangle r = ar[i];
            if (r.getColor() == MyColor.RED) g.setColor(Color.RED);
            if (r.getColor() == MyColor.GREEN) g.setColor(Color.GREEN);
            if (r.getColor() == MyColor.BLUE) g.setColor(Color.BLUE);
            
            System.out.println(xDim/2 + (r.getXmin()*10));
            System.out.println(yDim/2 - (r.getYmin()*10));
            System.out.println((r.getXmax()-r.getXmin())*10);
            System.out.println((r.getYmax() - r.getYmin())*10);
            System.out.println("#####################");
            
            g.drawRect(xDim/2 + (r.getXmin()*10), yDim/2 - (r.getYmax()*10), (r.getXmax()-r.getXmin())*10 , (r.getYmax() - r.getYmin())*10);
        }
    }

}