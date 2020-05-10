import java.io.*;
import java.util.*;

public class Solution {
    
    
    
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
     }
    
  

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        FastReader bi = new FastReader();
        int n=bi.nextInt();
        String st = bi.nextLine();
        String [] words=st.split(" ");
        Map <String,Integer> count =new HashMap <> (n);
        
        for(String word : words){   
           if(count.containsKey(word)){
                count.replace(word,count.get(word)+1);
            }
            else{
                count.put(word,1);
            }
        }
        
        
        int theMost=0;
        String winner=null;
        for(String word : count.keySet()){
            int wordVal=count.get(word);
            if(wordVal>theMost){
                theMost=wordVal;
                winner=word;
            }
            else if(wordVal==theMost){
               if(word.compareTo(winner)<0){
                    theMost=count.get(word);
                    winner=word;
                } 
            }   
        }
        

        System.out.print(winner+" "+theMost);
        
        
    }
}