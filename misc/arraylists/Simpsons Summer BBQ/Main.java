public class Main {
    public static void main(String[] args) {

        // create the Guests object and fill it with Homer's list
        Guests guests = new Guests();
        // show Homer's list
        System.out.println("Homer's List");
        System.out.println("\n");
        System.out.println(guests);


        // show the family members at the BBQ
        System.out.println("Family");
        System.out.println("\n");

        System.out.println(guests.getPeopleWithStatus("family"));

        // show banned people
        System.out.println("BANNED PEOPLE");
        System.out.println("\n");

        System.out.println(guests.getPeopleWithStatus("BANNED"));

        // remove the banned people from the guest list

        guests.removePeopleWithStatus("BANNED");

        // remove the people who paid nothing from the guest list

        guests.removePeopleWithStatus("0");

        // check the guestlist for Jessica Lovejoy,
        // Sideshow Bob and Carl Carlson
        // not a guest if they are banned or not on the list at all

        System.out.println("Jessica Lovejoy is " + (guests.isGuest("Jessica Lovejoy") ? "" : "not ") + "a guest.");
        System.out.println("Sideshow Bob is " + (guests.isGuest("Sideshow Bob") ? "" : "not ") + "a guest.");
        System.out.println("Carl Carlson is " + (guests.isGuest("Carl Carlson") ? "" : "not ") + "a guest.");
        System.out.println("\n");

        // add Jessica Lovejoy to the list - she paid $30

        guests.addGuest("Jessica", "Lovejoy", "30");

        // show the final guestlist
        System.out.println("FINAL GUEST LIST");
        System.out.println("\n");
        System.out.println(guests);

        // count the number of remaining guests

        System.out.println("Number of guests: " + guests.countGuests());

        // find the revenue for the SimpsonsBBQ

        System.out.println("Revenue: $" + guests.revenue());

        // end the BBQ

        guests.goodbyeGuests();
    }
}