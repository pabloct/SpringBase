package com.pabloct.springbase;

import com.pabloct.springbase.model.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Persona persona = (Persona) context.getBean("persona");

        System.out.println(persona.getNombres() + " " + persona.getApellidos());
    }
}
