package com.pabloct.springbase.jdbc.dao;

import com.pabloct.springbase.jdbc.model.Programa;
import java.util.List;

public interface ProgramaDAO {
    List<Programa> all();
    
    Programa find(Long id);
    
    void save(Programa programa);
    void update(Programa programa);
    void delete(Programa programa);
   
}
