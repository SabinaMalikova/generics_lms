package serviceImpl;

import dao.PersonDao;
import dao.daoImpl.PersonDaoImpl;
import model.Person;
import service.GenericService;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {

    PersonDao <Person> personDao = new PersonDaoImpl();


    @Override
    public String add(List<Person> t) {
        personDao.add(t);
        return "успешно добавлено";
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(String ascOrDesc) {
        return personDao.sortByName(ascOrDesc);
    }

    @Override
    public List<Person> filterByGender(String ascOrDesc) {

        return personDao.filterByGender(ascOrDesc);
    }

    @Override
    public List<Person> clear() {
        return personDao.clear();

    }
}
