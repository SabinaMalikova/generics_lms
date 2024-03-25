package dao.daoImpl;

import dao.AnimalDao;
import enums.Gender;
import model.DataBase;
import model.Animal;
import model.Person;
import myEcxeptions.MyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalDaoImpl implements AnimalDao <Animal> {

    @Override
    public String add(List<Animal> t) {
        DataBase.animals.addAll(t);
        return  "успешно добавлено";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal : DataBase.animals){
            try {
                if (animal.getId()==id){
                    return animal;
                }else {
                    throw new MyException("animal with id: "+ id + "not found");
                }
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return DataBase.animals;
    }

    @Override
    public List<Animal> sortByName(String ascOrDesc) {
        try {
            switch (ascOrDesc) {
                case "1": {
                    Collections.sort(DataBase.animals, Comparator.comparing(Animal::getName));
                    System.out.println(DataBase.animals);
                    break;
                }
                case "2": {
                    Collections.sort(DataBase.animals, Comparator.comparing(Animal::getName).reversed());
                    System.out.println(DataBase.animals);
                    break;
                }
                default: {
                    throw new MyException("такой опции нет");                }
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Animal> filterByGender(String ascOrDesc) {
        List<Animal> male = new ArrayList<>();
        List<Animal> female = new ArrayList<>();
        try {
            if (ascOrDesc.equals("1")){
                for (Animal animal : DataBase.animals){
                    if (animal.getGender().equals(Gender.M)){
                        male.add(animal);
                    }
                }
                return male;
            }else if (ascOrDesc.equals("2")){
                for (Animal animal : DataBase.animals){
                    if (animal.getGender().equals(Gender.F)){
                        female.add(animal);
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
    public List<Animal> clear() {
        DataBase.animals.clear();
        return DataBase.animals;
    }
}
