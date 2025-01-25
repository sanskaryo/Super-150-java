

public class Maze_Path {

    public static void main(String[] args) {
        int n = 3; // Grid ki rows
        int m = 3; // Grid ki columns
        Path(n - 1, m - 1, 0, 0, ""); // Top-left se bottom-right tak path start
    }

    // er: End Row, ec: End Column
    // cr: Current Row, cc: Current Column
    public static void Path(int er, int ec, int cr, int cc, String ans) {
        // 1. Base Case: Agar hum bottom-right corner (end position) par pahunch gaye
        if (cr == er && cc == ec) {
            System.out.println(ans); // Path ko print karo
            return;
        }

        // 2. Base Case: Agar hum grid ke bahar chale gaye (out of bounds)
        if (cr > er || cc > ec) {
            return; // Kuch nahi karna, recursion wapas piche chalega
        }

        // 3. Move horizontally (right) aur "H" ko path me jodo
        Path(er, ec, cr, cc + 1, ans + "H");

        // 4. Move vertically (down) aur "V" ko path me jodo
        Path(er, ec, cr + 1, cc, ans + "V");
    }
}
