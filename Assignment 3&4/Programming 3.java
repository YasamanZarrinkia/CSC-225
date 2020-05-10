import java.io.*;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Collections;
import java.lang.*;


public class Solution {
    
    
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//for smaller numbers
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();//for larger numbers 

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String str = "x+324235+x^2+x^3+x^4+x^4+x^2+478+x=312906549560820726995721624835882027405751227190504436580211986258705046748570772908879263150492811748303025831229539711084999775754007038711751195976362815670058487781720472241025";

        String[] arr = str.split("\\+");

        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        lordMedian(array);  
        
    }


    
    
    public static void lordMedian(int [] array){
        
        long lordMedian=1;
        for(int i=0;i<array.length;i++){
            addNum(array[i]);
            int m=median();
            lordMedian *= m;
            //System.out.println(m);
            lordMedian %= 1000000007;
        }
        System.out.println(lordMedian);
        
          
    }
    
    
    public static void addNum(int a){   
        if(maxHeap.isEmpty()){
            maxHeap.add(a);
        }
        else if(maxHeap.size()==minHeap.size()){
            
                minHeap.add(a);
                maxHeap.add(minHeap.remove());
                     
            
        }
        else if(maxHeap.size()>minHeap.size()){
            if(minHeap.isEmpty() || a<minHeap.peek()){
                maxHeap.add(a);
                minHeap.add(maxHeap.remove());
                
            }
            else{
                minHeap.add(a);      
            }    
        }   
    }
    
    
    public static int median(){
            return maxHeap.peek();
    }
    
    
}