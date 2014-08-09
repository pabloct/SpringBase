package com.pabloct.springbase.jdbc;

import com.pabloct.springbase.jdbc.dao.ProgramaDAO;
import com.pabloct.springbase.jdbc.dao.ProgramaRowMapper;
import com.pabloct.springbase.jdbc.model.Programa;
import java.util.List;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppJdbc {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_db.xml");

        AppJdbc.doList(context);
    }

    public static void doList(ApplicationContext context) {
        ProgramaDAO programaDAO = (ProgramaDAO) context.getBean("programaDAO");
        List<Programa> programas = programaDAO.all();

        for (Programa programa : programas) {
            System.out.println(programa.getNombre());
        }
    }
}
