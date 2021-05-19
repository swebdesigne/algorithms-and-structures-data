public class HighArray {
	private long[] a; // reference to array
	private int nElems; // the quantity the elements at array
	
	// ---------------------------------------------------
	
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	// ---------------------------------------------------
	
	public boolean find(long searchKey) { // searching the assign value
		int j;
		for (j = 0; j < nElems; j++) { // for each the elements
			if (a[j] == searchKey) { // if the value found
				break; // if - yes - exit of loop		
			}
		}
		if (j == nElems) { // Has the last element been reached?
			return false;			
		} else {
			return true;
		}
	}
	
	// ---------------------------------------------------
	
	public void insert(long value) { // adding the element into array 
		a[nElems] = value; // the adding
		nElems++; // increase the size
	}
	
	// ---------------------------------------------------
	
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) { // searching the assing value
			if (value == a[j]) {
				break;
			}
		}
		if (j == nElems) {
			return false;
		} else {
			for (int k = j; k < nElems; k++) {
				a[k] = a[k + 1];
			}
			nElems--; // lessing the size
			return true;
		}			
		
	}
	
	// ---------------------------------------------------
	
	public void display() { // outputting the contains of the array
		for (int j = 0; j < nElems; j++) {
			System.out.println(a[j] + " "); // each the element
			System.out.println();
		}
	}
	
}