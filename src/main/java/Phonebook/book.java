package Phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 * And then made EVEN better by DGuzman 10/17/2021
 */

public class book {

    private Map<String, List<String>> phonebook;

    public book(Map<String, List<String>> map) {
        this.phonebook = new HashMap<>();

    }
    public book() {
        this(null);
    }
    public void add(String name, String phoneNumber) {
        phonebook.put(name, Arrays.asList(phoneNumber));

    }
    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));

    }
    public void remove(String name) {
        phonebook.remove(name);
    }
    public Boolean hasEntry(String name) {

        if (phonebook.containsKey(name)){
            return true;
        } else {
            return false;
        }
    }
    public List<String> lookup(String name) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            if (name.equals(entry.getKey())){
                return entry.getValue();
            }
        }

        return null;
    }
    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            if(entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }
    public List<String> getAllContactNames() {
        List<String> allNames = new ArrayList<>();
        for (String name : phonebook.keySet()){
            allNames.add(name);
        }
        return allNames;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "phonebook=" + phonebook +
                '}';
    }

    public static void main(String[] args) {

        book phonebook = new book();

        phonebook.add("LeVania", "420");
        phonebook.add("Zero", "258");
        phonebook.add("Protagonist", "342");
        phonebook.addAll("Sawado", "123", "456", "789");
        System.out.println(phonebook.hasEntry("Zero"));
        phonebook.remove("Protagonist");
        System.out.println(phonebook.lookup("Zero"));
        System.out.println(phonebook.reverseLookup("420"));
        System.out.println(phonebook.getAllContactNames());
        System.out.println(phonebook.getMap());


    }

}