import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1,num2;
        int option;
        while(true) {
            System.out.println(" \n Console Calculator");
            System.out.println("1/ Add");
            System.out.println("2/ sub");
            System.out.println("3/ mul");
            System.out.println("4/ div");
            System.out.println("5/ square");
            System.out.println("6/ Expo");
            System.out.println("7/ temp");
            System.out.println("8/ currency");

            System.out.print(" \n Enter the choice = ");
            option=sc.nextInt();
         if (option == 1 || option==2 || option==3 || option==3 || option==4 || option==5 || option==6 || option==7 || option==8 ){
            if (option == 1){
                System.out.print("Enter the num1 = ");
                num1=sc.nextInt();
                System.out.print("Enter the num2 = ");
                num2=sc.nextInt();
                System.out.println("\n "+ num1 + num2);
            }
            if (option == 2){
                System.out.print("Enter the num1 = ");
                num1=sc.nextInt();
                System.out.print("Enter the num2 = ");
                num2=sc.nextInt();
                System.out.println("\n"+ (num1 - num2));
            }
            if (option == 3){
                System.out.print("Enter the num1 = ");
                numb1=sc.nextInt();
                System.out.print("Enter the num2 = ");
                numb2=sc.nextInt();
                System.out.println( "\n "+ numb1 * numb2);
            }
            if (option == 4){
                System.out.print("Enter the num1 :");
                num1=sc.nextInt();
                System.out.print("Enter the num2 :");
                num2=sc.nextInt();
                if (num2 == 0 || num1 == 0){
                    System.out.print("Not divisible by zero");
                else{
                System.out.println("\n "+ num1 / num2);
                }
            }
            if (option == 5){
                System.out.print("Enter the num1 :");
                num1=sc.nextInt();
                System.out.println("\n"+num1 * num1);
            }
            if (option == 6){
                System.out.print("Enter base : ");
                double base = sc.nextDouble();
                System.out.print("Enter exponent : ");
                double exponent = sc.nextDouble();
                System.out.println("\n"+Math.pow(base,exponent));
            }
            if (option == 7){
                System.out.print("Enter celcius = ");
                double celsius = sc.nextDouble();
                double fahrenheit = (celsius * 9/5) + 32;
                System.out.println("\n"+ fahrenheit + " is fahrenheit ");
            }
            if (option == 8){
                System.out.print("Enter amount dollar = ");
                double usd = sc.nextDouble();
                double inr = usd * 82.5; 
                System.out.println("India rupees " + inr);

            }
        }
            else {
                System.out.println(" \n invalid option :( ");
            }
        
    }

    }
}
