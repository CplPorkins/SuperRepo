
/*****************************
 * Happy Hall-idays - Lorenz "Big L" Vargas, Kate "The Voice" Johnston
 * APCS1 pd10
 * HW42 -- Array of Titanium
 * 2015-12-07   
 * 
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
        _size += 1;
        _lastPos += 1;
        if(_size>_data.length)
        	expand();
        _data[_lastPos] = newVal;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) { 
        _size += 1;
        _lastPos += 1;
        
        if (_size>_data.length)
            expand();
        
        for (int i = _lastPos ; i > index; i--){
           _data[i]=_data[i-1];
        }
        
        _data[index]=newVal;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
    	_size-=1;
    	_lastPos-=1;
    	
        for (int i=index; i <= _lastPos; i++){
        	_data[i]=_data[i+1];
        }
    }


    //return number of meaningful items in _data
    public int size() { 
        return _size;
    }

    //int linSearch, does a linear search for Comparable input c and returns its index

    public int linSearch(Comparable c) {
	for (int i = 0; i < _data.length; i++) {
	    if (_data[i].equals(c)) {
		return i;
	    }
	}
	return -1;
    }

    public boolean isSorted() {
	for (int i = 0; i < _data.length; i++) {
	    if (_data[i].compareTo(_data[i+1]) != 1) {
		return false;
	    }
	}
	return true;
    }

    //isSorted finds out whether the SuperArray is sorted in ascending order

    //main method for testing
    public static void main( String[] args ) 
    {

	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);


	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,new Rational(i*2,1));
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	 mayfield.add(new Binary(4));
	 mayfield.add(new Binary("11101"));
	 mayfield.add(new Hexadecimal(2000));
	 mayfield.add(new Hexadecimal("7CE"));
	 mayfield.add(new Rational(9,2));

	 System.out.println("Printing populated SuperArray mayfield...");
	 System.out.println(mayfield);


	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);

	  mayfield.add(3,new Rational(42,3));
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,new Binary("111110"));
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,new Hexadecimal(40000));
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	/*-----------------------------------
	  --------------------------------*/

    }//end main
		
}//end class
