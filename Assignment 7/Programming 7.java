import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader fr=new FastReader();
        int n=fr.nextInt();
        int k=fr.nextInt();
        
        int [] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=fr.nextInt();
        }

        StringBuilder sr=new StringBuilder();
        TreeSet<Integer> tr=new TreeSet();
        for(int i=0;i<k;i++)
            tr.add(array[i]);
        for(int i=k-1;i<n;i++){
            System.out.println(tr);
            tr.add(array[i]);
            System.out.println(tr);
            int fLargest=tr.pollLast();
            int sLargest=tr.last();
            tr.add(fLargest);
            int sum=fLargest+sLargest;
            sr.append(sum+" ");
            tr.remove(array[i-K+1]);
            }
            
        System.out.println(sr.toString());
   
        
    }
    
    /*This class is taken from geeksforgeeks.org*/
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
}
