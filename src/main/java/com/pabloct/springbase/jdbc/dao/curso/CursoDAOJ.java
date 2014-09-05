package com.pabloct.springbase.jdbc.dao.curso;

import com.pabloct.springbase.jdbc.model.Curso;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CursoDAOJ extends JdbcDaoSupport implements CursoDAO {

    public List<Curso> all() {
        String query = "select * from curso";
        return this.getJdbcTemplate().query(query, new CursoRowMapper());
    }

    public Curso find(Long id) {
        String sql = "select * from curso where id = ?";

        Curso curso = (Curso) this.getJdbcTemplate()
                .queryForObject(sql, new Object[]{id}, new CursoRowMapper());
        return curso;
    }

    public Curso find(String codigo) {
        String sql = "select * from curso where codigo like ?";

        Curso curso = (Curso) this.getJdbcTemplate()
                .queryForObject(sql, new Object[]{codigo}, new CursoRowMapper());
        return curso;
    }

    public void save(Curso curso) {
        String sql = "insert into curso (nombre,codigo,id_programa)values(?, ?, ?)";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                curso.getNombre(),
                curso.getCodigo(),
                //curso.getFechaInicio(),
                curso.getIdPrograma()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void update(Curso curso) {
        String sql = "update curso set nombre=?,codigo=?,fechaInicio=?,idPrograma=? where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                curso.getNombre(),
                curso.getCodigo(),
                curso.getFechaInicio(),
                curso.getIdPrograma()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        String sql = "delete from curso where id=?";
        try {
            this.getJdbcTemplate().update(sql, new Object[]{id});

        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
