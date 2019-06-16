package com.company;

public final class BinomialTreeFactory
{
    private Node root;
    private int P;

    public BinomialTreeFactory(int T, int P){
        assert (P >= 0 && P <= 100);
        root = new Node("Root", 0);
        this.P = P;
        branch(root, 0, T);
    }
    //creation of tree with para passed through
    public static BinomialTreeFactory create(int T, int P){
        return new BinomialTreeFactory(T, P);
    }

    private void branch(Node begin, int currentCol, int lastCol){
        if(currentCol > lastCol){
            return;
        }
        assert begin != null;
        Node up = new Node("UP", currentCol);
        Node down = new Node("DOWN", currentCol);
        begin.setUp(up);
        begin.setDown(down);
        currentCol = currentCol + 1;
        branch(begin.getUp(), currentCol, lastCol);
        branch(begin.getDown(), currentCol, lastCol);
    }

    public Node getRoot() {
        return root;
    }

}
