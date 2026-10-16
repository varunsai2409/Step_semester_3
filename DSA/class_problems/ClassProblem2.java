import java.util.Scanner;

public class ClassProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(word + (word.equals(reversed) ? " - palindrome" : " - not a palindrome"));
        System.out.println(reversed + (word.equals(reversed) ? " - palindrome" : " - not a palindrome"));
    }
}
