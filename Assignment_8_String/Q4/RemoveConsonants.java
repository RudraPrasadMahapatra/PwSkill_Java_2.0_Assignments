//7. Write a program to delete all consonant from the string "Hello,have a good day"

        public class RemoveConsonants {
            public static void main(String[] args) {
                String str = "Hello, have a good day";
                String result = removeConsonants(str);
                System.out.println("String after removing consonants: " + result);
            }
                public static String removeConsonants(String str) {
                String vowels = "aeiouAEIOU";
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (vowels.indexOf(c) != -1 || Character.isWhitespace(c)) {
                        result.append(c);
                    }
                }
                return result.toString();
            }
        }
