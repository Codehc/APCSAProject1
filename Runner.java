import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        // Initialize characters hashmap
        HashMap<String, String> characters = new HashMap<String, String>();
        characters.put("Elmo", "Enthusiastic, friendly and cheerful");
        characters.put("Oscar the Grouch", "Thick-skinned and stubborn");
        characters.put("Big Bird", "Childlike");
        characters.put("Cookie Monster", "Friendly and inquisitive");
        
        // Create sesameStreet object
        SesameStreet sesameStreet = new SesameStreet(characters);

        System.out.println("Welcome to Sesame Street!\n");
        
        Scanner scanner = new Scanner(System.in);

        sesameStreet.askViewerForAntagonist(scanner);

        // Main game loop, depending on user input it calls the correct methods
        while (true) {
            System.out.println("What do you want to do (new main character, new antagonist, get main character, get antagonist, end)?");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("new main character")) {
                sesameStreet.generateRandomMainCharacter();
                System.out.println("New main character generated!");
            } else if (input.equalsIgnoreCase("new antagonist")) {
                sesameStreet.askViewerForAntagonist(scanner);
            } else if (input.equalsIgnoreCase("get main character")) {
                String mainCharacter = sesameStreet.getMainCharacter();
                System.out.println(mainCharacter + ": " + sesameStreet.getPersonalityTraits(mainCharacter));
            } else if (input.equalsIgnoreCase("get antagonist")) {
                String antagonist = sesameStreet.getAntagonist();
                System.out.println(antagonist + ": " + sesameStreet.getPersonalityTraits(antagonist));
            } else if (input.equalsIgnoreCase("end")) {
                System.out.println("Sorry to see you go :(");
                break;
            }
        }

        scanner.close();
    }
}
