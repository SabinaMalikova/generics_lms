package dao.daoImpl;

import enums.Gender;
import model.Animal;
import model.DataBase;
import dao.PersonDao;
import model.Person;
import myEcxeptions.MyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonDaoImpl implements PersonDao <Person> {

    @Override
    public String add(List<Person> t) {
        DataBase.people.addAll(t);
        return "успешно добавлено";
    }

    @Override
    public Person getById(Long id) {
        for (Person person : DataBase.people){
            try {
                if (person.getId()==id){
                    return person;
                }
                throw new MyException("person with "+ id + " not found");
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
            return DataBase.people;
    }

    @Override
    public List<Person> sortByName(String ascOrDesc) {
        try {
            switch (ascOrDesc) {
                case "1": {
                    Collections.sort(DataBase.people, Comparator.comparing(Person::getName));
                    System.out.println(DataBase.people);
                    break;
                }
                case "2": {
                    Collections.sort(DataBase.people, Comparator.comparing(Person::getName).reversed());
                    System.out.println(DataBase.people);
                    break;
                }
                default: {
                    throw new MyException("Такой опции нет!");
                }
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> filterByGender(String ascOrDesc) {
        List<Person> male = new ArrayList<>();
        List<Person> female = new ArrayList<>();
        try {
            if (ascOrDesc.equals("1")){
                for (Person person : DataBase.people){
                    if (person.getGender().equals(Gender.M)){
                        male.add(person);
                    }
                }
                return male;
            }else if (ascOrDesc.equals("2")){
                for (Person person : DataBase.people){
                    if (person.getGender().equals(Gender.F)){
                        female.add(person);
                    }
                }
                return female;
            }
            throw new MyException("нет такого значения");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        DataBase.people.clear();
        return DataBase.people;
    }
}
