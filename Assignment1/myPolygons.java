public class myPolygons{
	private node sentinel, current;
	int nodeCount, currentPosition;
	
	public myPolygons(){
		sentinel = null;
		nodeCount = 0;
		currentPosition = 0;
	}
	
	public void prepend(polygon p){ //add node to start
		if (nodeCount == 0){
			sentinel = new node(p);
			sentinel.setNext(sentinel);
			sentinel.setPrevious(sentinel);
			current = sentinel;
			nodeCount++;
			currentPosition = 1;
		}else {
			node tempNode = new node(p);
			current = sentinel.getPrevious();
			currentPosition = nodeCount - 1;
			current.setNext(tempNode);
			sentinel.setPrevious(tempNode);
			tempNode.setPrevious(current);
			tempNode.setNext(sentinel);
			sentinel = tempNode;
			nodeCount++;
			currentReset();
		}
	}
	
	public void append(polygon p){ //add node to end
		if (nodeCount == 0){
			sentinel = new node(p);
			sentinel.setNext(sentinel);
			sentinel.setPrevious(sentinel);
			current = sentinel;
			nodeCount++;
			currentPosition = 1;
		}else {
			node tempNode = new node(p);
			current = sentinel.getPrevious();
			currentPosition = nodeCount - 1;
			current.setNext(tempNode);
			sentinel.setPrevious(tempNode);
			tempNode.setPrevious(current);
			tempNode.setNext(sentinel);
			current = tempNode;
			nodeCount++;
			currentReset();
		}
	}
	
	public void insert(polygon p){ //insert node behind current
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
			if (currentPosition == 1){
				sentinel = current;
			}
		}
	}
	
	public void currentStep(){
		if (current.getNext() == sentinel){
			current = sentinel;
			currentPosition = 1;
		}else {
			current = current.getNext();
			currentPosition++;
		}
	}
	
	public void remove(int position){ //remove
		if (position > nodeCount){
			System.out.println("Error: no node found");
		}else{
		currentReset();
		while (currentPosition != position){
			current = current.getNext();
			currentPosition++;
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
	
	public void currentReset(){
		current = sentinel;
		currentPosition = 1;
	}
	
	public void currentReport(){
		System.out.println("The current position is " + currentPosition + " out of " + nodeCount + " total nodes");
	}

	public void sort(){
		currentReset();
		node key;
		for(int i = 1; i < nodeCount; i++){
			key = current.getNext();
			while (current.getArea() <= key.getArea()){
				current = key;
				key = current.getNext();
				currentPosition++;
				if (key == sentinel){
					break;
				}
			}
			if (key == sentinel){
				break;
			}
			while (key.getArea() <= current.getArea()){
				if (currentPosition == 1){
					insert(key.getPoly());
					remove(getPosition(key));
					break;
				}
				current = current.getPrevious();
				currentPosition--;
			}
			if (current != sentinel){
				current = current.getNext();
				insert(key.getPoly());
				remove(getPosition(key));
			}
		}
	}
	
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