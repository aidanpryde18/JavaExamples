package groupon;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author AQS242RW
 */
public class Groupon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name, coupon, date;
        int sessionNum;
        double total;
        boolean programRepeat = true;
        String repeatQuestion;
        final double SHORT_PRICE = 15;
        final double LONG_PRICE = 30;
        final double SHORT_DISCOUNT = .20;
        final double LONG_DISCOUNT = .25;

        Scanner scan = new Scanner(System.in);

        NumberFormat dollar = NumberFormat.getCurrencyInstance();
        
        while(programRepeat){

                //  INPUT SECTION
                
                System.out.println("Enter your name:   ");

                name = scan.next();

                System.out.println("What is the purchase date?(mm/dd/yyyy):    ");

                date = scan.next();

                System.out.println("Groupon code?:   ");

                coupon = scan.next();

                System.out.println("How many sessions would you like(1-10)?:    ");

                sessionNum = scan.nextInt();
                
                scan.nextLine();

                //  Input validation for number of sessions

                if (sessionNum >= 1 && sessionNum <= 10) {

                                //  RECEIPT PRINTING SECTION

                                System.out.println("\nThank you for purchasing massage session(s) through Massage Therapy during your work break!\n");

                                System.out.println("Name: " + name + "\t\tPurchase Date:  " + date);

                                System.out.println("Groupon Code: " + coupon);

                                System.out.println("Number of sessions purchased: " + sessionNum);

                                /*  COUPON CODE STATEMENT
                                 *  If either coupon code is entered, it applies the appropriate discount
                                 *  If no coupon code is entered, or it is mistyped, then no discount is applied and the standard price is used.
                                 */

                            if (coupon.equals("ShortBreak")) {

                                        total = ((SHORT_PRICE * (1 - SHORT_DISCOUNT)) * sessionNum);

                                }
                                else if (coupon.equals("LongBreak")) {

                                        total = ((LONG_PRICE * (1 - LONG_DISCOUNT)) * sessionNum);

                                }
                                else {

                                        total = (SHORT_PRICE * sessionNum);

                                }

                        System.out.println("Amount due and paid: " + dollar.format(total) + "\n");

                        }
                else {
                    System.out.println("The number of sessions you entered is invalid\n");
                }
    
        System.out.println("Would you like to process another sale?(Y or N):   ");
        
        repeatQuestion = scan.next();
        
        if (repeatQuestion.toUpperCase().equals("Y")) {
            programRepeat = true;
            System.out.println("\n");
        }
        else
            programRepeat = false;
     
    }
    }
}
