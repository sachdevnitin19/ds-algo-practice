import java.io.*;

class SearchInRotatedArray {
    static int binarySearch(int arr[],int start, int end, int searchElem){
        while(start<=end){
            int key=(end-start)/2+start;
            if(arr[key]==searchElem){
                return key;
            }
            else if(arr[key]<searchElem){
                start=key+1;
            }else {
                end=key-1;
            }
        }
        return -1;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String token[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(token[i]);
            }
            int elem = Integer.parseInt(br.readLine());

            int pivot=0;
            
            while (pivot <n - 1 && arr[pivot] < arr[pivot + 1]) {
                pivot++;
            }
            pivot++;
            if(elem==arr[0]){
                System.out.println(0);
            }else if(elem==arr[n-1]){
                System.out.println(n-1);
            }else if(elem>arr[0]){
                System.out.println(binarySearch(arr, 0, pivot-1, elem));
            }else if(elem<arr[n-1]){
                System.out.println(binarySearch(arr, pivot, n-1, elem));
            }
            
        }
    }
}