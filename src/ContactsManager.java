import util.FileHelper;
import util.Input;

import java.util.ArrayList;
import java.util.List;

public class ContactsManager {
    static FileHelper fileHelper = new FileHelper("", "");
    static Input ul = new Input();
    private String name;
    private String number;


    public ContactsManager(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public static void main(String[] args) {
        List<ContactsManager> contactsManagers = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager("Laura ", "9048902345");
        ContactsManager contactsManager1 = new ContactsManager("Beth ", "34523455675");
        ContactsManager contactsManager2 = new ContactsManager("Nami ", "23477985234");
        contactsManagers.add(contactsManager);
        System.out.println(contactsManager.getName() + contactsManager.getNumber());

//        fileHelper.getFilename();
//        System.out.println(fileHelper.);
//        fileHelper.getFilename();

    }


}
