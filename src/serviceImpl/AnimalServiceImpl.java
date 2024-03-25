package serviceImpl;

import dao.AnimalDao;
import dao.daoImpl.AnimalDaoImpl;
import model.Animal;
import model.DataBase;
import model.Person;
import service.GenericService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {


    AnimalDao <Animal> animalDao = new AnimalDaoImpl();


    @Override
    public String add(List<Animal> t) {
        animalDao.add(t);
        return "успешно добавлено";
    }

    @Override
    public Animal getById(Long id) {
        return animalDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName(String ascOrDesc) {
        return animalDao.sortByName(ascOrDesc);
    }

    @Override
    public List<Animal> filterByGender(String ascOrDesc) {
        return animalDao.filterByGender(ascOrDesc);
    }

    @Override
    public List<Animal> clear() {
        return animalDao.clear();
    }
}
