package DataStructures.HashTable;

import Models.Patient;

public class Node {
	private int key;
	private Patient data;
	private Node next;
	// Constructor
	Node(int key, Patient data){
		this.key = key;
		this.data = data;
	}
	// Getters
	public int getKey() {
		return key;
	}
	public Patient getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	
	// Setters
	public void setNext(Node next) {
		this.next = next;
	}
	public void setData(Patient data) {
		this.data = data;
	}
	@Override
    public String toString() {
		return "\n Patient : " + getData().getName() + "\n Pariority : " + getData().getPriority() + "\n at key : " + getKey();
    }
}
