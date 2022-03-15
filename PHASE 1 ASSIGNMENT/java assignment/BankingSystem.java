/**

 * The class helps listens to the user request

 * @version 8.9

 * @author DHANUSH N

 */

import java.util.Scanner;


public class BankingSystem {
    Scanner in = new Scanner(System.in);

    /**
     * This function used to display the list of banks and to return the selected bank
     * @return returns user selected bank
     */
    public int getBank(){
        System.out.println("CHOOSE THE BANK:");
        System.out.println("1) CANARA BANk\n2) UNION BANK\n3) STATE BANK OF INDIA\n4) HDFC BANK");
        System.out.println("ENTER 1/2/3/4");
        return in.nextInt();
    }

    /**
     * This function is used to display the list of loan types and to return the selected loan type
     * @return returns user selected loan type
     */
    public int getLoanType(){
        System.out.println("CHOOSE LOAN:");
        System.out.println("1) PERSONAL LOAN\n2) HOME LOAN\n3) EDUCATIONAL LOAN\n4) GOLD LOAN:");
        System.out.println("ENTER 1/2/3/4");
        return in.nextInt();
    }

    /**
     * This function generates report for the loan amount
     * @param principal Principal amount
     * @param interestAmount Interest amount
     * @param years Loan Tenure
     */
    public void report(int principal, double interestAmount, int years){
        System.out.println("LOAN DETAILS");
        System.out.println("The Principal Amount is : " + principal);
        System.out.println("The Interest To Be Paid is : " + interestAmount);
        System.out.println("The Total Amount To Be Paid is : " + (principal + interestAmount) );
        System.out.println("Loan Tenure is : " + years);
        System.out.println("EMI per month is : " +
                Math.round(((principal + interestAmount) / (years * 12)) * 100) / 100.00);
    }

    // Driver Code
    public static void main(String[] args) {
        int bank;
        int loan;
        int period;
        int amount;
        double result = 0;

        Scanner in = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();

        // Creating objects
        Bank canaraBank = new Bank(10.20,7.00,8.40, 7.25);
        Bank unionBank = new Bank(12.90,9.50,9.0,10.0);
        Bank sbiBank = new Bank(9.60,6.95,8.15,7.30);
        Bank hdfcBank = new Bank(11.00,6.70,9.75,8.50);

        bank = bankingSystem.getBank(); // calling getBank()
        loan = bankingSystem.getLoanType(); // calling getLoanType()

        // getting Loan Amount
        System.out.println("Enter amount or gold(in grams):");
        amount = in.nextInt();

        // getting Loan Tenure
        System.out.println("Enter the number of Years :");
        period = in.nextInt();

        switch (bank){
            case 1:
                result = canaraBank.interestAmount(canaraBank,loan,amount,period);
                break;
            case 2:
                result = unionBank.interestAmount(unionBank,loan,amount,period);
                break;
            case 3:
                result = sbiBank.interestAmount(sbiBank,loan,amount,period);
                break;
            case 4:
                result = hdfcBank.interestAmount(hdfcBank,loan,amount,period);
                break;
        }

        bankingSystem.report(amount,result,period); // calling report()
    }
}