public class TestGrid {
    public static void main(String[] args) throws Exception{
        Grid g = new Grid();
        g.addRectangle(-9, 0, 4, -12, MyColor.BLUE);
        g.addRectangle(0, -17, 12, -20, MyColor.BLUE);
        g.addRectangle(-10, 10, 3, 0, MyColor.GREEN);
        GUI test = new GUI(g);
        test.start();
    }
}

