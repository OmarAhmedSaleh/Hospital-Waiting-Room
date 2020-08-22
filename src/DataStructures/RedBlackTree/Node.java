package DataStructures.RedBlackTree;
import Models.Patient;
import java.awt.Color;

public class Node {
	int key;
    Patient patient;
    Node p, left, right;
    Color color;

    Node(){
        color = Color.BLACK;
        p = null;
        left = null;
        right = null;
    }


    public Node(int key, Color color, Patient patient) {
        this.patient = patient;
        this.key = key;
        this.color = color;
        p = null;
        left = null;
        right = null;
    }

    /** Getters */
    public int getKey(){
        return key;
    }
    public Patient getData(){
        return patient;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public Node getParent(){
        return p;
    }

    public String getColor() {
        if(color == Color.RED){
            return "RED";
        }
        else{
            return "BLACK";
        }
    }

    /** Setters */
    public void setLeft(Node l){
        this.left = l;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setRight(Node r){
        this.right = r;
    }
    public void setParent(Node p){
        this.p = p;
    }

	
	@Override
	 public String toString(){
        String result = " Priority : " + getData().getPriority() + " Color : " + getColor() + "; \n\n";
        return result;
    }
	
}
