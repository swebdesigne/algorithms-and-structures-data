class ArrayAp {
	public static void main(String[] args) {
		
		LowArray arr; // the link
		arr = new LowArray(100);
		
		int nElems = 0; // counts elements
		int j;
		long searchKey; // keys searching elements
		
		// ------------------------------------------
		
		arr.setElem(0, 77);
		arr.setElem(1, 99);
		arr.setElem(2, 44);
		arr.setElem(3, 55);
		arr.setElem(4, 22);
		arr.setElem(5, 88);
		arr.setElem(6, 11);
		arr.setElem(7, 00);
		arr.setElem(8, 66);
		arr.setElem(9, 33);
		nElems = 10; // array have the ten elements
		
		// ------------------------------------------
		
		for (j = 0; j < nElems; j++) // output elements
			System.out.println(arr.getElement(j) + " ");
			
		System.out.println("");
		
		// ------------------------------------------
		
		searchKey = 26; // search the element with value equals 66
		for (j = 0; j < nElems; j++) // for each element
			if(arr.getElement(j) == searchKey) // is value was searched?
				break; // if yes - exit
		if (j == nElems) // reached the last element 
			System.out.println("Can`t find " + searchKey); // yes 
		else
			System.out.println("Found " + searchKey); // No

		// ------------------------------------------
		
		searchKey = 55; // deleting the element with key 55
		for (j = 0; j < nElems; j++) // searching the deleting element
		if (arr.getElement(j) == searchKey)
			break;
		System.out.println("j = " + j);
		for (int k = j; k < nElems - 1; k++) // offset the next elements
			arr.setElem(k, arr.getElement(k + 1));
		nElems--; // leseen the size 
		
		// ------------------------------------------
		
		for (j = 0; j < nElems; j++) // output the elements
			System.out.println(arr.getElement(j) + " ");
		System.out.println("");
		
		System.out.println(arr.getSizeArr());
			
	}
}