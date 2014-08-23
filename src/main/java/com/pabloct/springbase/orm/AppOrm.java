package com.pabloct.springbase.orm;

import com.pabloct.springbase.orm.dao.ProgramaDAO;
import com.pabloct.springbase.orm.model.Programa;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AppOrm {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate_db.xml");


        AppOrm.doList(context);
        System.out.println("==============Insertando registro====================");
        AppOrm.doInsert(context);
        AppOrm.doList(context);
    }
    
     public static void doUpdate(ApplicationContext context) {
         
     }
    
    public static void doInsert(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = new Programa();
        programa.setCodigo("777");
        programa.setNombre("OTRO GENERAL");
        programa.setDescripcion("Nuevo curso INSERTADO");

        programaDAO.save(programa);

    }
    private static void doList(ApplicationContext context) {

        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        List<Programa> programas = programaDAO.all();

        System.out.println("================== Listado total ======================");
        for (Programa programa : programas) {
            System.out.println(programa.getCodigo() + ", " + programa.getNombre() + ", " + programa.getDescripcion());
        }
    }



    
}
