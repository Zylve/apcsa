public class Menu {
    // precondition : none
    // postcondition: shows a banner on the console
    public void printHeader() {
    }

    // precondition : none
    // postcondition: shows a boxed UPC or EAN code on the console
    // the box adjusts to the size of the code
    public void printCode(String code) {
    }

    // precondition : none
    // postcondition: shows the menu on the console
    public void printMenu() {
    }

    // precondition : none
    // postcondition: executes the menu algorithm
    public void runMenu() {
        while(true) {
            System.out.print(
                "1. Generate a UPC code.\n"
                    + "2. Generate an EAN code.\n"
                    + "3. Verify a UPC code.\n"
                    + "4. Verify an EAN code.\n"
                    + "0. Exit.\n\n"
                    + "Enter your choice: "
            );

            int choice = enterInput(0, 4);
            System.out.println();
            execute(choice);
        }
    }

    // precondition : given the lowest and highest menu item
    // postcondition: user is prompted to enter a menu choice,
    // returns a choice i, lowest <= i <= highest
    private int enterInput(int lowest, int highest) {
        int choice = 0;

        while(true) {
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch(NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
                continue;
            }

            if(choice < lowest || choice > highest) {
                System.out.print("Invalid input. Please enter a number between " + lowest + " and " + highest + ": ");
                continue;
            }

            break;
        }

        return choice;
    }

    // precondition : given a proper menu item integer
    // postcondition: displays an “under construction” or “goodbye” message
    public void execute(int ch) {
        switch(ch) {
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case 1:
                System.out.println("Under construction.");
                break;
            case 2:
                System.out.println("Under construction.");
                break;
            case 3:
                System.out.print("Please enter a 12-digit UPC code: ");
                String upc = System.console().readLine();

                try {
                    Integer.parseInt(upc);
                } catch(NumberFormatException e) {
                    System.out.println("The UPC code is invalid.\n");
                    break;
                }

                if(upc.length() != 12) {
                    System.out.println("The UPC code is invalid.\n");
                    break;
                }

                System.out.println(this.checkUPC(upc) ? "The UPC code is valid." : "The UPC code is invalid.\n");
                break;
            case 4:
                System.out.print("Please enter a 13-digit EAN code: ");
                String ean = System.console().readLine();

                try {
                    Integer.parseInt(ean);
                } catch(NumberFormatException e) {
                    System.out.println("The EAN code is invalid.\n");
                    break;
                }

                if(ean.length() != 13) {
                    System.out.println("The EAN code is invalid.\n");
                    break;
                }

                System.out.println(this.checkEAN(ean) ? "The EAN code is valid." : "The EAN code is invalid.\n");
                break;
            default:
                System.out.println("Something went wrong.");
        }
    }

    // precondition: productCode is a String of digits 0 through 9
    // startLocation is an index value: 0 or 1
    // postcondition: returns the sum of all odd digits if startLocation is 0, and all even digits if startLocation is 1.
    // Indexing where digit 0 is odd.
    public int sumEveryOther(String productCode, int startLocation) {
        int sum = 0;

        for(int i = startLocation; i < productCode.length(); i += 2) {
            sum += Integer.parseInt(productCode.substring(i, i + 1));
        }

        return sum;
    }

    // precondition: length is an integer: 12 or 13
    // postcondition: user is prompted to enter a valid UPC or EAN code
    // length is 12: UPC, length is 13: EAN
    public String enterCode(int length) {
        if(length == 12) {
            System.out.print("Enter a 12-digit UPC code: ");
        } else if(length == 13) {
            System.out.print("Enter a 13-digit EAN code: ");
        }

        return System.console().readLine();
    }

    // precondition: length is a positive integer
    // postcondition: returns length random digits as a String
    public String randomDigits(int length) {
        String digits = "";

        for(int i = 0; i < length; i++) {
            digits += (int)(Math.random() * 10);
        }

        return digits;
    }

    // precondition: takes a 12-digit UPC number
    // postCondition: returns true if the check digit is correct,
    // false otherwise
    public boolean checkUPC(String ecode) {
        int oddSum = sumEveryOther(ecode, 0);
        int evenSum = sumEveryOther(ecode, 1);
        int fullSum = oddSum * 3 + evenSum;

        return fullSum % 10 == 0;
    }

    // precondition: takes a 13-digit EAN number
    // postCondition: returns true if the check digit is correct,
    // false otherwise
    public boolean checkEAN(String ecode) {
        int oddSum = sumEveryOther(ecode, 0);
        int evenSum = sumEveryOther(ecode, 1);
        int fullSum = oddSum + evenSum * 3;

        return fullSum % 10 == 0;
    }
}
