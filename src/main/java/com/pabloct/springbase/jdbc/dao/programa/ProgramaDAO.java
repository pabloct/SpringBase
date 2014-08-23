package com.pabloct.springbase.jdbc.dao.programa;

import com.pabloct.springbase.jdbc.helper.GenericDAO;
import com.pabloct.springbase.jdbc.model.Programa;
import java.util.List;

public interface ProgramaDAO extends GenericDAO<Programa>{

    Programa find(String codigo);

}
