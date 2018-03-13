package contactManager;

import util.FileHelper;
import util.Input;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private String number;


    public Contact(String name, String number) {
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


}
