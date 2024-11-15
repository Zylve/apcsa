public class CountryHelper {
    // precondition : none
    // postcondition: prompts the user for the name of a country and
    // is error checked against the file of countries.
    public static String enterCountry() {
        System.out.print("Enter the name of a country: ");
        String country = System.console().readLine();
        String code = CountryHelper.findCountryCode(country);

        return code;
    }

    // precondition : takes a valid country which exists in the file
    // postcondition: returns a country code as a 3 digit String
    private static String findCountryCode(String country) {
        // TBA - We do not have the country list yet. Return 000 for now.
        return "000";
    }
}
