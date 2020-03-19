import java.lang.Math;
public class point{
	private double pointX, pointY;
	
	public point(double x, double y){
		pointX = x;
		pointY = y;
	}
	public point(){
		pointX = 0;
		pointY = 0;
	}
	
	public void setData(double x, double y){
		pointX = x;
		pointY = y;
	}
	
	public double getX(){
		return pointX;
	}
	
	public double getY(){
		return pointY;
	}
	
	public double calcDistance(){
		return distanceFromOrigin(pointX, pointY);
	}
	
	public double distanceFromOrigin(double x, double y){
		double distance = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		return distance;
	}
	
	public String toString(){
		String coordinate = "(" + pointX + " , " + pointY + ")";
		return coordinate;
	}
}