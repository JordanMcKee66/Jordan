// myPolygons.java
//**
// Author: Jordan McKee
// Course: Seng2200 Prog Lang and Paradigms
// Student Number: c3331542
//**
public class myPolygons{
	//Variable Declaration:
	private node sentinel, current; //Sentinel is the first node in the list (position 1)
	private int nodeCount;
	
	//Constructor
	public myPolygons(){
		sentinel = null;
		nodeCount = 0;
	}
	
	//Method prepend -- Adds a new node in the sentinel position (position 1)
	public void prepend(polygon p){
		if (nodeCount == 0){
			sentinel = new node(p);
			sentinel.setNext(sentinel);
			sentinel.setPrevious(sentinel);
			current = sentinel;
			nodeCount++;
		}else {
			node tempNode = new node(p);
			current = sentinel.getPrevious();
			current.setNext(tempNode);
			sentinel.setPrevious(tempNode);
			tempNode.setPrevious(current);
			tempNode.setNext(sentinel);
			sentinel = tempNode;
			nodeCount++;
			currentReset();
		}
	}
	
	
	//Method prepend -- Adda a new node in the final position (position nodeCount)
	public void append(polygon p){
		if (nodeCount == 0){
			sentinel = new node(p);
			sentinel.setNext(sentinel);
			sentinel.setPrevious(sentinel);
			current = sentinel;
			nodeCount++;
		}else {
			node tempNode = new node(p);
			current = sentinel.getPrevious();
			current.setNext(tempNode);
			sentinel.setPrevious(tempNode);
			tempNode.setPrevious(current);
			tempNode.setNext(sentinel);
			current = tempNode;
			nodeCount++;
			currentReset();
		}
	}
	
	//Method insert -- Inserts a new node of polygon data behind current
	public void insert(polygon p){
		if (nodeCount == 0){
			System.out.println("Error: Current position = 0 \nCannot insert without current position.");
		}else {
			node tempNode = new node(p);
			node tempCurrent = current.getPrevious();
			tempCurrent.setNext(tempNode);
			current.setPrevious(tempNode);
			tempNode.setNext(current);
			tempNode.setPrevious(tempCurrent);
			nodeCount++;
			current = current.getPrevious();
			if (getPosition(current) == 1){
				sentinel = current;
			}
		}
	}
	
	//Method remove -- removes the node in the position that matches the int parameter
	public void remove(int position){
		if (position > nodeCount{
			System.out.println("Error: no node found");
		}else{
		currentReset();
		while (getPosition(current) != position){
			current = current.getNext();
		}
		node tempNode = current.getPrevious();
		tempNode.setNext(current.getNext());
		tempNode = current.getNext();
		tempNode.setPrevious(current.getPrevious());
		current = tempNode;
		nodeCount--;
		currentReset();
		}

	}
	
	//Method currentReset -- makes current = sentinel (returns to position 1)
	public void currentReset(){
		current = sentinel;
	}

	//Method sort -- Uses an Insertion Sort to sort the polygons into ascending order by Area
	public void sort(){
		currentReset();
		node key;
		for(int i = 1; i < nodeCount; i++){
			key = current.getNext();
			//Current incriments forward until a smaller node is located on its right, key is held as smaller node
			while (current.getArea() <= key.getArea()){
				current = key;
				key = current.getNext();
				//if current.getRight() is sentinel then list is sorted 
				if (key == sentinel){
					break;
				}
			}
			//list is sorted -- continuation on break from for loop
			if (key == sentinel){
				break;
			}
			//Current incriments backwards until a smaller node then key is found in position current
			while (key.getArea() <= current.getArea()){
				//if current is sentinel then current cannot incriment further, key is inserted on the left of current (into position 1) and loop is broken
				if (current == sentinel){
					insert(key.getPoly());
					remove(getPosition(key));
					break;
				}
				current = current.getPrevious();
			}
			//if current != sentinel then smaller node was found --  node inserted to its right (current.getNext() position)
			if (current != sentinel){
				current = current.getNext();
				insert(key.getPoly());
				remove(getPosition(key));
			}
		}
	}
	
	//Method getPosition -- returns the position of the node given as parameter in the linked list
	public int getPosition(node n){
		node tempNode = sentinel;
		for (int i = 1; i < nodeCount; i++){
			if (tempNode == n){
				return i;
			}else {
				tempNode = tempNode.getNext();
			}
		}
		return 1; //to prevent compiling error -- no return statement
	}
	
	//Method toString -- Returns a String containing all polygon coordinates and areas on their own line
	public String toString(){
		String tempString = "";
		currentReset();
		for (int i = 0; i < nodeCount; i++){
			tempString += current.toString() + "\n";
			current = current.getNext();
		}
		currentReset();
		return tempString;
	}
}