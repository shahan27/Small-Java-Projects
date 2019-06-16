public class Plant {
    char icon;
    int x;
    int y;

    public Plant(int x, int y) {
        this.icon = '#';
        this.x = x;
        this.y = y;
    }

    public char getIcon() {
        return icon;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
