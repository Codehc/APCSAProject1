import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SesameStreet {
    private HashMap<String, String> characters;
    private String mainCharacter;
    private String antagonist;

    public SesameStreet(HashMap characters) {
        this.characters = characters;

        generateRandomMainCharacter();
        setAntagonist("Oscar the Grouch");
    }

    public void generateRandomMainCharacter() {
        // Gets the index of a random character
        int numCharacters = characters.size();
        int mainCharacterIndex = (int) (Math.random() * numCharacters);


        // Converts the keys (character names) of the HashMap to an array so I can easily pick one and return it based on index
        mainCharacter = (String) characters.keySet().toArray()[mainCharacterIndex];
    }

    public void setAntagonist(String antagonist) {
        this.antagonist = antagonist;
    }

    public void askViewerForAntagonist(Scanner scanner) {
        // Converts the keys (character names) of the HashMap to an array so I can easily iterate through them
        String[] characterNames = characters.keySet().toArray(new String[characters.size()]);

        System.out.println("Here are all the Sesame Street characters:");
        for (String character : characterNames) {
            System.out.println(" * " + character);
        }
        System.out.println("Who is the antagonist?");

        String userInput = scanner.nextLine();

        setAntagonist(userInput);
        System.out.println("The new antagonist is: " + getAntagonist());
    }

    public String getMainCharacter() {
        return mainCharacter;
    }

    public String getAntagonist() {
        return antagonist;
    }

    String getPersonalityTraits(String character) {
        return characters.get(character);
    }

    public static void main(String[] args) {
        /*HashMap<String, String> characters = new HashMap<String, String>();
        characters.put("Elmo", "Enthusiastic, friendly and cheerful");
        characters.put("Oscar the Grouch", "Thick-skinned and stubborn");
        characters.put("Big Bird", "Childlike");
        characters.put("Cookie Monster", "Friendly and inquisitive");

        SesameStreet sesameStreet = new SesameStreet(characters);
        
        // Test initialization
        testSesameStreet(sesameStreet);

        // Test setting new characters
        sesameStreet.generateRandomMainCharacter();
        sesameStreet.setAntagonist("Cookie Monster");
        testSesameStreet(sesameStreet);

        // Test asking for user's least favorite character
        sesameStreet.askViewerForAntagonist();
        testSesameStreet(sesameStreet);*/
    }

    public static void testSesameStreet(SesameStreet sesameStreet) {
        // Testing method, gets the main character and antagonist and prints their data
        String mainCharacter = sesameStreet.getMainCharacter();
        String antagonist = sesameStreet.getAntagonist();
        System.out.println(mainCharacter + ": " + sesameStreet.getPersonalityTraits(mainCharacter));
        System.out.println(antagonist + ": " + sesameStreet.getPersonalityTraits(antagonist));
    }
}