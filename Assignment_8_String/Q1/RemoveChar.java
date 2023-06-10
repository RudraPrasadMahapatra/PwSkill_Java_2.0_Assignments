// 4.Write a java program to remove a particular character from a String.

public class RemoveChar {
    public static void main(String[] args) {
        String s1 = "Rudra Prasad";
        char charToRemove ='P';

        StringBuilder result = removeChar(s1,charToRemove);
        System.out.println(result);
    }

    private static StringBuilder removeChar(String s1, char charToRemove) {
        StringBuilder s2 = new StringBuilder("");
        for (int i = 0; i < s1.length(); i++) {
            if (charToRemove != s1.charAt(i)){
                s2.append(s1.charAt(i));
            }
        }
        return s2;
    }

}