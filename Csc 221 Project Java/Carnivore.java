public class Carnivore extends Animal{
    int energy;
    int age;
    char icon;
    int x;
    int y;

    public Carnivore(Carnivore h) {
        this.age = h.age;
        this.energy = h.energy;
        this.icon = h.icon;
        this.x = h.x;
        this.y = h.y;
    }

    public Carnivore(int energy, int age, int x, int y) {
        this.age = age;
        this.energy = energy;
        this.icon = '@';
        this.x = x;
        this.y = y;
    }

    public char getIcon() {
        return icon;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean eat(char itemToEat) {
        if(itemToEat == '&')
        {
            this.energy++;
            return true;
        }
        return false;
    }

    @Override
    public Animal reproduce() {
        if(age > REPRODUCTION_AGE && energy > REPRODUCTION_ENERGY)
        {
            this.energy--;
            return new Carnivore(5, 5, x, y++);
        }
        return null;
    }

    @Override
    public void move(Direction d) {
        this.energy--;

        if(d==Direction.NORTH)
        {
            if(x-1 < 0)
                x = 15;
            else
                x--;
        }
        else if(d==Direction.EAST)
        {
            if (y + 1 == 16)
                y = 0;
            else
                y++;
        }
        else if(d==Direction.SOUTH)
        {
            if (x + 1 == 16)
                x = 0;
            else
                x++;
        }
        else if(d==Direction.WEST)
        {
            if(y - 1 < 0)
                y = 15;
            else
                y--;
        }


    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}