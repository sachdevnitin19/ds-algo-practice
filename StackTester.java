import java.io.*;
import com.nitin.utils.GenericArrayStack;

class StackTester {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            GenericArrayStack<Character> st=new GenericArrayStack<Character>(10000);
            String str = br.readLine();
            char ch;
            int validStrLength = 0, actualStrLength = 0;

            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if ((!st.isStackEmpty() && st.peek() == '<') && ch == '>') {
                    validStrLength += 2;
                    st.pop();
                } else {
                    st.push(ch);
                }
                if (st.isStackEmpty()) {
                    actualStrLength = validStrLength;
                }
            }
            System.out.println(actualStrLength);
        }

    }
}