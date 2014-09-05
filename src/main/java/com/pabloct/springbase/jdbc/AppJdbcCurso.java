package com.pabloct.springbase.jdbc;

import com.pabloct.springbase.jdbc.dao.curso.CursoDAO;
import com.pabloct.springbase.jdbc.model.Curso;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppJdbcCurso {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_db.xml");

        System.out.println("------------------------------------------------------------------------\nContenido Actual(id,nombre,descripcion,codigo):");
        AppJdbcCurso.doList(context);
        System.out.println("Añadimos un registro....");
        AppJdbcCurso.doSave(context);

        System.out.println("Contenido luego de añadir:");
        AppJdbcCurso.doList(context);
//System.out.println("Actualizamos un registro....");
        //AppJdbcCurso.doUpdate(context);
        //System.out.println("Contenido luego de actualizar:");
        //AppJdbcCurso.doList(context);
        //System.out.println("Buscar registro codigo=333333:");
        //AppJdbcCurso.doFind(context);
        //System.out.println("Borrar registro codigo=333333.....");
        //AppJdbcCurso.doDelete(context);
        //System.out.println("Contenido luego de borrar:");
        //AppJdbcCurso.doList(context);
    }

    public static void doSave(ApplicationContext context) {
        CursoDAO cursoDAO = (CursoDAO) context.getBean("cursoDAO");

        Curso curso = new Curso();
        //curso.setId(4L);
        curso.setNombre("PHP con Base de Datos MySQL");
        curso.setCodigo("444444");
        //curso.setFechaInicio();
        curso.setIdPrograma(2L);
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
