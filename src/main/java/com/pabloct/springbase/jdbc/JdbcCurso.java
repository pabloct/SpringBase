package com.pabloct.springbase.jdbc;

import com.pabloct.springbase.jdbc.dao.curso.CursoDAO;
import com.pabloct.springbase.jdbc.model.Curso;
import java.util.List;
import org.springframework.context.ApplicationContext;

public class JdbcCurso {

    public static void doDelete(ApplicationContext context) {
        CursoDAO cursoDAO = (CursoDAO) context.getBean("cursoDAO");

        Curso curso = cursoDAO.find("777777");
        cursoDAO.delete(curso.getId());
    }

    public static void doFind(ApplicationContext context) {
        CursoDAO cursoDAO = (CursoDAO) context.getBean("cursoDAO");
        //Programa programa = programaDAO.find(1l);
        Curso curso = cursoDAO.find("666666");
        System.out.println(curso.getId() + "//" + curso.getNombre() + "//" + curso.getCodigo());
    }

    public static void doUpdate(ApplicationContext context) {
        CursoDAO cursoDAO = (CursoDAO) context.getBean("cursoDAO");

        Curso curso = cursoDAO.find("777777");
        curso.setNombre("Programación XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        curso.setIdPrograma(4L);

        cursoDAO.update(curso);
    }

    public static void doSave(ApplicationContext context) {
        CursoDAO cursoDAO = (CursoDAO) context.getBean("cursoDAO");

        Curso curso = new Curso();

        curso.setNombre("Java Básico");
        curso.setCodigo("XXXXXX");
        //curso.setFechaInicio();
        curso.setIdPrograma(1L);
        cursoDAO.save(curso);
    }

    public static void doList(ApplicationContext context) {
        CursoDAO cursoDAO = (CursoDAO) context.getBean("cursoDAO");
        List<Curso> cursos = cursoDAO.all();

        for (Curso curso : cursos) {
            System.out.println(curso.getId() + "//" + curso.getNombre() + "//" + curso.getCodigo() + "//" + curso.getFechaInicio() + "//" + curso.getIdPrograma());
        }
    }
}
