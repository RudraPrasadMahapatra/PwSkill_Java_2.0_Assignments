// 5.Write a java program to check if 'e' present in the word Umbrella ?

public class SearchCharInWord {
    public static void main(String[] args) {
        String str = "Umbrella";
        char target = 'e';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)== target){
                System.out.println("'e' is present  in the word Umbrella");
                break;
            }
            else{
                System.out.println("'e' is not present in the word Umbrella");
            }
        }
    }
}