public class BranchingPatternDrawer {
    /**
     * Draws a line segment with a specified width.
     *
     * @param x0    The x-coordinate of the starting point of the line.
     * @param y0    The y-coordinate of the starting point of the line.
     * @param x1    The x-coordinate of the ending point of the line.
     * @param y1    The y-coordinate of the ending point of the line.
     * @param width The width of the line.
     */
    public static void lineWithWidth(double x0, double y0, double x1, double y1, double width) {
        double size = 0.0005;
        double endX = x0 + width;
        while (x0 <= endX) {
            StdDraw.line(x0, y0, x1, y1);
            x0 += size;
            x1 += size;
        }
    }

    /**
     * Draws a branching pattern using recursive calls.
     *
     * @param x0        The x-coordinate of the starting point of the branch.
     * @param y0        The y-coordinate of the starting point of the branch.
     * @param length    The length of the branch.
     * @param angle_l   The angle for the left branch.
     * @param angle_c   The angle for the center branch.
     * @param angle_r   The angle for the right branch.
     * @param width_old The width of the previous branch.
     * @param n         The recursion depth or the number of iterations to perform.
     */
    public static void draw(double x0, double y0, double length, double angle_l, double angle_c, double angle_r, double width_old, int n) {
        if (n == 0) return;

        // Drawing the left side of the branch
        double x1_l = x0 - (Math.cos(Math.toRadians(angle_l)) * length);
        double y1_l = y0 + (Math.sin(Math.toRadians(angle_l)) * length);
        lineWithWidth(x0, y0, x1_l, y1_l, width_old);

        // Drawing the center of the branch
        double x1_c = x0 - (Math.cos(Math.toRadians(angle_c)) * length);
        double y1_c = y0 + (Math.sin(Math.toRadians(angle_c)) * length / 2.5);
        lineWithWidth(x0 + (width_old / 2), y0, x1_c, y1_c, width_old);

        // Drawing the right side of the branch
        double x1_r = x0 - (Math.cos(Math.toRadians(angle_r)) * length);
        double y1_r = y0 + (Math.sin(Math.toRadians(angle_r)) * length);
        lineWithWidth(x0 + (width_old), y0, x1_r, y1_r, width_old);

        // Recursive calls for the left, center, and right branches
        draw(x1_l, y1_l, length * 2 / 3, angle_l - 50, angle_c - 50, angle_r - 50, width_old / 2, n - 1);
        draw(x1_c, y1_c, length * 2 / 3, angle_l, angle_c, angle_r, width_old / 2, n - 1);
        draw(x1_r, y1_r, length * 2 / 3, angle_l + 30, angle_c + 30, angle_r + 30, width_old / 2, n - 1);
    }

    /**
     * The main method of the program.
     * It calls the 'lineWithWidth' method to draw a body, and the 'draw' method to draw a branch.
     *
     * @param args The command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        // Draw the body
        double x0_start = 0.52, y0_start = 0.01, x1_start = 0.52, y1_start = 0.3, width_start = 0.08;
        lineWithWidth(x0_start, y0_start, x1_start, y1_start, width_start);

        // Draw the branch
        draw(x1_start, y1_start, 0.2, 30, 85, 130, width_start / 2, 8);
    }
}
