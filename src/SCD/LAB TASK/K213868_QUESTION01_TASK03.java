import java.util.Scanner;

public class K213868_QUESTION01_TASK03 {
    public static void main(String[] args) {
        System.out.println("Q1 TASK3 K213868\n--------------------");
        int AVAILABLE_AMOUNT= 10000;

        System.out.println("================== BANKING SYSTEM ==================");
        System.out.println("Which Account do you have right now? " +
                           "\n[1] Bank Account"+
                            "\n[2] SAVING Account"+
                            "\n[3] CURRENT ACCOUNT"+
                            "\n[4] QUIT");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        int amount;
        bankAccount b = new bankAccount();
        currentAccount c = new currentAccount();
        savingAccount s = new savingAccount();

        switch (choice){
            case "1":
                System.out.println("********************** BANKING ACCOUNT **********************");
                System.out.print("Enter amount to deposit :");
                amount = sc.nextInt();
                b.deposit(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter amount to withdraw :");
                amount = sc.nextInt();
                b.withDraw(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter amount to calculate interest :");
                amount = sc.nextInt();
                b.calculateInterest(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter to check balance :");
                b.checkBalance();


                break;

            case "2":
                System.out.println("********************** SAVING ACCOUNT **********************");
                System.out.print("Enter amount to deposit :");
                amount = sc.nextInt();
                s.deposit(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter amount to withdraw :");
                amount = sc.nextInt();
                s.withDraw(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter amount to calculate interest :");
                amount = sc.nextInt();
                s.calculateInterest(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter to check balance :");
                s.checkBalance();

                System.out.print("Enter some Debits to add them in  your account :");
                int debits = sc.nextInt();
                s.addDebits(debits);
                break;

            case "3":
                System.out.println("********************** CURRENT ACCOUNT **********************");
                System.out.print("Enter amount to deposit :");
                amount = sc.nextInt();
                c.deposit(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter amount to withdraw :");
                amount = sc.nextInt();
                c.withDraw(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter amount to calculate interest :");
                amount = sc.nextInt();
                c.calculateInterest(AVAILABLE_AMOUNT,amount);

                System.out.print("Enter to check balance :");
                c.checkBalance();


                System.out.print("Enter CREDITS to check credit score :");
                int credits = sc.nextInt();
                c.creditScore(credits);
                break;

            case "4":
                System.exit(0);
                break;

        }
    }
}

interface ACCOUNTS {
    void deposit(int AVAILABLE_AMOUNT, int amount);
    void withDraw(int AVAILABLE_AMOUNT, int amount);
    void calculateInterest(int AVAILABLE_AMOUNT, int amount);
    void checkBalance();
}

//BANK ACCOUNT
class bankAccount implements ACCOUNTS{

    double Amount =0;

    @Override
    public void deposit(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Deposited ["+ amount+"], Final balance is = ["+(AVAILABLE_AMOUNT+amount)+"]");
        Amount=AVAILABLE_AMOUNT+amount;
    }

    @Override
    public void withDraw(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Withdrawn ["+ amount+"], Final balance is = ["+(AVAILABLE_AMOUNT-amount)+"]");
        Amount=AVAILABLE_AMOUNT-amount;
    }

    @Override
    public void calculateInterest(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Calculated interest on your current bill is = ["+(AVAILABLE_AMOUNT*0.5+amount)+"]");
        Amount=(AVAILABLE_AMOUNT*0.5)+amount;
    }

    @Override
    public void checkBalance() {
        System.out.println("Your current bill is : "+ Amount);
    }



}

//SAVING ACCOUNT
class savingAccount implements ACCOUNTS{

    double Amount =0;
    @Override
    public void deposit(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Deposited ["+ amount+"], Final balance is = ["+(AVAILABLE_AMOUNT+amount)+"]");
        Amount=AVAILABLE_AMOUNT+amount;
    }

    @Override
    public void withDraw(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Withdrawn ["+ amount+"], Final balance is = ["+(AVAILABLE_AMOUNT-amount)+"]");
        Amount=AVAILABLE_AMOUNT-amount;
    }

    @Override
    public void calculateInterest(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Calculated interest on your current bill is = ["+(AVAILABLE_AMOUNT*0.5+amount)+"]");
        Amount=(AVAILABLE_AMOUNT*0.5)+amount;
    }

    @Override
    public void checkBalance() {
        System.out.println("Your current bill is : "+ Amount);
    }

    void addDebits(int amounT){
        System.out.println("Debits Added ["+ amounT+"], Final balance is = ["+(Amount+amounT)+"]");
    }
}
//CURRENT ACCOUNT

class currentAccount implements ACCOUNTS{
    double Amount =0;
    @Override
    public void deposit(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Deposited ["+ amount+"], Final balance is = ["+(AVAILABLE_AMOUNT+amount)+"]");
        Amount=AVAILABLE_AMOUNT+amount;
    }

    @Override
    public void withDraw(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Withdrawn ["+ amount+"], Final balance is = ["+(AVAILABLE_AMOUNT-amount)+"]");
        Amount=AVAILABLE_AMOUNT-amount;
    }

    @Override
    public void calculateInterest(int AVAILABLE_AMOUNT, int amount) {
        System.out.println("Calculated interest on your current bill is = ["+(AVAILABLE_AMOUNT*0.5+amount)+"]");
        Amount=(AVAILABLE_AMOUNT*0.5)+amount;
    }

    @Override
    public void checkBalance() {
        System.out.println("Your current bill is : "+ Amount);
    }

    void creditScore(int credits){
        if(credits> 50){
            System.out.println("Above Average");
        }else {
            System.out.println("You surely have to pay bills right now!!");
        }
    }
}

