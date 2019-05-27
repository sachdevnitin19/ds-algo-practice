import java.io.*;

class Pangram {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean checkChar[]=new boolean[26];
            String str=br.readLine();
            char currChar;
            for(int i=0;i<str.length();i++){
                currChar=str.charAt(i);
                if(currChar>='a'&&currChar<='z'){
                    checkChar[currChar-'a']=true;
                }
                if(currChar>='A'&&currChar<='Z'){
                    checkChar[currChar-'A']=true;
                }
            }
            boolean strIsPangram=true;
            for(int i=0;i<26;i++){
                if(!checkChar[i]) {
                    strIsPangram=false;
                    break;
                }
            }
            System.out.println(strIsPangram?"Yes":"No");
        }
    }
}