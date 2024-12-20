public class Menu {
    public Menu() {
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

            return choice;
        }
    }

    // precondition : given a proper menu item integer
    // postcondition: displays an “under construction” or “goodbye” message
    private void execute(int ch) {
        switch(ch) {
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
                break;

            case 1:
                System.out.print("Random UPC code: " + this.generateUPC() + "\n\n");
                break;

            case 2:
                System.out.print("Random EAN code: " + this.generateEAN() + "\n\n");
                break;

            case 3:
                String upc = enterCode(12);

                System.out.println(this.checkUPC(upc) ? "The UPC code is valid." : "The UPC code is invalid.\n");
                break;

            case 4:
                String ean = enterCode(13);

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
    private int sumEveryOther(String productCode, int startLocation) {
        int sum = 0;

        for(int i = startLocation; i < productCode.length(); i += 2) {
            sum += Integer.parseInt(productCode.substring(i, i + 1));
        }

        return sum;
    }

    // precondition: length is an integer: 12 or 13
    // postcondition: user is prompted to enter a valid UPC or EAN code
    // length is 12: UPC, length is 13: EAN
    private String enterCode(int length) {
        if(length == 12) {
            while(true) {
                System.out.print("Enter a 12-digit UPC code: ");
                String upc = System.console().readLine();

                try {
                    // Integer.parseInt("796483659834"); // Overflow error
                    Integer.parseInt(upc.substring(0, upc.length() / 2)); // Split string in half to validate.
                    Integer.parseInt(upc.substring(upc.length() / 2));
                } catch(NumberFormatException e) {
                    System.out.println("The UPC code is invalid Exception.\n");
                    continue;
                }

                if(upc.length() != 12) {
                    System.out.println("The UPC code is invalid length.\n");
                    continue;
                }

                return upc;
            }
        } else if(length == 13) {
            while(true) {
                System.out.print("Enter a 13-digit EAN code: ");
                String ean = System.console().readLine();

                try {
                    Integer.parseInt(ean.substring(0, ean.length() / 2));
                    Integer.parseInt(ean.substring(ean.length() / 2));
                } catch(NumberFormatException e) {
                    System.out.println("The EAN code is invalid.\n");
                    continue;
                }

                if(ean.length() != 13) {
                    System.out.println("The EAN code is invalid.\n");
                    continue;
                }

                return ean;
            }
        }

        return System.console().readLine();
    }

    // precondition: length is a positive integer
    // postcondition: returns length random digits as a String
    private String randomDigits(int length) {
        String digits = "";

        for(int i = 0; i < length; i++) {
            digits += (int)(Math.random() * 10);
        }

        return digits;
    }

    // precondition: takes a 12-digit UPC number
    // postCondition: returns true if the check digit is correct,
    // false otherwise
    private boolean checkUPC(String ecode) {
        int oddSum = sumEveryOther(ecode, 0);
        int evenSum = sumEveryOther(ecode, 1);
        int fullSum = (oddSum * 3) + evenSum;

        return fullSum % 10 == 0;
    }

    // precondition: takes a 13-digit EAN number
    // postCondition: returns true if the check digit is correct,
    // false otherwise
    private boolean checkEAN(String ecode) {
        int oddSum = sumEveryOther(ecode, 0);
        int evenSum = sumEveryOther(ecode, 1);
        int fullSum = oddSum + (evenSum * 3);

        return fullSum % 10 == 0;
    }

    // precondition : none
    // postcondition: prompts the user for the name of a country and
    // is error checked against the file of countries.
    private String enterCountry() {
        System.out.print("Enter the name of a country: ");
        String country = System.console().readLine();
        String code = this.findCountryCode(country);

        return code;
    }

    // precondition : takes a valid country which exists in the file
    // postcondition: returns a country code as a 3 digit String
    private String findCountryCode(String country) {
        // TBA - We do not have the country list yet. Return 000 for now.
        return "000";
    }

    // precondition : ecode is a UPC or EAN code missing its check digit
    // postcondition: returns the correct check digit for the code in String
    private String getCheckDigit(String ecode) {
        if(ecode.length() == 11) {
            int oddSum = sumEveryOther(ecode, 0);
            int evenSum = sumEveryOther(ecode, 1);

            int fullSum = (oddSum * 3) + evenSum;
            int checkDigit = 10 - fullSum % 10;

            return "" + checkDigit;
        } else if(ecode.length() == 12) {
            int oddSum = sumEveryOther(ecode, 0);
            int evenSum = sumEveryOther(ecode, 1);

            int fullSum = oddSum + (evenSum * 3);
            int checkDigit = 10 - fullSum % 10;

            return "" + checkDigit;
        }

        return "0";
    }

    // precondition: none
    // postcondition: user is prompted for the number system of a UPC
    // returns a proper String of “0”, “2”, “3” or “5”
    private String enterUPCtype() {
        while(true) {
            System.out.print(
                "0: Regular UPC\n"
                    + "2: Weighed items\n"
                    + "3: Pharmacy\n"
                    + "5: Coupons\n"
                    + "Enter the number system of the UPC: "
            );

            String type = System.console().readLine();
            if(type.equals("0") || type.equals("2") || type.equals("3") || type.equals("5")) {
                return type;
            } else {
                System.out.println("Invalid input. Please enter a number from the list.");
            }
        }
    }


    private String generateUPC() {
        String digits = this.randomDigits(10);
        String type = this.enterUPCtype();
        String checkDigit = this.getCheckDigit(type + digits);

        return type + digits + checkDigit;
    }

    private String generateEAN() {
        String digits = this.randomDigits(9);
        String country = this.enterCountry();
        String checkDigit = this.getCheckDigit(country + digits);

        return country + digits + checkDigit;
    }
}
