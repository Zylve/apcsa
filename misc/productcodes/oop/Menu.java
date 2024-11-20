public class Menu {
    public Menu() {
    }

    // precondition : none
    // postcondition: executes the menu algorithm
    public void runMenu() {
        CountryHelper.loadCountries();

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
            this.execute(choice);
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
                System.out.print("\nRandom UPC code: " + new Code("UPC").getCode() + "\n\n");
                break;

            case 2:
                System.out.print("\nRandom EAN code: " + new Code("EAN").getCode() + "\n\n");
                break;

            case 3:
                Code upcInput = new Code(this.enterCode(12), "UPC");

                System.out.println();
                System.out.println(upcInput.isValid() ? "The UPC code is valid." : "The UPC code is invalid.\n");
                System.out.println();
                break;

            case 4:
                Code eanInput = new Code(this.enterCode(13), "EAN");

                System.out.println();
                System.out.println(eanInput.isValid() ? "The EAN code is valid." : "The EAN code is invalid.\n");
                System.out.println();
                break;

            default:
                System.out.println("\nSomething went wrong.\n");
        }
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
                    Integer.parseInt(upc.substring(0, upc.length() / 2)); // Split string in half to validate without overflows.
                    Integer.parseInt(upc.substring(upc.length() / 2));
                } catch(NumberFormatException e) {
                    System.out.println("The UPC code is invalid.\n");
                    continue;
                }

                if(upc.length() != 12) {
                    System.out.println("The UPC code is invalid.\n");
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
}
