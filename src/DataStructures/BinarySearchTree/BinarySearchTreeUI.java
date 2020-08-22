package DataStructures.BinarySearchTree;

import java.util.Scanner;

public class BinarySearchTreeUI {
	BST tree;
	
	public BinarySearchTreeUI() {
		this.tree = new BST();
	}
	 // addPatient inserts a new patient in the list
    public void addPatient(int priority,String name){
        Node node = new Node(priority,name);
        tree.insert(node);
    }

    // removeMaxPatient removes the patient with the highest priority from the list
    public void removePatient(int priority){
        tree.delete(new Node(priority, ""));
    }

    // sortPatients sorts patients in the increasing order
    public void sortPatients(){
        tree.sort();
    }
    private void showMenu() {
        System.out.print("*** Welcome to the CS146 Hospital! ***\n Enter 1 to add a new patient\n Enter 2 to remove a patient by priority number\n Enter 3 to see sorted patients based on their priority\n Enter 4 to exit the program\n\nYour input is: ");
    }
	 public void UI(Scanner reader){
		 while(true){
			 showMenu();
			 String a = reader.next();
			 switch(a){
			 // Case will call to Add new patient
			 case "1": 
				 Scanner inputName = new Scanner(System.in);
				 System.out.print("Enter patient's name: ");
				 String name = inputName.next();
				 Scanner inputPriority = new Scanner(System.in);
				 System.out.print("Assign priority: ");
				 int priority = inputPriority.nextInt();
				 addPatient(priority,name);
				 break;
	                case "2":
	                	Scanner inputPriorityDelete = new Scanner(System.in);
	                	System.out.print("Patient to delete with priority: ");
	                	int priorityDelete = inputPriorityDelete.nextInt();
	                	removePatient(priorityDelete);
	                    break;
	                case "3": sortPatients();
	                    break;
	                case "4": System.out.print("\nClosing the program!");
	                    break;
	                default:
	                	System.out.println("invalid input\n");
	                	break;
	            }
	        }
	    }
}
