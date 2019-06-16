public class Main {
    public static void main(String args[]) {
        Grid grid = new Grid(16);

        grid.print();

        for(int i =0; i < 32; i++) { // number of iterations
            grid.move();
            grid.reproduce();
            grid.eat();
            grid.growPlants();
            grid.print();
        }

    }
}
