package DataStructures.BinarySearchTree;

import Models.Patient;

public class Node {
	private Patient patient;
	public Node left, right;
	
	public int getPriority(){
		return patient.getPriority();
	}
    public String getPatientName(){
        return patient.getName();
    }
    public Node(int priority, String name) {
    	this.patient = new Patient(priority, name);
    	left = null;
    	right = null;
    }
    @Override
    public String toString(){
        String result = getPriority() + " " + getPatientName();
        return result;
    }
}
