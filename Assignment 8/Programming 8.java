import java.io.*;
import java.util.*;

public class Solution {
    
    
   public static class cell {
        int col;
        int row;
        cell(int row, int col) {
            this.col = col;
            this.row = row;
        }
        public int getCol() {
            return this.col;
        }
        public int getRow() {
            return this.row;
        }
    }
    
    static char[][] neighbours;
    static boolean[][] v;
    static int[][] d;
    static int n;
    static cell start;


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        d=new int [n][n];
        v=new boolean[n][n];
        neighbours=new char[n][n];
        //cell start;
        for(int i=0;i<n;i++){
            String str=sc.next();
            for(int j=0;j<n;j++){
                neighbours[i][j]=str.charAt(j);
                if(neighbours[i][j]=='S')
                    start=new cell(i,j);
                
            }
        }
        
        int distance = bfs(start,neighbours);
        if (distance == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(distance);
        }
        
        
       
 
    }
    
    
    public static int bfs(cell start,char [][] neighbours){
        
        Queue<cell> q = new ArrayDeque<>();
        q.add(start);
        d[start.getRow()][start.getCol()]=0;
        v[start.getRow()][start.getCol()]=true;
        while(!q.isEmpty()){
            cell cur=q.poll();
            int row=cur.getRow();
            int col=cur.getCol();
            if(neighbours[row][col]=='K'){ 
                return d[row][col];
            }
            else{
                
                if(row-1>=0 && v[row-1][col]==false){
                    v[row-1][col]=true;
                    d[row-1][col]=d[row][col]+1;
                    
                    if(neighbours[row-1][col]!='x'){
                        q.add(new cell(row-1,col));
                    }
                   // q.add(new cell(row-1,col));
                }
                
                if(row+1<n && v[row+1][col]==false){
                    v[row+1][col]=true;
                    d[row+1][col]=d[row][col]+1;
                    if(neighbours[row+1][col]!='x'){
                        q.add(new cell(row+1,col));
                    }
                    //q.add(new cell(row+1,col));
                }
                
                if(col-1>=0 && v[row][col-1]==false){
                    v[row][col-1]=true;
                    d[row][col-1]=d[row][col]+1;
                    if(neighbours[row][col-1]!='x'){
                        q.add(new cell(row,col-1));
                    }
                    //q.add(new cell(row,col-1));
                }
                
                if(col+1<n && v[row][col+1]==false){
                    v[row][col+1]=true;
                    d[row][col+1]=d[row][col]+1;
                    if(neighbours[row][col+1]!='x'){
                        q.add(new cell(row,col+1));
                    }
                    //q.add(new cell(row,col+1));
                }
                //return d[row][col];    
            }
            
            
        }
        return -1;
        
    }
    
    
    
    
    
    
}