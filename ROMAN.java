import java.io.*;

class ROMAN {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Roman = br.readLine();
        System.out.println(romanToInt(Roman));
    }

    public static int romanToInt(String s) {
        int i = 1, value = getValue(s.charAt(0)), prevCharValue = getValue(s.charAt(0)), currCharValue = 0;
        while (i < s.length()) {
            currCharValue = getValue(s.charAt(i));
            if (prevCharValue < currCharValue) {
                value = (value - prevCharValue) + (currCharValue - prevCharValue);
            } else {
                value += currCharValue;
            }
            prevCharValue = currCharValue;
            i++;
        }
        return value;
    }

    public static int getValue(char ch) {
        int value = 0;
        switch (ch) {
        case 'I':
            value = 1;
            break;
        case 'V':
            value = 5;
            break;
        case 'X':
            value = 10;
            break;
        case 'L':
            value = 50;
            break;
        case 'C':
            value = 100;
            break;
        case 'D':
            value = 500;
            break;
        case 'M':
            value = 1000;
            break;
        default:
            value = 1;
            break;
        }
        return value;
    }
}