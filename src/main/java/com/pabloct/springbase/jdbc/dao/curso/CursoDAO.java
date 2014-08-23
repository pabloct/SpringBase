package com.pabloct.springbase.jdbc.dao.curso;

import com.pabloct.springbase.jdbc.helper.GenericDAO;
import com.pabloct.springbase.jdbc.model.Curso;
import java.util.List;

public interface CursoDAO extends GenericDAO<Curso>{

    Curso find(String codigo);

}
