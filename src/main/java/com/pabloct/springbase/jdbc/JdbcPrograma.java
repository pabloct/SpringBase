package com.pabloct.springbase.jdbc;

import com.pabloct.springbase.jdbc.dao.programa.ProgramaDAO;
//import com.pabloct.springbase.jdbc.dao.programa.ProgramaRowMapper;
import com.pabloct.springbase.jdbc.model.Programa;
import java.util.List;
//import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;

public class JdbcPrograma {

    public static void doDelete(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find("156");
        programaDAO.delete(programa.getId());
    }

    public static void doUpdate(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find("156");
        programa.setNombre("Desarrollador de Aplicaciones Web con Java");
        programa.setDescripcion("En el presente programa integral ofrece al participante los conocimientos necesarios para diseñar programar y mantener aplicaciones Web dinámicas con acceso a base de datos escritas en el lenguaje PHP.");

        programaDAO.update(programa);
    }

    public static void doSave(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = new Programa();

        programa.setNombre("Diseño y Creación de Videojuegos");
        programa.setDescripcion("Este programa integral busca introducir al alumno en la industria emergente de desarrollo de videojuegos en nuestro país.");
        programa.setCodigo("444444");
        programaDAO.save(programa);

    }

    public static void doFind(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        //Programa programa = programaDAO.find(1l);
        Programa programa = programaDAO.find("156");
        System.out.println(programa.getId() + "//" + programa.getNombre() + "//" + programa.getDescripcion() + "//" + programa.getCodigo());
    }

    public static void doList(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        List<Programa> programas = programaDAO.all();

        for (Programa programa : programas) {
            System.out.println(programa.getId() + "//" + programa.getNombre() + "//" + programa.getDescripcion().substring(0, 60) + "//" + programa.getCodigo());
        }
    }
}
