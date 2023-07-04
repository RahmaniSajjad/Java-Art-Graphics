public class SquareFractalDrawer {
    /**
     * Draws a modified square fractal pattern using recursive calls.
     *
     * @param n    The recursion depth or the number of iterations to perform.
     * @param x    The x-coordinate of the center of the current square.
     * @param y    The y-coordinate of the center of the current square.
     * @param size The size of the current square.
     */
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;

        // Draw a square if n is divisible by 3, otherwise draw an empty square
        if (n % 3 == 0) StdDraw.square(x, y, size);
        else StdDraw.square(x, y, size);

        // Recursive calls to draw the pattern in the four quadrants
        draw(n - 1, x + size, y + size, size / 2);
        draw(n - 1, x + size, y - size, size / 2);
        draw(n - 1, x - size, y + size, size / 2);
        draw(n - 1, x - size, y - size, size / 2);
    }

    /**
     * The main method of the program.
     * It calls the 'draw' method with initial parameters to draw the square fractal.
     *
     * @param args The command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        draw(8, 0.5, 0.5, 0.3);
    }
}
