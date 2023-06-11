//4. How do we compare two strings in java ? Give an example
/*
    We can compare two strings for equality using the equals() method .
 */
public class StringComparison {

        public static void main(String[] args) {
            String str1 = "RudraPrasad";
            String str2 = "RudraPrasad";
            String str3 = "RudraPrasad";

            // Using the equals() method
            boolean isEql1 = str1.equals(str2);
            System.out.println("Strings str1 and str2 are equal: " + isEql1);

            boolean isEql2 = str1.equals(str3);
            System.out.println("Strings str1 and str3 are equal: " + isEql2);
        }
    }


