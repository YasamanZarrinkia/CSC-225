import java.io.*;
import java.util.*;

public class Solution {


    private static class Pair{
        int first;
        int second;
    

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    public static Pair[] inputGenerator(int n){ /* be careful to not modify this function */
        long last = 5000011;
        long mult1 = 5000087;
        long mult2 = 5000167;

        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
           last = (last * mult1 + mult2)%n;
           int x = (int)last;
           last = (last * mult2 + i + mult1)%n;
           int y = (int)last;
           arr[i] = new Pair(x, y);
        }
        return arr;
    }
    


     private static class Item{
        int key;
        Pair data;

        public Item(int key, Pair data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "(" + data.first+ ","+data.second+ ")"; //To change body of generated methods, choose Tools | Templates.
        }
    }


     static void usefulCountingSort(Item[] A, int k){
        ArrayList< ArrayList<Item> > C = new ArrayList<>();
        
        for(int i = 0; i < k; i++)
            C.add(new ArrayList<>());
        
        for(int i = 0; i < A.length; i++){
            int key = A[i].key;
            C.get(key).add(A[i]); //takes O(1) time
        }
        
        int index = 0;
        for(int i = 0; i < k; i++)
            for(int j = 0; j < C.get(i).size(); j++)
                A[index++] = C.get(i).get(j);
    }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc=new Scanner(System.in);
        int np=sc.nextInt();
        int m=sc.nextInt();
        Pair[] inputArray = inputGenerator(np);
        Item[] items=new Item[np];
        for(int i=0;i<np;i++){
            Pair p=inputArray[i];
            items[i]=new Item((p.second+i)%np,p);
        }

        usefulCountingSort(items,np);

        for(int i=0;i<np;i++){
            Item item=items[i];
            Pair pair=item.data;
            item.key=(pair.first+2*i)%np;
        }

        usefulCountingSort(items,np);

        for(int i = 0; i < items.length; i++){
            if(i%m==0)
                System.out.println(items[i]);
        }

    }
}
