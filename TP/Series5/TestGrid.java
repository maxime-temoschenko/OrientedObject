public class TestGrid {
    public static void main(String[] args) throws Exception{
        Grid g = new Grid();
        
        g.addRectangle(-10, 10, 5, 5, MyColor.GREEN);
        g.addRectangle(-15, 5, 0, -5, MyColor.GREEN);
        g.addRectangle(3, -2, 10, -15, MyColor.RED);

        GUI gui = new GUI(g);
        gui.start();
    }
}
