/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.google.gson.Gson;
import entity.Person;
import java.util.List;

/**
 *
 * @author Hannibal
 */
public class JSONConverter {

    private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    public Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }

    public String getJSONFromPerson(Person p) {
        return gson.toJson(p);
    }

    public String getJSONFromPerson(List<Person> persons) {
        return gson.toJson(persons);
    }
}
