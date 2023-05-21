package algorithm.game.tictactoe;

public enum Field {
    CELL1(1, 2, 3),
    CELL2(4, 5, 6),
    CELL3(7, 8, 9),
    CELL4(1, 5, 9),
    CELL5(3, 5, 7),
    CELL6(1, 4, 7),
    CELL7(3, 6, 9);
    private final int x;

    private final int y;
    private final int z;

    Field(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public static boolean findCell(int x, int y, int z) {
        for (Field f : values()) {
            if (f.x == x && f.y == y && f.z == z) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Field.findCell(1, 5, 9));
    }
}
