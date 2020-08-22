package DataStructures.MaxHeap;

import java.util.Collections;
import java.util.List;

import Models.Patient;

public class MaxHeapPriorityQueue {
	
	private int heapSize; // Maintains the size of the heap data structure
	private List<Patient> list;
	
	// Constructor
	public MaxHeapPriorityQueue(List<Patient> list) {
		buildHeap(list);
	}
	public void buildHeap(List<Patient> list) {
		this.list = list;
		heapSize = list.size();
		this.list.add(0, new Patient(-1 , "Dummy"));
		for(int idx = 1; idx < heapSize ;idx++) {
			MaxHeapify(idx);
		}
	}
    /* MaxHeapify O(logn) procedure, maintains the max-heap property - the parent needs to be greater than its children. */
	private void MaxHeapify(int idx) {
		int largest = idx, cnt = 0;
		while(cnt < 1) {
			int childIdx = idx * 2 + cnt;
			if(childIdx < heapSize && list.get(childIdx).getPriority() > list.get(largest).getPriority()) {
				largest = childIdx;
			}
			cnt++;
		}
		if(largest != idx) {
			Collections.swap(list, idx, largest);
			MaxHeapify(largest);
		}
	}
    /* MaxHeapInsert method procedure provides the user with ability to insert a new node in the heap while maintaining MaxHeap structure*/
	public void MaxHeapInsert(Patient patient) {
		list.add(patient);
		heapSize++;
		HeapIncreaseKey(list.size() - 1);
	}

	/* HeapIncreaseKey is used by MaxHeapInsert method in order to set the key of this new node to its correct value and maintain the Max Heap priority r */
	private void HeapIncreaseKey(int idx) {
		if(idx == 0) {
			return ;
		}
		int parent = idx / 2;
		if(parent > 0 && list.get(parent).getPriority() < list.get(idx).getPriority()) {
			Collections.swap(list, idx, parent);
			HeapIncreaseKey(parent / 2);
		}
	}
    /* HeapExtractMax O(logn) method provides the user with ability to extract the node with the highest priority - while maintaining MaxHeapify */
	public Patient HeapExtractMax() {
		if(heapSize == 0) {
			return null;
		}
		Patient max = list.get(1);
		list.remove(1);
		heapSize--;
		if(heapSize > 1) {
			Collections.swap(list, 1, list.size() - 1);
			HeapIncreaseKey(list.size() - 1);
			MaxHeapify(1);
		}
		return max;
	}
	// HeapTop method returns the node with the highest priority
	public Patient HeapTop() {
		if(heapSize == 0) {
			return null;
		}
		return list.get(1);
	}
	  // printArray returns the List in a user friendly form
    public void printArray(List<Patient> A){
        System.out.print("\n");
        for(int idx=1;idx < A.size(); idx++){
            System.out.print(list.get(idx));
        }
    }
    // HeapSort algorithm to sort unordered array
    public void Sort(List <Patient> A) {
    	MaxHeapPriorityQueue heap = new MaxHeapPriorityQueue(A);
    	A = heap.list;
    	A.remove(0);    	
    }

}
