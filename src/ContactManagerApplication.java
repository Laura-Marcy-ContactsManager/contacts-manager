import util.FileHelper;
import util.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContactManagerApplication {
    private static List<String> contacts = FileHelper.slurp("src/contacts.txt");
    static Input ul = new Input();

    public static void main(String[] args) {

    }

    public static void addContact(String name, String number){
        contacts = new ArrayList<>();
        Contact contact = new Contact(name, number);
        contacts.add(contact.getName() + " " + contact.getNumber());
        FileHelper.spit("src/contacts.txt", contacts, true);
    }

    public static void newContact(){
        String enterName = ul.getString("Enter Name: ");
        String enterNumber = ul.getString("Enter Number: ");
        addContact(enterName, enterNumber);
    }

    public static void viewXContacts(){
        FileHelper.prettySlurp("src/contacts.txt");
    }

    public static void searchByName(){
        String name = ul.getString("Enter a Name: ");
        List<String> searchedName = new ArrayList<>();
        for (String contact : contacts){
            if (contact.contains(name)){
                searchedName.add(contact);
                String output = Arrays.toString(searchedName.toArray()).replace("[", "").replace("]", "");
                System.out.println(output);
            }
        }
    }

    public static void deleteContact(){
        String userInput = ul.getString("Enter Contact to Delete: ");
        List<String> modifiedList = new ArrayList<>();
        for (String contact : contacts){
            if(!contact.contains(userInput)){
                modifiedList.add(contact);
            }
        }
        FileHelper.spit("src/friends.txt", modifiedList);
    }









}
