// 5.Write a java program to find the index of a substring.

public class SearchString {
    public static void main(String[] args) {
        String str = "Rudra";

        //Finding index using IndexOf method
        int intIdx = str.indexOf("ra");
        System.out.println("Substring Found at index :"+ intIdx);



        // Finding index of substring with out using indexOf method

        String subStr = "ra";
        int index =0;
        for (int i = 0; i < str.length(); i++) {
            l2:for (int j = 0; j < subStr.length(); j++) {
                if (str.charAt(i) != subStr.charAt(j)){
                    break l2;
                }
                index = i;

            }
        }
        System.out.println("Substring Found at index :"+index);


    }
}