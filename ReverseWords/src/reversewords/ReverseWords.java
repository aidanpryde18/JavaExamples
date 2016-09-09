package reversewords;

import reversewords.jsjf.ArrayStack;

import java.util.Scanner;

public class ReverseWords {

    public static void main(String[] args) {
	    Scanner scanIn = new Scanner(System.in);
        Scanner split;
        String sentence;
        String reversed = "";
        ArrayStack stack = new ArrayStack(1);

        System.out.println("Please enter a sentence to be reversed: ");
        sentence = scanIn.nextLine();

        split = new Scanner(sentence);
        split.useDelimiter(" ");

        while(split.hasNext())
        {
            stack.push(split.next());
        }

        System.out.println(stack.size());

       while (!stack.isEmpty())
       {
           reversed += stack.pop() + " ";
       }

        System.out.println(reversed);

    }
}
