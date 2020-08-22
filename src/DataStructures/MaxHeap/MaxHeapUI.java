package DataStructures.MaxHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Patient;

public class MaxHeapUI {
    static List<Patient> patients = new ArrayList<Patient>();
    private MaxHeapPriorityQueue heap;
    
    public MaxHeapUI(){
        patients = new ArrayList<Patient>();
        heap = new MaxHeapPriorityQueue(patients);
    }

    // addPatient inserts a new patient in the list
    public  void addPatient(String name, int priority){
        Patient patient = new Patient(priority, name);
        heap.MaxHeapInsert(patient);
        System.out.print("Patient was successfully added in the line. Name: " + name + " Patient's priority: " + priority + "\n");
    }
    // removeMaxPatient removes the patient with the highest priority from the list
    public void removeMaxPatient(){
        Patient maxPatient = heap.HeapExtractMax();
        if(maxPatient == null) {
			System.out.println("\n*** Heap is empty. ***\n");
        }else {
            System.out.print("Patient with highest priority is processed and was removed from the line. Name: "+maxPatient.getName()+" Patient's priority number was: " + maxPatient.getPriority() + "\n ");     	
        }
    }
 // whoMaxPatient outputs which patient has the highest priority
    public void whoMaxPatient(){
        Patient patient = heap.HeapTop();
        if(patient == null) {
			System.out.println("\n*** Heap is empty. ***\n");
        }else {
            System.out.print("Patient with highest priority is processed and was removed from the line. Name: "+ patient.getName()+" Patient's priority number was: " + patient.getPriority() + "\n ");     	
        }
    }
 // sortPatients sorts patients in the increasing order using Heapsort and then rebuild the heap maintaining Max Heap Priority
    public void sortPatients(){
        heap.Sort(patients);
        heap.printArray(patients);
        heap.buildHeap(patients); // We must rebuild the heap
    }
    public void UI(Scanner reader){
        while(true){
            System.out.print("\n\n *** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to remove a patient with highest priority from the line\nEnter 3 to see the patient with the highest priority\nEnter 4 to see sorted patients based on their priority\nEnter 5 to exit the program\n\nYour input is: ");
            String a = reader.next();
            switch(a){
                // Case will call to Add new patient
                case "1": 
                    System.out.print("Enter patient's name: ");
                    String name = reader.next();
                    System.out.print("Assign priority: ");
                    int priority = reader.nextInt();
                    addPatient(name,priority);
                    break;
                case "2": removeMaxPatient();
                    break;
                case "3": whoMaxPatient();
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
