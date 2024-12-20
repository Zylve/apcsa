import java.util.ArrayList;

public class RemoveDuplicates {
    private static ArrayList<String> names = new ArrayList<String>();

    public static void main(String[] args) {
        names.add("John");
        names.add("Jane");
        names.add("Gary");
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Jane");
        names.add("Gary");
        names.add("Alice");
        names.add("Eve");
        names.add("John");

        System.out.println("Original Size: " + names.size() + " items\nlist: " + names + "\n");

        for(int i = 0; i < names.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(names.get(i).equals(names.get(j))) {
                    names.remove(i);
                    i--;
                    break;
                }
            }
        }

        System.out.println("New Size: " + names.size() + " items\nlist: " + names + "\n");
    }
}
