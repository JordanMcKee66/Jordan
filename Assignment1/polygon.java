public class polygon{
	int pointCount;
	point[] pointArray;
	
	public polygon(int n){	//n is number of sides
		pointCount = n+1;
		pointArray = new point[n+1];
	}
	
	public void addPoint(int pointNumber, double one, double two){
		pointArray[pointNumber] = new point(one, two);
	}
	
	public double minDistanceFromOrigin(){
		double minDistance = pointArray[0].calcDistance();
		for (int i = 1; i < pointCount-1; i++){
			if (pointArray[i].calcDistance() < minDistance)
				minDistance = pointArray[i].calcDistance();
		}
		return minDistance;
	}
	
	public double calcArea(){
		double tempArea = 0.0;
		pointArray[pointCount-1] = new point(pointArray[0].getX(), pointArray[0].getY());
		for (int i = 0; i < (pointCount - 1); i++){
			tempArea += (pointArray[i+1].getX() + pointArray[i].getX())*(pointArray[i+1].getY() - pointArray[i].getY());
		}
		tempArea = Math.abs(tempArea);
		tempArea = (tempArea/2);
		return tempArea;
	}
	
	public String toString(){
		String points = "[";
		for (int i = 0; i < pointCount-1; i++){
			points += pointArray[i].toString();
		}
		
	points = points + "]: " + calcArea();
		return points;
	}
}