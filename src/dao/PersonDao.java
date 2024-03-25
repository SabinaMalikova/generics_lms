package dao;

import java.util.List;

public interface PersonDao<T>{
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(String ascOrDesc);              //1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
    List<T> filterByGender(String ascOrDesc);          //1 ди басканда female, 2 ни басканда male кылып фильтрлесин
    List<T> clear();
}
