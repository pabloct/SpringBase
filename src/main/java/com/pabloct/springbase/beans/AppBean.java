package com.pabloct.springbase.beans;

import com.pabloct.springbase.model.Instrumento;
import com.pabloct.springbase.model.Musico;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        AppBean.valoresConstructor(context);
        AppBean.referenciaConstructor(context);
        AppBean.valoresMetodos(context);
    }

    public static void valoresConstructor(ApplicationContext context) {
        Musico jara = (Musico) context.getBean("jara");

        System.out.println("Numero de Canciones: " + jara.getNumeroCanciones());
    }

    public static void referenciaConstructor(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("slash");

        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Tipo de instrumento: " + musico.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + musico.getInstrumento().getMarca());
    }

    public static void valoresMetodos(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("lennon");

        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Musico: " + musico.getNombres()+" "+musico.getApellidos());
    }
}
