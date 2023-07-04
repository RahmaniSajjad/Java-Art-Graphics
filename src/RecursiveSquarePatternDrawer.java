public class RecursiveSquarePatternDrawer {
    /**
     * Draws a Sierpinski carpet pattern using recursive calls.
     * The pattern is created by dividing a square into smaller squares and drawing lines within them.
     *
     * @param n    The recursion depth or the number of iterations to perform.
     * @param x    The x-coordinate of the center of the current square.
     * @param y    The y-coordinate of the center of the current square.
     * @param size The size of the current square.
     */
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;

        double x0 = x - size / 2;
        double x1 = x + size / 2;
        double y0 = y - size / 2;
        double y1 = y + size / 2;

        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);
        StdDraw.line(x0, y, x1, y);

        draw(n - 1, x0, y0, size / 2);
        draw(n - 1, x0, y1, size / 2);
        draw(n - 1, x1, y0, size / 2);
        draw(n - 1, x1, y1, size / 2);
    }

    /**
     * The main method of the program.
     * It calls the 'draw' method with initial parameters to draw a Sierpinski carpet.
     *
     * @param args The command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        draw(8, 0.5, 0.5, 0.5);
    }
}
