import DataStructures.BinarySearchTree.BinarySearchTreeUI;
import DataStructures.HashTable.HashTableUI;
import DataStructures.MaxHeap.MaxHeapUI;
import DataStructures.RedBlackTree.RedBlackTreeUI;
import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		BinarySearchTreeUI tree = new BinarySearchTreeUI();
		HashTableUI hashTable = new HashTableUI();
		MaxHeapUI maxHeap = new MaxHeapUI();
		RedBlackTreeUI rbt = new RedBlackTreeUI();

		Scanner reader = new Scanner(System.in);
		boolean stream = true;
		while(stream) {
			showMenu();
			 String a = reader.next();
		        if(a.equals("1")){
		          maxHeap.UI(reader); // Initialize UI for MaxHeapPriorityQueue
		      }
		      else if(a.equals("2")){
		          hashTable.UI(reader);
		      }
		      else if(a.equals("3")){
		          tree.UI(reader);
		      }
		      else if(a.equals("4")){
		          rbt.UI(reader);
		      }
		      else if(a.equals("q")){
		    	  stream = false;
		          break;
		      }
		      else{
		          System.out.print("Error: Try again!");
		      } 
		}
		reader.close();
       }
	private static void showMenu() {
        System.out.print("Pick data structure: \n1) Type 1 for MaxHeapPriorityQueue\n2) Type 2 for Hash Tables\n3) Type 3 for Binary Search Tree\n4) Type 4 for Red Black Tree\n5) Type q to exit\n");
        
	}
}
