// polygon.java
//**
// Author: Jordan McKee
// Course: Seng2200 Prog Lang and Paradigms
// Student Number: c3331542
//**
public class polygon{
	//Variable Declaration:
	private int pointCount;
	private point[] pointArray;
	
	//Constructor - Parameter n is number of sides 
	public polygon(int n){
		pointCount = n+1;
		pointArray = new point[n+1];
	}
	
	//Method addPoint -- Adds a point of two double values into the array of slot provided by int Parameter
	public void addPoint(int pointNumber, double x, double y){
		pointArray[pointNumber] = new point(x, y);
	}
	
	//Method minDistanceFromOrigin -- Returns the distance from origin of the closest point to origin (0, 0)
	public double minDistanceFromOrigin(){
		double minDistance = pointArray[0].calcDistance();
		for (int i = 1; i < pointCount-1; i++){
			if (pointArray[i].calcDistance() < minDistance)
				minDistance = pointArray[i].calcDistance();
		}
		return minDistance;
	}
	
	//Method calcArea -- Returns the Area of the polygon as a double value
	public double calcArea(){
		double tempArea = 0.0;
		//replicating the first point in the final position
		pointArray[pointCount-1] = new point(pointArray[0].getX(), pointArray[0].getY());
		//Mathematice for area calculation
		for (int i = 0; i < (pointCount - 1); i++){
			tempArea += (pointArray[i+1].getX() + pointArray[i].getX())*(pointArray[i+1].getY() - pointArray[i].getY());
		}
		tempArea = Math.abs(tempArea);
		tempArea = (tempArea/2);
		return tempArea;
	}
	
	//Method toString -- Returns a string of all points in point form followed by the area 
	public String toString(){
		String points = "[";
		for (int i = 0; i < pointCount-1; i++){
			points += pointArray[i].toString();
		}
		points = points + "]: " + calcArea();
		return points;
	}
	
/*	
	//Method comesBefore
	public boolean comesBefore(polygon p){
		double difference = (Math.abs(calcArea() - p.calcArea()))/100;
		if (difference <= 0.1){
			if (minDistanceFromOrigin() < p.minDistanceFromOrigin()){
				return true;
			}
		}else if(calcArea() < p.calcArea()){
			return true;
		}
		return false;
	}*/
}