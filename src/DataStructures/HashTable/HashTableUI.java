package DataStructures.HashTable;

import java.util.Scanner;

import Models.Patient;

public class HashTableUI {
	
	private HashTableChained hashTable;
	
	public HashTableUI(){
		this.hashTable = new HashTableChained();
	}
	private void showMenu() {
        System.out.print("*** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to delete a patient by priority number\nEnter 3 to search patient by a priority number\nEnter 4 to see patients\nEnter 5 to exit the program\n\nYour input is: ");
	}
	  // addPatient inserts a new patient in the list
    private void addPatient(int priority,String name){
        Patient patient = new Patient(priority,name);
        hashTable.insert(patient);
    }
    // removePatient removes the patient from the table
    private void removePatient(int priority){
    	hashTable.delete(priority);
    }
    // searchPatient search for a patient based on priority number
    public void searchPatient(int priority){
    	hashTable.search(priority);
    	
    }

    // printPatients prints patient level by level from the Hash Table
    public void printPatients(){
    	System.out.println(hashTable);
    }
	 public void UI(Scanner reader){
		 while(true){
			 showMenu();
			 String a = reader.next();
			 switch(a){
	                // Case will call to Add new patient
	                case "1": Scanner inputName = new Scanner(System.in);
	                    System.out.print("Enter patient's name: ");
	                    String name = inputName.next();
	                    Scanner inputPriority = new Scanner(System.in);
	                    System.out.print("Assign priority: ");
	                    int priority = inputPriority.nextInt();
	                    addPatient(priority,name);
	                    break;
	                case "2": Scanner inputPriorityDelete = new Scanner(System.in);
	                    System.out.print("Patient to delete with priority: ");
	                    int priorityDelete = inputPriorityDelete.nextInt();
	                    removePatient(priorityDelete);
	                    break;
	                case "3": Scanner inputPrioritySearch = new Scanner(System.in);
	                    System.out.print("Patient to search with priority: ");
	                    int prioritySearch = inputPrioritySearch.nextInt();
	                    searchPatient(prioritySearch);
	                    break;
	                case "4": printPatients();
	                    break;
	                case "5": System.out.print("\nClosing the program!");
	                break;
	                default:
	                	System.out.println("invalid input\n");
	                	break;
	            }
	        }
	    }
}
