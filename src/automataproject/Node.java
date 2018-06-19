package automataproject;

public class Node {
    private boolean check = false;
    public Node[] next;
    private int ID;
    
    public boolean isFinal(){
        return this.check;
    }
    
    public void setFinal(){
        this.check = true;
    }
    
    public void setNext(int x, Node y){
        next[x] = y;
    }
    
    public void setID(int x){
        this.ID = x;
    }
    
    public int getID(){
        return this.ID;
    }

}