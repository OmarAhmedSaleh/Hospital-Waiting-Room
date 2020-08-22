package Models;

public class Patient {
	private String name;
	private int priority;
	
	// Constructor
    public Patient(int priority, String name){
        this.name = name;
        this.priority = priority;
    }

    // Getters
    public int getPriority(){
        return priority;
    }
    public void setPriority(int input)
    {
        this.priority=input;
    }
    public String getName(){
        return name;
    }
}
