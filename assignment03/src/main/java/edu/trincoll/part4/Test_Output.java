package edu.trincoll.part4;
// Test Output File for  Assignment 3 Part 4
import java.util.Scanner;

public class Test_Output {
    public static void main(String[] args) {
        InToPost inToPost = new InToPost();
        InToPrefix inToPrefix = new InToPrefix();

        System.out.println("Type in an expression like (1+2)*(3+4)/(12-5)\n "
                + "with no monadic operators like in-5 or +5 followed by key");
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println("The Expression you have typed in infix form :\n" + str);
        // Test infix to postfix conversion
        System.out.println("The Equivalent Postfix Expression is :\n" + inToPost.inToPost_convert(str));

        // Test infix to prefix conversion
        System.out.println("The Equivalent Prefix Expression is :\n" + inToPrefix.inToPrefixConvert(str));
        scan.close();
    }
}
