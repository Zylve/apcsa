public class Code {
    private String code;
    private String type;

    public Code(String type) {
        this.type = type;
        if(type.equals("UPC")) {
            this.code = this.generateUPC();
        } else if(type.equals("EAN")) {
            this.code = this.generateEAN();
        }
    }

    // Code is a either a UPC or EAN code
    // Type is either "UPC" or "EAN"
    public Code(String code, String type) {
        this.code = code;
        this.type = type;
    }

    private String generateUPC() {
        String digits = this.randomDigits(10);
        String type = this.enterUPCtype();
        String checkDigit = Code.getCheckDigit(type + digits);

        return type + digits + checkDigit;
    }

    private String generateEAN() {
        String digits = this.randomDigits(9);
        String country = CountryHelper.enterCountry();
        String checkDigit = Code.getCheckDigit(country + digits);

        return country + digits + checkDigit;
    }

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

    private String randomDigits(int length) {
        String digits = "";

        for(int i = 0; i < length; i++) {
            digits += (int)(Math.random() * 10);
        }

        return digits;
    }

    private static String getCheckDigit(String ecode) {
        int oddSum = Code.sumEveryOther(ecode, 0);
        int evenSum = Code.sumEveryOther(ecode, 1);
        int fullSum = 0;

        if(ecode.length() == 11) {
            fullSum = (oddSum * 3) + evenSum;
        } else if(ecode.length() == 12) {
            fullSum = oddSum + (evenSum * 3);
        }

        return "" + (10 - fullSum % 10);
    }

    private static int sumEveryOther(String ecode, int startLocation) {
        int sum = 0;

        for(int i = startLocation; i < ecode.length(); i += 2) {
            sum += Integer.parseInt(ecode.substring(i, i + 1));
        }

        return sum;
    }

    public boolean isValid() {
        int oddSum = Code.sumEveryOther(code, 0);
        int evenSum = Code.sumEveryOther(code, 1);
        int fullSum = 0;

        if(this.code.length() == 12) {
            fullSum = (oddSum * 3) + evenSum;
        } else if(this.code.length() == 13) {
            fullSum = oddSum + (evenSum * 3);
        }

        return fullSum % 10 == 0;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}