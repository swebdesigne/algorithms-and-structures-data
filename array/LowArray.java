class LowArray {
	private long[] a; // link to array
	
	// ------------------------------------------
	
	public LowArray(int size) { // the constructor
			this.a = new long[size]; // creating the array
	}
	
	// ------------------------------------------
	
	public void setElem(int index, long value) { // recording the element
		this.a[index] = value;
	}
	
	// ------------------------------------------
	
	public long getElement(int index) { // reading the element
		return this.a[index];
	}
	
	// ------------------------------------------
	
	public int getSizeArr() { // getting the size of the array
		return this.a.length;
	}
}