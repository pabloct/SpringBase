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
        //AppOrm.doInsert(context);
        AppOrm.doDelete(context);
        AppOrm.doList(context);
        //AppOrm.doFind(context);
    }

    public static void doUpdate(ApplicationContext context) {

    }

    public static void doInsert(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = new Programa();
        programa.setCodigo("666666");
        programa.setNombre("Administración de Linux Avanzado");
        programa.setDescripcion("Las servicios y soluciones Linux -son utilizados con bastante despliegue en las empresas- pero además están abarcando otros ámbitos como son la Seguridad el monitoreo gestión de TI y la alta disponibilidad.");

        programaDAO.save(programa);

    }

    private static void doList(ApplicationContext context) {

        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        List<Programa> programas = programaDAO.all();

        System.out.println("================== Listado total ======================");
        for (Programa programa : programas) {
            System.out.println(programa.getId() + "//" + programa.getNombre() + "//" + programa.getDescripcion() + "//" + programa.getCodigo());
        }
    }

    public static void doFind(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        Programa programa = programaDAO.find(8l);
        //Programa programa = programaDAO.find("156");
        System.out.println(programa.getId() + "//" + programa.getNombre() + "//" + programa.getDescripcion() + "//" + programa.getCodigo());
    }
    
    public static void doDelete(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");

        Programa programa = programaDAO.find(8l);
        programaDAO.delete(programa);
    }
}
