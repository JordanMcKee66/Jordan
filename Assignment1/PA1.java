// PA1.java
//**
// Author: Jordan McKee
// Course: Seng2200 Prog Lang and Paradigms
// Student Number: c3331542
//**

import java.io.*;
import java.util.Scanner;

class PA1{
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		myPolygons list = new myPolygons();
		myPolygons sortedList = new myPolygons();
		
		Scanner file = new Scanner(new File("file.txt"));
		
		try{
			while (file.hasNext()){
				String pCheck = file.next();
				if (pCheck.equals("P")){
					int pointCount = file.nextInt();
					polygon tempPoly = new polygon(pointCount);
					for (int i=0; i < pointCount; i++){
						double tempX = file.nextDouble();
						double tempY = file.nextDouble();
						tempPoly.addPoint(i, tempX, tempY);
					}
					list.append(tempPoly);
				}
			}
			
		} catch(Exception e){
			System.out.println("Error: Could not read file 'inputfile.txt'");
		}
		//Method to read text files and translate them into arrays, before 
		System.out.println("Unsorted List");
		System.out.println(list.toString());
		
		list.sort();
		
		System.out.println("Sorted List");
		System.out.println(list.toString());
		
	}
}
