//How do you concatenate two strings in java explain with an example ?
/*
    In Java, we can concatenate two strings using the "+" operator or
    by using the concat() method.
 */
//Eg:
        public class StrConcat {
            public static void main(String[] args) {

                        String s1 = "Rudra";
                        String s2 = "Prasad";

                        // Using the "+" operator
                        String result1 = s1 + " " + s2;
                        System.out.println("Result 1: " + result1); // Output: Result 1: Hello World

                        // Using the concat() method
                        String result2 = s1.concat(" ").concat(s2);
                        System.out.println("Result 2: " + result2); // Output: Result 2: Hello World

            }
        }
