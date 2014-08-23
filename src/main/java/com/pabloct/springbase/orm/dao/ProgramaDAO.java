package com.pabloct.springbase.orm.dao;

import com.pabloct.springbase.orm.helper.GenericDAO;
import com.pabloct.springbase.orm.model.Programa;

public interface ProgramaDAO extends GenericDAO<Programa> {

    public Programa find(String string);
    
}
