public abstract class Animal {
    public final static int REPRODUCTION_AGE = 4;
    public final static int REPRODUCTION_ENERGY = 4;

    //checking for invalid inputs

    public int getEnergy() {
        throw new UnsupportedOperationException();
    }

    public int getAge() {
        throw new UnsupportedOperationException();
    }

    public char getIcon() {
        throw new UnsupportedOperationException();
    }

    public boolean eat(char itemToEat) {
        throw new UnsupportedOperationException();
    }

    public Animal reproduce() {
        throw new UnsupportedOperationException();
    }

    public void move(Direction d) {
        throw new UnsupportedOperationException();
    }

    public int getX() {
        throw new UnsupportedOperationException();
    }

    public void setX() {
        throw new UnsupportedOperationException();
    }

    public int getY() {
        throw new UnsupportedOperationException();
    }

    public void setY(int y) {
        throw new UnsupportedOperationException();
    }
}
