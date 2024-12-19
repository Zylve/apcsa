import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Guests {
    private ArrayList<Person> guestList = new ArrayList<Person>();

    public Guests() {
        loadList("HomersList.txt");
    }

    public void addGuest(String name, String surname, String status) {
        guestList.add(new Person(name, surname, status));
    }

    // loads guests from the guestlist file into the ArrayList
    public void loadList(String filename) {
        String[] lines = new String[0];

        try {
            lines = Files.readAllLines(Path.of(filename)).toArray(new String[0]);
        } catch(Exception e) {
            System.out.println("Error reading file.");
            System.exit(1);
        }

        for(String line : lines) {
            String[] parts = line.split(" ");
            addGuest(parts[0], parts[1], parts[2]);
        }
    }

    public String getPeopleWithStatus(String status) {
        String result = "";

        for(Person p : guestList) {
            if(p.getStatus().equals(status)) {
                result += p + "\n";
            }
        }

        return result;
    }

    public void removePeopleWithStatus(String status) {
        for(int i = 0; i < guestList.size(); i++) {
            if(guestList.get(i).getStatus().equals(status)) {
                guestList.remove(i);
                i--;
            }
        }
    }

    public int countGuests() {
        return guestList.size();
    }

    public int revenue() {
        int total = 0;

        for(Person p : guestList) {
            if(!p.getStatus().equals("family")) {
                total += Integer.parseInt(p.getStatus());
            }
        }

        return total;
    }

    public boolean isGuest(String fullname) {
        for(Person p : guestList) {
            String pname = p.getName() + " " + p.getSurname();

            if(pname.equals(fullname)) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String result = "";

        for(Person p : guestList) {
            result += p + "\n";
        }

        return result;
    }

    public void goodbyeGuests() {
        System.out.println("The BBQ is over.");
    }

} // end of Guests