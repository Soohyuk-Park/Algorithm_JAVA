package Structure.Stack;

import java.io.*;
        import java.util.*;

public class JAVA9935{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String boom = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int boom_length = boom.length();
        for(int i = 0; i<word.length(); i++){
            stack.push(word.charAt(i));
            if( stack.size() >= boom_length && boom.charAt(boom_length-1) == stack.peek()){
                boolean flag = true;
                for( int j = 0; j < boom_length; j++){
                    if( boom.charAt(j) != stack.get(stack.size() - boom_length + j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for (int j = 0; j < boom_length; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character alpha : stack) {
            sb.append(alpha);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}