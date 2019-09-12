import java.io.*;

class CountAndSay{
    public static void main(String args[]) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        System.out.println(countAndSay(n));
    }
    public static String countAndSay(int n) {
        StringBuilder prevSeq=new StringBuilder("1");
        for(int i=1;i<n;i++){
            StringBuilder currSeq=new StringBuilder("");
            char tempChar=prevSeq.charAt(0);
            int ctr=1;
            for(int j=1;j<prevSeq.length();j++){
                if(tempChar!=prevSeq.charAt(j)){
                    currSeq.append(ctr).append(tempChar);
                    tempChar=prevSeq.charAt(j);
                    ctr=1;
                }else{
                    ctr++;
                }
            }
            if(ctr!=0){
                currSeq.append(ctr).append(tempChar);
                ctr=0;
            }
            prevSeq=currSeq;
        }
        return prevSeq.toString();
    }
}