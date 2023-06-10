// 1.Write a java program to Reverse a string without using the inbuilt method.

public class ReverseString {
    public static void main(String[] args)
    {
        String s1 = "Rudra Prasad";
        ReverseStr(s1);

    }
    //Reverse String using Concatenation
    static void ReverseStr(String s1)
    {
        String rev = "";
        int lenght = s1.length();
        for (int i = lenght-1; i >=0 ; i--) {
            rev += s1.charAt(i);
        }
        System.out.println(rev);
    }
}
