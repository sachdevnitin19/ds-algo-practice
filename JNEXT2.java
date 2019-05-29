import java.io.*;

class JNEXT2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int strLength = Integer.parseInt(br.readLine());
            int strArr[] = new int[strLength];
            String token[] = br.readLine().split(" ");
            for (int k = 0; k < strLength; k++)
                strArr[k] = Integer.parseInt(token[k]);
            if(nextPermutation(strArr)){
                for(int i=0;i<strLength;i++){
                    System.out.print(strArr[i]+" ");
                }
                System.out.println();
            }else{
                System.out.println(0);
            }

        }
    }
    static boolean nextPermutation(int[] array) {
    // Find longest non-increasing suffix
    int i = array.length - 1;
    while (i > 0 && array[i - 1] >= array[i])
        i--;
    // Now i is the head index of the suffix
    
    // Are we at the last permutation already?
    if (i <= 0)
        return false;
    
    // Let array[i - 1] be the pivot
    // Find rightmost element that exceeds the pivot
    int j = array.length - 1;
    while (array[j] <= array[i - 1])
        j--;
    // Now the value array[j] will become the new pivot
    // Assertion: j >= i
    
    // Swap the pivot with j
    int temp = array[i - 1];
    array[i - 1] = array[j];
    array[j] = temp;
    
    // Reverse the suffix
    j = array.length - 1;
    while (i < j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
    }
    
    // Successfully computed the next permutation
    return true;
}
}