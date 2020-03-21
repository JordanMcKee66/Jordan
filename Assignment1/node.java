// node.java
//**
// Author: Jordan McKee
// Course: Seng2200 Prog Lang and Paradigms
// Student Number: c3331542
//**
public class node{
	//Variable Declaration:
	private polygon data;
	private node next, previous;
	
	//Constructor
	public node(polygon pData){
		data = pData;
		next = null;
		previous = null;
	}
	
	//Mutator Methods
	public void setData(polygon pData){
		data = pData;
	}
	public void setNext(node pNext){
		next = pNext;
	}
	public void setPrevious(node pPrevious){
		previous = pPrevious;
	}
	
	//Accessor Methods
	public polygon getPoly(){
		return data;
	}
	public node getNext(){
		return next;
	}
	public node getPrevious(){
		return previous;
	}
	public double getArea(){
		return data.calcArea();
	}

	
	//toString method
	public String toString(){
		String tempString;
		tempString = data.toString();
		return tempString;
	}
}