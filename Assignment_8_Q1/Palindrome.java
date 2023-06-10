// 2.Write a java program to know whether the given string is palindrome

import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";
        System.out.println("Enter a string to palindrome or not");
        str = in.nextLine();
        if (IsPalindrome(str)){
            System.out.println("String is a palindrome.");
        }
        else{
            System.out.println("String is not palindrome.");
        }

    }
    //If the string is Palindrome it will return true otherwise false
    static boolean IsPalindrome(String str){
        if (str.length()== 0){
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() -1-i);
            if (start != end){
                return false;
            }
        }
        return true;
    }
}
