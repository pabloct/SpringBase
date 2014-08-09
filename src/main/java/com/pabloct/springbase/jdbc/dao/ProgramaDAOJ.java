package com.pabloct.springbase.jdbc.dao;

import com.pabloct.springbase.jdbc.model.Programa;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ProgramaDAOJ extends JdbcDaoSupport implements ProgramaDAO {

    public List<Programa> all() {
        String query = "select * from programa";
        return this.getJdbcTemplate().query(query, new ProgramaRowMapper());

    }

    public Programa find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Programa programa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Programa programa) {
        String sql = "update local set nombre=?, descripcion=? where id=?";
        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                programa.getNombre(),
                programa.getDescripcion(),
                programa.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
