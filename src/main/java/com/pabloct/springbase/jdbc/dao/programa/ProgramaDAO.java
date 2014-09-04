package com.pabloct.springbase.jdbc.dao.programa;

import com.pabloct.springbase.jdbc.helper.GenericDAO;
import com.pabloct.springbase.jdbc.model.Programa;

public interface ProgramaDAO extends GenericDAO<Programa>{

    Programa find(String codigo);

}
