package com.pabloct.springbase.jdbc;

import com.pabloct.springbase.jdbc.dao.programa.ProgramaDAO;
//import com.pabloct.springbase.jdbc.dao.programa.ProgramaRowMapper;
import com.pabloct.springbase.jdbc.model.Programa;
import java.util.List;
//import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppJdbc {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_db.xml");

        System.out.println("------------------------------------------------------------------------\nContenido Actual(id,nombre,descripcion,codigo):");
        AppJdbc.doList(context);
        //System.out.println("Añadimos un registro....");
        //AppJdbc.doSave(context);

        //System.out.println("Contenido luego de añadir:");
        //AppJdbc.doList(context);
//System.out.println("Actualizamos un registro....");
        //AppJdbc.doUpdate(context);
        //System.out.println("Contenido luego de actualizar:");
        //AppJdbc.doList(context);
        //System.out.println("Buscar registro codigo=333333:");
        //AppJdbc.doFind(context);
        //System.out.println("Borrar registro codigo=333333.....");
        //AppJdbc.doDelete(context);
        //System.out.println("Contenido luego de borrar:");
        //AppJdbc.doList(context);
    }

    public static void doDelete(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find("156");
        programaDAO.delete(programa.getId());
    }

    public static void doUpdate(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find("156");
        programa.setNombre("Desarrollador de Aplicaciones Web con Java");
        programa.setDescripcion("El presente programa integral tiene como finalidad el uso de la tecnología Java para el desarrollo de aplicaciones Web empresariales.");

        programaDAO.update(programa);
    }

    public static void doSave(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = new Programa();
        programa.setId(4L);
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
            System.out.println(programa.getId() + "//" + programa.getNombre() + "//" + programa.getDescripcion() + "//" + programa.getCodigo());
        }
    }
}
