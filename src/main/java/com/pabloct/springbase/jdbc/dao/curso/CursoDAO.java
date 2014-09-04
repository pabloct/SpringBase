package com.pabloct.springbase.jdbc.dao.curso;

import com.pabloct.springbase.jdbc.helper.GenericDAO;
import com.pabloct.springbase.jdbc.model.Curso;

public interface CursoDAO extends GenericDAO<Curso>{

    Curso find(String codigo);

}
