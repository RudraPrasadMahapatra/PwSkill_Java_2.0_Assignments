//4. Write a program to sort a string alphabetically
        import java.util.Arrays;
        public class SortTheString {
            public static void main(String[] args) {
            //Approach 1 :  using sorting
                String str= "Rudra";
                char[] arr = str.toCharArray();
                char temp;
                for (int i = 0; i < arr.length; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i]>arr[j]){
                            temp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
                System.out.println(new String(arr));

            //Approach 1 : Using sort() method of Arrays class
                /*
                String str1= "Rudra";
                char[] arr1 = str1.toCharArray();
                Arrays.sort(arr1);
                   System.out.println(new String (arr1));
                 */
            }
        }
