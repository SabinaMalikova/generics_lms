import dao.AnimalDao;
import dao.daoImpl.AnimalDaoImpl;
import enums.Gender;
import model.Animal;
import model.DataBase;
import model.GeneratedID;
import model.Person;
import service.GenericService;
import serviceImpl.AnimalServiceImpl;
import serviceImpl.PersonServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

/**     1) Жаны проект тузунуз.
 2) 3 жаны пакет тузунуз - model, dao, service
 3) model пакеттин ичине Person, Animal деген класс тузунуз, свойствалары - id, name, age, Gender .
 - Genderди enum кылып башка пакетке тузуп койсонуз болот.
 5) service пакеттин ичине GenericService деген generic interface тузунуз жана impl деген пакет тузуп коюнуз.
 6) GenericServiceтин ичинде 7 метод болот:
 String add(List<T>t);
 T getById(Long id);
 List<T> getAll();
 List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
 List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
 List<T> clear();
 7) impl пакеттин ичине PersonServiceImpl, AnimalServiceImpl деген класстарды тузунуз, бул класстар GenericService интерфейсин ишке ашырат .
 9) Main класста бардык методдорду чакырып иштетиниз. **/
GenericService<Person> personService = new PersonServiceImpl();
GenericService<Animal> animalService = new AnimalServiceImpl();



        List<Person> people =Arrays.asList(
                new Person(GeneratedID.genPersonId(), "Beknazar", Gender.M),
                new Person(GeneratedID.genPersonId(), "Artem", Gender.M),
                new Person(GeneratedID.genPersonId(), "Grisha", Gender.M),
                new Person(GeneratedID.genPersonId(), "Mirlan", Gender.M),
                new Person(GeneratedID.genPersonId(), "Azema", Gender.F),
                new Person(GeneratedID.genPersonId(), "Kunduz", Gender.F),
                new Person(GeneratedID.genPersonId(), "Sezim", Gender.F));

        List<Animal> animals =Arrays.asList(
                new Animal(GeneratedID.genPersonId(), "Dog", Gender.M),
                new Animal(GeneratedID.genPersonId(), "Cat", Gender.F),
                new Animal(GeneratedID.genPersonId(), "Horse", Gender.F),
                new Animal(GeneratedID.genPersonId(), "Sheep", Gender.M),
                new Animal(GeneratedID.genPersonId(), "Rabbit", Gender.F),
                new Animal(GeneratedID.genPersonId(), "Tiger", Gender.F),
                new Animal(GeneratedID.genPersonId(), "Lion", Gender.F));



        boolean exit = false;
        while (!exit) {
            System.out.println("""
                                        выберите одну команду: 
                    1.  добавить людей                          2.  добавить животных
                    3.  посмотреть человека по Id               4.  посмотреть животное по ID
                    5.  посмотреть всех людей                   6.  посмотреть всех животных
                    7.  сортировка по имени человека            8.  сортировка по названию животного
                    9.  сортировка по гендеру                   10. сортировка по гендеру
                    11. удалить всех людей                      11. удалить всех животных       
                    """);
            switch (new Scanner(System.in).nextLine()) {
                case "1": {
                    System.out.println(personService.add(people));
                    break;
                }
                case "2": {
                    System.out.println(animalService.add(animals));
                    break;
                }
                case "3": {
                    System.out.println("Введите ID: ");
                    System.out.println(personService.getById(new Scanner(System.in).nextLong()));
                    break;
                }
                case "4": {
                    System.out.println("Введите ID: ");
                    System.out.println(animalService.getById(new Scanner(System.in).nextLong()));
                    break;
                }
                case "5": {
                    System.out.println(personService.getAll());
                    break;
                }
                case "6": {
                    System.out.println(animalService.getAll());
                    break;
                }
                case "7": {
                    System.out.println("Выберите:\n" +
                            "1) в алфавитном порядке\n" +
                            "2) в алфавитном порядке наборот ");
                    System.out.println(personService.sortByName(new Scanner(System.in).nextLine()));
                    break;
                }
                case "8": {
                    System.out.println("Выберите:\n" +
                            "1) в алфавитном порядке\n" +
                            "2) в алфавитном порядке наборот ");
                    System.out.println(animalService.sortByName(new Scanner(System.in).nextLine()));
                    break;
                }
                case "9": {
                    System.out.println("Выберите:\n" +
                            "1) Male\n" +
                            "2) Female ");
                    System.out.println(personService.filterByGender(new Scanner(System.in).nextLine()));
                    break;
                }
                case "10": {
                    System.out.println("Выберите:\n" +
                            "1) Male\n" +
                            "2) Female ");
                    System.out.println(animalService.filterByGender(new Scanner(System.in).nextLine()));
                    break;
                }
                case "11": {
                    System.out.println(personService.clear());
                    break;
                }
                case "12": {
                    System.out.println(animalService.clear());
                    break;
                }
                default:{
                    System.out.println("нет такой опции");
                    break;
                }
            }
        }
    }
}
