package contactManager;

import util.FileHelper;
import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContactManagerApplication {
    private static List<String> contacts;
    static Input ul = new Input();
//    private static List<String> slurp = FileHelper.slurp("contacts.txt");

    public static void main(String[] args) throws IOException {
//        newFile();
        String filename = "contacts.txt";
        String directory = "src";
        Path dataFile = Paths.get(directory, filename);
        System.out.println("| Welcome to Contacts Manager |\n");
        if (Files.notExists(dataFile)) {
           do{
               Files.createFile(dataFile);
           }
            while (Files.notExists(dataFile));
                System.out.println("Please add a contact");
                newContact();
                contactManager();


        } else {
            contactManager();
            FileHelper.slurp("src/contacts.txt");
        }
    }

    public static void contactManager() {
        int userInput;
        do {
            System.out.println();
            System.out.println(
                    " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "| 1 View Contacts             |\n" +
                    "| 2 Add a new Contact         |\n" +
                    "| 3 Search a Contact by Name  |\n" +
                    "| 4 Delete an Existing Contact|\n" +
                    "| 5 Exit                      |\n" +
                    " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            userInput = ul.getInt("Pick an Option");
            switch (userInput) {
                case 1:
                    viewContacts();
                    break;
                case 2:
                    newContact();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.exit(5);
                    break;
                default:
                    System.out.println("Not an Option, TRY AGAIN");

            }
        } while (userInput != 5);
            System.out.println("Goodbye");
    }

    public static void newFile(){
        List<String> test = new ArrayList<>();
        test.add("Name" + "--" + "Phone Number");
        FileHelper.spit("contacts.txt", test, true);
    }

    public static void addContact(String name, String number){
        contacts = new ArrayList<>();
        Contact contact = new Contact(name, number);
        contacts.add(contact.getName() + " | " + contact.getNumber());
        FileHelper.spit("src/contacts.txt", contacts, true);

    }

    public static void newContact(){
        String enterName = ul.getString("Enter Name: ");
        String enterNumber = ul.getString("Enter Number: ");
//        FileHelper.slurp("src/contacts.txt");
        addContact(enterName, enterNumber);
    }

    public static void viewContacts(){
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
        contacts = FileHelper.slurp("src/contacts.txt");
        for (String contact : contacts){
            if(!contact.contains(userInput)){
                modifiedList.add(contact);
            }
        }
        FileHelper.spit("src/contacts.txt", modifiedList);
    }









}
