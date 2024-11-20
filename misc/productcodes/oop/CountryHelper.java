import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class CountryHelper {
    public static final HashMap<String, String> countries = new HashMap<String, String>();

    public static void loadCountries() {
        String[] lines = new String[0];

        try {
            lines = Files.readAllLines(Path.of("country codes.txt")).toArray(new String[0]);
        } catch(Exception e) {
            System.out.println("Error reading file.");
            System.exit(1);
        }

        for(String line : lines) {
            String code = line.substring(line.length() - 3);
            String country = line.substring(0, line.length() - 4);
            countries.put(country, code);
        }
    }

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
        String code = countries.get(country);

        if(code == null) {
            System.out.println("Country not found.");
            return "000";
        }

        return code;
    }
}
