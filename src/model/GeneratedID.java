package model;

public class GeneratedID {
    public static Long personId = 0L;
    public static Long animalId = 0L;


    public static Long genPersonId(){

        return ++personId;
    }
    public static Long genAnimalId(){

        return ++animalId;
    }
}
