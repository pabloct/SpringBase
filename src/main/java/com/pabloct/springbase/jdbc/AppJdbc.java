package com.pabloct.springbase.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppJdbc {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_db.xml");

        System.out.println("------------------------------------------------------------------------\nContenido Actual(id,nombre,descripcion,codigo):");
        //JdbcCurso.doList(context);
        //System.out.println("Añadimos un registro....");
        //JdbcCurso.doSave(context);
        JdbcCurso.doDelete(context);

        //System.out.println("Contenido luego de añadir:");
        //JdbcPrograma.doList(context);
        //System.out.println("Actualizamos un registro....");
        //JdbcCurso.doUpdate(context);
        //System.out.println("Contenido luego de actualizar:");
        //JdbcCurso.doList(context);
        //System.out.println("Buscar registro codigo=333333:");
        //JdbcCurso.doFind(context);
        //System.out.println("Borrar registro codigo=333333.....");
        //.doDelete(context);
        //System.out.println("Contenido luego de borrar:");
        JdbcCurso.doList(context);
    }

   
}
