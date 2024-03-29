import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] a={1,2,2,3,3,4};
		int[] b={1,4,5,6,7,8};

		//1.Total Combinations possible

		int tot_comb=a.length*b.length;
		System.out.println("Total Combinations possible in a dice game is:"+tot_comb);

		//2.Distribution of all possible Combinations

        HashMap<Integer,Integer> h=new HashMap<>();
		int[][] dist_pos_comb=new int[6][6];
		for(int i=0;i<6;i++){
		    for(int j=0;j<6;j++){
		        int t=a[i]+b[j];
		        h.put(t,h.getOrDefault(t,0)+1);
		        dist_pos_comb[i][j]=t;
		    }
		}
		System.out.print("Distribution of all possible combination:\n");
		for(int[] r:dist_pos_comb){
		    System.out.println(Arrays.toString(r));
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

/*Output

Total Combinations possible in a dice game is:36
Distribution of all possible combination:
[2, 5, 6, 7, 8, 9]
[3, 6, 7, 8, 9, 10]
[3, 6, 7, 8, 9, 10]
[4, 7, 8, 9, 10, 11]
[4, 7, 8, 9, 10, 11]
[5, 8, 9, 10, 11, 12]
Probability of all possible sums:
P(2) = 1/36 = 0.0278
P(3) = 2/36 = 0.0556
P(4) = 2/36 = 0.0556
P(5) = 2/36 = 0.0556
P(6) = 3/36 = 0.0833
P(7) = 5/36 = 0.1389
P(8) = 6/36 = 0.1667
P(9) = 6/36 = 0.1667
P(10) = 5/36 = 0.1389
P(11) = 3/36 = 0.0833
P(12) = 1/36 = 0.0278

*/
