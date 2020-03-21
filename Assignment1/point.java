// point.java
//**
// Author: Jordan McKee
// Course: Seng2200 Prog Lang and Paradigms
// Student Number: c3331542
//**
import java.lang.Math;
public class point{
	//Variable Declaration:
	private double pointX, pointY;
	
	//Constructors
	public point(double x, double y){
		pointX = x;
		pointY = y;
	}
	public point(){
		pointX = 0;
		pointY = 0;
	}
	
	//Mutator method
	public void setData(double x, double y){
		pointX = x;
		pointY = y;
	}
	
	//Accessor methods
	public double getX(){
		return pointX;
	}
	public double getY(){
		return pointY;
	}
	
	//Method calcDistance -- Returns distance from origin (0, 0) of point (x, y)
	public double calcDistance(){
		return distanceFromOrigin(pointX, pointY);
	}
	
	//Methiod distanceFromOrigin -- Returns the distance from origin of a point 
	public double distanceFromOrigin(double x, double y){
		double distance = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		return distance;
	}
	
	//Method toString -- Returns string form of point coordinates
	public String toString(){
		String coordinate = "(" + pointX + " , " + pointY + ")";
		return coordinate;
	}
}