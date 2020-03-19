public class node{
	private polygon data;
	private node next, previous;
	
	public node(polygon pData, node pNext, node pPrevious){
		data = pData;
		next = pNext;
		previous = pPrevious;
	}
	
	public node(polygon pData){
		data = pData;
		next = null;
		previous = null;
	}
	
	public void setData(polygon pData){
		data = pData;
	}
	
	public void setNext(node pNext){
		next = pNext;
	}
	
	public void setPrevious(node pPrevious){
		previous = pPrevious;
	}
	
	public polygon getData(){
		return data;
	}
	
	public node getNext(){
		return next;
	}
	
	public node getPrevious(){
		return previous;
	}
	
	public polygon getPoly(){
		return data;
	}
	
	public double getArea(){
		return data.calcArea();
	}
	
	public String toString(){
		String tempString;
		tempString = data.toString();
		return tempString;
	}
}