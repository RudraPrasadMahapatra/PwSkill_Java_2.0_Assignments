//1. What is mutable string in java explain with an example .

/*Mutable String refers to "Making Change",
    if we try to make a change then those changes will be reflected in the same memory.
 */
//eg:
    public class MutableString {
        public static void main(String[] args) {
            StringBuffer s1 =new StringBuffer("Rudra ");
            s1.append("Prasad");//need not to store in another variable
            System.out.println(s1);//Rudra Prasad

        }
    }
