import java.io.*;
import java.util.*;
public class Main
{
    // finding probabilties for different combinations of A and B
    public static int[] cal_prob(int[] a,int[] b){
        int[] t=new int[11];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                int p=a[i]+b[j];
                t[p-2]++;
            }
        }
        return t;
    }
    //Dooming dice A
    public static void undoom_dice(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]>4){
               a[i]-=3;
            }
        }
        Arrays.sort(a);
        System.out.println("Undoomed Dice A:"+Arrays.toString(a));
        List<Integer> cur=new ArrayList<>();
		int t=8;
        cur.add(1);
        cur.add(t);
		findcombinations(t-1,6,2,cur,a);
    }
    //probabilities of possible sums obtained previously
    public static int[] cur_prob=new int[11];
    
    public static void findcombinations(int n,int k,int s,List<Integer> cur,int[] a){
        if(cur.size()==k){
            int[] primitive = cur.stream().mapToInt(Integer::intValue).toArray();
            if(Arrays.equals(cal_prob(a,primitive),cur_prob)){
                Arrays.sort(primitive);
                System.out.println("Undoomed Dice B:"+Arrays.toString(primitive));
            }
            return;
        }
        for(int i=s;i<=n;i++){
            cur.add(i);
            findcombinations(n,k,i+1,cur,a);
            cur.remove(cur.size()-1);
        }
    }
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6};
		int[] b={1,2,3,4,5,6};
		cur_prob=cal_prob(a,b);
		System.out.println("Original Dice A:"+Arrays.toString(a));
		System.out.println("Original Dice B:"+Arrays.toString(b));
		undoom_dice(a,b);
	}
}

/*
Output:
Original Dice A:[1, 2, 3, 4, 5, 6]
Original Dice B:[1, 2, 3, 4, 5, 6]
Undoomed Dice A:[1, 2, 2, 3, 3, 4]
Undoomed Dice B:[1, 3, 4, 5, 6, 8]
*/
