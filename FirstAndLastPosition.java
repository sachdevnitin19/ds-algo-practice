import java.io.*;

class FirstAndLastPosition{
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int [] arr=new int[n];
        String token[]=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(token[i]);
        }
        int searchElem=Integer.parseInt(br.readLine());
        int firstAndLastPosition[]= firstAndLastPosition(arr,searchElem);
        System.out.println(firstAndLastPosition[0]+" "+firstAndLastPosition[1]);
    }
    public static int[] firstAndLastPosition(int [] arr, int searchElem){
        int elemIndex=binarySearch(arr,searchElem);
        int firstAndLastPosition[]=new int[2];
        if (elemIndex==-1){
            firstAndLastPosition[0]=-1;
            firstAndLastPosition[1]=-1;
        }else{
            int l=elemIndex,r=elemIndex;
            while(l>0&&arr[l]==searchElem){
                l--;
            }
            while(r<arr.length&&arr[r]==searchElem){
                r++;
            }

            if(l<0){
                firstAndLastPosition[0]=0;
            }else if(arr[l]==searchElem){
                firstAndLastPosition[0]=l;
            }else{
                firstAndLastPosition[0]=l+1;
            }

            if(r>=arr.length){
                firstAndLastPosition[1]=arr.length-1;    
            }else if(arr[r]==searchElem){
                firstAndLastPosition[1]=r;
            }else{
                firstAndLastPosition[1]=r-1;
            }
        }
        return firstAndLastPosition;
    }
    public static int binarySearch(int [] arr, int searchElem){
        int l=0,r=arr.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(arr[m]==searchElem){
                return m;
            }else if(arr[m]>searchElem){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return -1;
    }
}