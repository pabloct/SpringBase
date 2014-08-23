package com.pabloct.springbase.jdbc.dao.programa;

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
        String sql = "select * from programa where id = ?";

        Programa programa = (Programa) this.getJdbcTemplate()
                .queryForObject(sql, new Object[]{id}, new ProgramaRowMapper());
        return programa;
    }

    public Programa find(String codigo) {
        String sql = "select * from programa where codigo like ?";

        Programa programa = (Programa) this.getJdbcTemplate()
                .queryForObject(sql, new Object[]{codigo}, new ProgramaRowMapper());
        return programa;
    }

    public void save(Programa programa) {
        String sql = "insert into programa (nombre,descripcion, codigo)values(?, ?, ?)";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                programa.getNombre(),
                programa.getDescripcion(),
                programa.getCodigo()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void update(Programa programa) {
        String sql = "update programa set nombre=?,descripcion=?,codigo=? where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                programa.getNombre(),
                programa.getDescripcion(),
                programa.getCodigo(),
                programa.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        String sql = "delete from programa where id=?";
        try {
            this.getJdbcTemplate().update(sql, new Object[]{id});

        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
