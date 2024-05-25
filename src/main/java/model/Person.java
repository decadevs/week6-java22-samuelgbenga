package model;

import enums.PersonType;

import java.util.Locale;

public class Person {
    private final String fullName;
    private final String personId;
    public final PersonType personType;
    public Book book = null;


  // return the first 3 string which can be thc, snr and jnr
    private String splitPersonId(){
        return personId.substring(0,3);
    }

    //check if the returned string is a legal personType
    private boolean checkPersonType(String pType){

        try{
            PersonType.valueOf(pType);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public Person(String fullName, String personId){
        this.fullName = fullName;
        this.personId = personId;
        String pType = splitPersonId();
        pType = pType.toUpperCase();
        boolean isPersonType = checkPersonType(pType);
        this.personType = (isPersonType)?PersonType.valueOf(pType): null;

    }

    public String getFullName() {
        return fullName;
    }

    public String getPersonId() {
        return personId;
    }

    public void requestBook(Book book){

        this.book = book;
    }

    @Override
    public String toString() {
        return ("["+fullName+", "+ personId+"]");
    }
}
