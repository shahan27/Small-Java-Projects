import java.util.ArrayList;
import java.util.Random;

public class Grid {
    int length;
    final static char defaultIcon = '-';
    char grid[][];

    ArrayList<Animal> animals = new ArrayList<Animal>();
    ArrayList<Plant> plants = new ArrayList<Plant>();

    public Grid(int length) {
        this.length = length;
        grid = new char[length][length];
        init();
    }

    public void init(){
        for(int i =0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                grid[i][j] = defaultIcon;
            }
        }

        Random rand = new Random();
        int count = rand.nextInt(10) + 1;

        for(int i = 0; i < count; i++) {
            int energy = rand.nextInt(10) + 1;
            int age  = rand.nextInt(10) + 1;
            int x = rand.nextInt(16);
            int y = rand.nextInt(16);
            Animal car = new Carnivore(energy, age, x, y);
            x = rand.nextInt(16);
            y = rand.nextInt(16);

            Animal her = new Herbivore(energy, age, x, y);

            x = rand.nextInt(16);
            y = rand.nextInt(16);
            Plant pla = new Plant(x, y);

            animals.add(car);
            animals.add(her);
            plants.add(pla);
        }

        for(Plant p: plants) {
            grid[p.getX()][p.getY()] = p.getIcon();
        }

        for(Animal p: animals) {
            grid[p.getX()][p.getY()] = p.getIcon();
        }
    }

    public void print(){
        System.out.println();
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    void move(Animal a) {
        Random r = new Random();
        int i = r.nextInt(4);
        a.move(Direction.values()[i]);

    }

    void draw() {
        for(Animal a: animals){
            draw(a);
        }
    }

    void move() {
        clear();
        for(Animal a: animals){
            grid[a.getX()][a.getY()] = '-';
            move(a);
        }
        draw();
    }

    void eat() {
        for(Animal a: animals){
            eat(a);
        }
    }

    void eat(Animal a) {
        Plant pp = null;
        for(Plant p: plants) {
            if(p.getX() == a.getX() && p.getY() == a.getY()) {
                if(a.eat(p.getIcon())) {
                    pp = p;
                }
            }
        }
        if(pp!= null) {
            plants.remove(pp);
            return;
        }


        Animal aa = null;
        for(Animal b: animals) {
            if(b.getX() == a.getX() && b.getY() == a.getY()) {
                if(a.getIcon() != b.getIcon() && a.eat(a.getIcon())) {
                    aa = a;
                }
            }
        }

        if(aa!= null)
            animals.remove(aa);

    }

    void draw(Animal a) {
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(a.getX() == i && a.getY() == j) {
                    grid[i][j] = a.getIcon();
                }

            }
        }
    }

    void reproduce() {
        for(Animal a: animals){
            reproduce(a);
        }
        draw();
    }

    void reproduce(Animal a) {
        Animal child = a.reproduce();

        if(child != null) {
            if(child.getY() > 16) {
                child.setY(0);
            }
            draw();
        }
    }

    void growPlant(int x, int y) {
        if(grid[x][y] == '-') {
            growPlant(x, y);
        }
    }

    void growPlants() {
        Random rand = new Random();
        int count = 2;
        for(int i = 0; i < count; i++) {
            int x = rand.nextInt(16);
            int y = rand.nextInt(16);
            Plant pla = new Plant(x, y);
            plants.add(pla);
        }

        for(Plant p: plants) {
            grid[p.getX()][p.getY()] = p.getIcon();
        }
    }

    void clear() {
        for(int i =0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                grid[i][j] = defaultIcon;
            }
        }
    }
}
