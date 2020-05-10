import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] A=new int[n];
        int [] B=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i]=sc.nextInt();
        }
        int an=recursion(A,B);
        System.out.println(an);
        
    }
    public static int recursion(int[]A,int[]B){
        if(A.length % 2==1){
            int r=0;
            for(int i=0;i<A.length;i++){
                r+= A[i]*B[i];
            }
            return r;
            
           }else{
               int size=A.length/2;
               int [] aNo=new int[size];
               int [] aNs=new int[size];
               int [] bNo=new int[size];
               int [] bNs=new int[size];
               for(int j=0;j<size;j++){
                   aNo[j]=A[j];
                   bNo[j]=B[j];
                }
                int j=size;
                for(int i=0;i<size;i++){
                    aNs[i]=A[j];
                    bNs[i]=B[j];
                    j++;               
                }
                return recursion(aNo,aNs)+recursion(bNo,bNs)+recursion(aNo,bNs)+recursion(aNs,bNo);   
            } 
        }
   
}