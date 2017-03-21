import java.util.Scanner;
class Point {
	double x,y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	double x() { return x; }
	double y() { return y; }
}
public class fuzzy {
	
	public static void main(String []args) {
	      Scanner sc = new Scanner(System.in);
	      int n = 4;
	      double left = 0, right = 0, mid = 0;
	      double area1 = 0, area2 = 0, area3 = 0, areaLeft = 0, areaRight = 0, sumArea = 0;
	      boolean equal = false;
	      Point[] p = new Point[n];
	      for(int i=0;i<n;i++) {
	    	  p[i] = new Point(sc.nextDouble(),sc.nextDouble());
	      }
	      left = p[0].x;
	      right = p[n-1].x;
	      mid = (left+right)/2;
	      area1 = (p[1].x-p[0].x)*(p[0].y);
	      area2 = 0.5*(p[2].x-p[1].x)*(p[1].y+p[2].y);
	      area3 = (p[3].x-p[2].x)*p[2].y;
	      sumArea = area1+area2+area3;
	      while(!equal) {
		      mid = (left+right)/2;
		      if(mid==p[1].x) {
		    	  areaLeft = area1;
		    	  areaRight = sumArea - areaLeft; 
		      }
		      else if(mid==p[2].x) {
		    	  areaLeft = area1+area2;
		    	  areaRight = sumArea-areaLeft;
		      }
		      else if(mid>=p[0].x && mid<=p[1].x) {
		    	  areaLeft = (mid-p[0].x)*p[0].x;
		    	  areaRight = sumArea-areaLeft;
		      }
		      else if(mid>=p[1].x && mid<=p[2].x) {
		    	  areaLeft = area1+(0.5*(p[1].y+((mid-p[1].x)/(p[2].x-p[1].x)))*(mid-p[1].x));
		    	  areaRight = sumArea - areaLeft;
		      }
		      else if(mid>=p[2].x && mid<=p[3].x) {
		    	  areaLeft = area1+area2+((mid-p[2].x)*p[2].y);
		    	  areaRight = sumArea-areaLeft;
		      }
		      if(areaLeft<areaRight) {
		    	  left = mid;
		      }
		      else if(areaLeft>areaRight) {
		    	  right = mid;
		      }
		      if(areaLeft==areaRight) {
		    	  equal = true;
		      }
	      }
	      System.out.println("Mid = "+mid);
	      System.out.println("Sum Area = "+sumArea );
	      System.out.println("Area Left = "+areaLeft);
	      System.out.println("Area Right = "+areaRight);
	      sc.close();
	}
}