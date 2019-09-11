import java.io.*;
import java.util.*;
class PASCAL{
    public static void main(String args[]) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int length=Integer.parseInt(br.readLine());
        int [][] pascalTriangle=generatePascal(length);
        for(int i=0;i<pascalTriangle.length;i++){
            for(int j=0;j<pascalTriangle[i].length;j++){
                System.out.print(pascalTriangle[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("ArrayList");
        List<List<Integer>> output=generatePascalList(length);
        Iterator <List<Integer>> outerItr=output.iterator();
        while(outerItr.hasNext()){
            List<Integer> innerList=(List<Integer>)outerItr.next();
            Iterator<Integer> innerItr=innerList.iterator();
            while(innerItr.hasNext()){
                System.out.print((Integer)innerItr.next()+" ");
            }
            System.out.println();
        }
    }
    public static int[][] generatePascal(int length) {
        int [][] pascalTriangle=new int[length][];
        for(int i=0;i<pascalTriangle.length;i++){
            pascalTriangle[i]=new int[i+1];
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    pascalTriangle[i][j]=1;
                }else{
                    pascalTriangle[i][j]=pascalTriangle[i-1][j-1]+pascalTriangle[i-1][j];
                }
            }
        }
        return pascalTriangle;
    }

    public static List<List<Integer>> generatePascalList(int length) {
        List<List<Integer>> l1=new ArrayList<List<Integer>>();
        for(int i=0;i<length;i++){
            List <Integer>l2=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    l2.add(j,1);
                }else{
                    List<Integer> prev=l1.get(i-1);
                    l2.add(j,(prev.get(j-1)+prev.get(j)));
                }
            }
            l1.add(i,l2);
        }
        return l1;
    }
}