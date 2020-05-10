import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
 
        FastReader fr = new FastReader();
        String string = fr.next();
        
        char[] temp;
        String[] parts = string.split("[\\+=]");
 
        BigInteger target = new BigInteger(parts[parts.length - 1]);
        BigInteger high = new BigInteger(parts[parts.length - 1]);
        BigInteger low = BigInteger.valueOf(0);
        BigInteger number = binarySearch(parts, high, low, target);
        
        
        System.out.println(number);
    }


    static class FastReader {
    
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
        }
    }

    public static BigInteger binarySearch(String[] parts, BigInteger high, BigInteger low, BigInteger target){
        BigInteger mid = BigInteger.valueOf(0);
        BigInteger tocompare =  BigInteger.valueOf(0);

        while(low.compareTo(high) < 0){
           
            mid = (low.add(high));
            mid =  mid.divide(BigInteger.valueOf(2));         
            
            //System.out.println("THE MID VALUE IS " + mid + " HIGH IS " + high + " LOW IS " + low);
            
            tocompare = calculater(parts, mid);
            
            if(tocompare.compareTo(target) == 0){
                break;
            }
            else if(tocompare.compareTo(target) > 0){
               high = mid;
            }
            else{
                low = mid;
            }
        } 
        return mid;
    }
    

    public static BigInteger calculater(String[] parts, BigInteger guess){
        BigInteger number = BigInteger.valueOf(0);
        int k = 0;
        BigInteger temp2;
        int p2 = 0; 
        char[] temp;
        for(int j = 0; j < (parts.length-1); j++){
            
            if(parts[j].length() == 3){
                temp = parts[j].toCharArray();
                number = number.add(guess.pow((int)(temp[2]-'0')));
            }
            else if(parts[j].equals("x")){
                
                number = number.add(guess);
            }
            else{
               
                temp2 = new BigInteger(parts[j]);
                number = number.add(temp2);
            }
            
        }
        
        return number;       
    }
    
}