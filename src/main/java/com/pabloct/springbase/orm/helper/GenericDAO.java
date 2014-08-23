package com.pabloct.springbase.orm.helper;

import com.pabloct.springbase.orm.model.Programa;
import java.util.List;

public interface GenericDAO<T> {

    List<T> all();

    T find(Long id);

    void save(T t);

    void update(T t);

    //void delete(Long id);
    
    void delete(Programa id);
}
