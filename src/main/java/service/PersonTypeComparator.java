package service;

import enums.PersonType;
import model.Person;

import java.util.Comparator;

public class PersonTypeComparator implements Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2) {
//        if((p1.personType == PersonType.TCH) && (p2.personType == PersonType.SNR)) {
//            return -1;
//        }else if((p1.personType == PersonType.SNR) && (p2.personType == PersonType.TCH)) {
//            return 1;
//        }
//        else if((p1.personType == PersonType.TCH) && (p2.personType == PersonType.JNR)) {
//            return -1;
//        }else if((p1.personType == PersonType.JNR) && (p2.personType == PersonType.TCH)) {
//            return 1;
//        }
//        else if((p1.personType == PersonType.SNR) && (p2.personType == PersonType.JNR)) {
//            return -1;
//        }else if((p1.personType == PersonType.JNR) && (p2.personType == PersonType.SNR)) {
//            return 1;
//        }else {
//            return 0;
//        }
        return Integer.compare(p1.personType.ordinal(), p2.personType.ordinal());
    }
}
