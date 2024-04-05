import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6};
		int[] b={1,2,3,4,5,6};
		
		//1.Total Combinations possible
	
		int tot_comb=a.length*b.length;
		System.out.println("Total Combinations possible in a dice game is:"+tot_comb);
		
		//2.Distribution of all possible Combination
		
		HashMap<Integer,Integer> h=new HashMap<>();
		System.out.print("Distribution of all possible combination:\n");
		for(int i=0;i<6;i++){
		    for(int j=0;j<6;j++){
		        int t=a[i]+b[j];
		        System.out.print("("+a[i]+","+b[j]+")="+t+" ");
		        h.put(t,h.getOrDefault(t,0)+1);
		    }
		    System.out.println();
		}
		
		//3.probability of all possible sums
		
		System.out.println("Probability of all possible sums:");
		for(int i=2;i<=12;i++){
		    double p=(double)h.get(i)/tot_comb;
		    System.out.print("P("+i+") = "+h.get(i)+"/"+tot_comb+" = ");
		    System.out.format("%.4f\n",p);
		}
	}
}


/* 
Output:

Total Combinations possible in a dice game is:36
Distribution of all possible combination:
(1,1)=2 (1,2)=3 (1,3)=4 (1,4)=5 (1,5)=6 (1,6)=7 
(2,1)=3 (2,2)=4 (2,3)=5 (2,4)=6 (2,5)=7 (2,6)=8 
(3,1)=4 (3,2)=5 (3,3)=6 (3,4)=7 (3,5)=8 (3,6)=9 
(4,1)=5 (4,2)=6 (4,3)=7 (4,4)=8 (4,5)=9 (4,6)=10 
(5,1)=6 (5,2)=7 (5,3)=8 (5,4)=9 (5,5)=10 (5,6)=11 
(6,1)=7 (6,2)=8 (6,3)=9 (6,4)=10 (6,5)=11 (6,6)=12 
Probability of all possible sums:
P(2) = 1/36 = 0.0278
P(3) = 2/36 = 0.0556
P(4) = 3/36 = 0.0833
P(5) = 4/36 = 0.1111
P(6) = 5/36 = 0.1389
P(7) = 6/36 = 0.1667
P(8) = 5/36 = 0.1389
P(9) = 4/36 = 0.1111
P(10) = 3/36 = 0.0833
P(11) = 2/36 = 0.0556
P(12) = 1/36 = 0.0278

*/
