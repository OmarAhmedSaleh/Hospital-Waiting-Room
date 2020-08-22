package DataStructures.HashTable;
import Models.Patient;

public class HashTableChained {
	private final int tableSize = 17;
	private final int arraySize = tableSize + 1;
	private Node[] hashTable;
	
	// constructor
	public HashTableChained() {
		hashTable = new Node[arraySize];
		initTable();
	}
	
	 /* Utility function to fill primitive array hashTable with null. Used at initialization. */
    private void initTable() {
        for (int i = 0; i < arraySize; i++){
            hashTable[i] = null;
        }
    }
    
    // returns a hash key using division approach
    private int getHashKey(int priority) {
    	return priority % tableSize;
    }
    
    // insert function O(1) that inserts a new Node at the head of the single linked list
    public boolean insert(Patient patient) {
    	int key = getHashKey(patient.getPriority());
    	Node tableNode = search(patient.getPriority());
    	if(tableNode != null) {
    		System.out.println("\n Priority: " + patient.getPriority() + " exists.\n");
    		return false;
    	}
    	Node newNode = new Node(key, patient);

    	if(hashTable[key] == null) {// If there are no links at the key
    		hashTable[key] = newNode;
    	}else {
    		Node head = hashTable[key]; // Set the head object to the first link in the list 
    		newNode.setNext(head); // next of the newNode now contains current head link
    		hashTable[key] = newNode; // the head of the list is now the newNode object
    	}
    	System.out.println(hashTable[key]);
    	return true;
    }
    
    /* Utility function to search for a patient */
    public Node search(int priority) {
    	int key = getHashKey(priority);
    	Node currentNode = hashTable[key];
    	while(currentNode != null) {
    		if(currentNode.getData().getPriority() == priority) {
    			System.out.println(currentNode + "\n");
    			return currentNode;
    		}else {
    			currentNode = currentNode.getNext();
    		}
    	}
    	System.out.println("\n Patient not found with priority: " + priority + "\n");
    	return null;
    }
    /* Delete function O(n) that deletes a Hash Node based on priority number. O(n) instead of O(1) because of chaining. */
	public boolean delete(int priority) {
    	int key = getHashKey(priority);
    	Node toBeDeleted = search(priority);
    	if(toBeDeleted == null) {
            System.out.printf("\n Priority doesn't exist %d\n",priority);
    		return false;
    	}
    	// Case 1 : delete head
    	if(hashTable[key].getData().getPriority() == priority) {
    		Node next = hashTable[key].getNext();
    		hashTable[key] = next;
    		
    	}else {
    		Node prev = hashTable[key];
    		Node current = prev.getNext();
    		while(current != null && current.getData().getPriority() != priority) {
    			prev = current;
    			current = current.getNext();
    		}
    		if(current == null) {
    			return false;
    		}
			prev.setNext(current.getNext());
    	}
        System.out.println("\nDeleted patient "+toBeDeleted.getData().getName()+" with priority: "+toBeDeleted.getData().getPriority() + "\n");
    	return true;
    }
	@Override
	public String toString() {
		String result = "\n Hash table by level: \n";
		for(int level = 0; level < arraySize; level++) {
			Node node = hashTable[level];
			result += "level " + level + " : ";
			while(node != null) {
				result += node.toString() + "\n";
				node = node.getNext();
			}
			result += "\n";
		}
		return result;
	}
}
