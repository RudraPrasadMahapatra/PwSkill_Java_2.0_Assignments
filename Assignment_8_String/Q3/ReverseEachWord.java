//3. Write a program to reverse sentence while preserving the position.
public class ReverseEachWord {
    public static void main(String[] args) {
        //Approach 1

    String s1 = "Think Twice";
    String revStr = "";
    String[] words = s1.split(" ");
    for(String w : words){
        String revWords = "";
        for (int i = w.length()-1; i >=0  ; i--) {
            revWords += w.charAt(i);
        }
        revStr += revWords +" ";
    }
        System.out.println(revStr);


   //Approach 2
        /*
        String str = "Think Twice";
        String[] word = str.split(" ");
        String revString = "";
        for(String w : word){
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            revString += sb.toString()+" ";
        }
        System.out.println(revString);
         */
    }


}
