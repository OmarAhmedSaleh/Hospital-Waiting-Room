package DataStructures.RedBlackTree;

import java.util.Scanner;

import Models.Patient;

public class RedBlackTreeUI {
    RedBlackTree tree = new RedBlackTree();

    public RedBlackTreeUI() {
        this.tree = new RedBlackTree();
    }

    public void addPatient(int priority, String name){
        Patient temp = new Patient(priority,name);
        //PatientNode patient = new PatientNode(priority,Color.BLACK, temp);
        tree.insert(temp);
        System.out.print("\n\nYour input: ");
    }

    // removeMaxPatient removes the patient with the highest priority from the list
    public void removePatient(int priority){
        tree.deletePatient(priority);
        System.out.print("\n\nYour input: ");
    }

    // sortPatients sorts patients in the increasing order
    public void sortPatients(){
        tree.sort();
        System.out.print("\n\nYour input: ");
    }

    // sortPatients sorts patients in the increasing order
    public void searchPatient(int priority){
        tree.searchPatient(priority);
        System.out.print("\n\nYour input: ");
    }

    public void UI(Scanner reader){
        while(true){
            System.out.print("*** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to remove a patient by priority number\nEnter 3 to search for a Patient: \nEnter 4 to see sorted patients based on their priority\nEnter 5 to exit the program\n\nYour input is: ");
            String a = reader.next();
            switch(a){
                // Case will call to Add new patient
                case "1":
                    System.out.print("Enter patient's name: ");
                    String name = reader.next();
                    System.out.print("Assign priority: ");
                    int priority = reader.nextInt();
                    addPatient(priority,name);
                    break;
                case "2":
                    System.out.print("Patient to delete with priority: ");
                    int priorityDelete = reader.nextInt();
                    removePatient(priorityDelete);
                    break;
                case "3":
                    System.out.print("Patient to delete with priority: ");
                    int prioritySearch = reader.nextInt();
                    searchPatient(prioritySearch);
                    break;
                case "4": sortPatients();
                    break;
                case "5": System.out.print("\nClosing the program!");
                    return;
                default:
                	System.out.println("invalid input\n");
                	break;
            }
        }
    }
}
