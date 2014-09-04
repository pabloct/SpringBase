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

        System.out.println("Contenido Actual(id,nombre,descripcion,codigo):");
        AppJdbc.doList(context);
//        System.out.println("Añadimos un registro....");
//        AppJdbc.doSave(context);
//        System.out.println("Contenido luego de añadir:");
//        AppJdbc.doList(context);
//        System.out.println("Actualizamos un registro....");
//        AppJdbc.doUpdate(context);
//        System.out.println("Contenido luego de actualizar:");
//        AppJdbc.doList(context);
//        System.out.println("Buscar registro codigo=4222:");
//        AppJdbc.doFind(context);
//        System.out.println("Borrar registro codigo=333, el ultimo actualizado:");
//        AppJdbc.doDelete(context);
//        System.out.println("Contenido luego de borrar:");
//        AppJdbc.doList(context);
    }

    public static void doDelete(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find("333");
        programaDAO.delete(programa.getId());   
    }

    public static void doUpdate(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find("566");
        programa.setCodigo("333");
        programa.setNombre("APP RUN ACTUALIZADO");

        programaDAO.update(programa);
    }

    public static void doSave(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = new Programa();
        programa.setCodigo("156");
        programa.setDescripcion("Desarrollo de Software");
        programa.setNombre("RUN");
        programaDAO.save(programa);
    }

    public static void doFind(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        //Programa programa = programaDAO.find(1l);
        Programa programa = programaDAO.find("333");
        System.out.println(programa.getCodigo() + ", " + programa.getNombre() + ", " + programa.getDescripcion());
    }

    public static void doList(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        List<Programa> programas = programaDAO.all();

        for (Programa programa : programas) {
            System.out.println(programa.getId()+ ", " + programa.getNombre() + ", " + programa.getDescripcion()+", " + programa.getCodigo() );
        }
    }
}
