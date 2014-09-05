package com.pabloct.springbase.jdbc.dao.curso;

import com.pabloct.springbase.jdbc.model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CursoRowMapper implements RowMapper<Curso> {

    public Curso mapRow(ResultSet rs, int i) throws SQLException {
        Curso curso = new Curso();
        curso.setId(rs.getLong(1));
        curso.setNombre(rs.getString(2));
        curso.setCodigo(rs.getString(3));
        curso.setFechaInicio(rs.getDate(4));
        curso.setIdPrograma(rs.getLong(5)); 
        return curso;
    }
}
