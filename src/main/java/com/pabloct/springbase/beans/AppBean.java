package com.pabloct.springbase.beans;

import com.pabloct.springbase.model.Guitarra;
import com.pabloct.springbase.model.Instrumento;
import com.pabloct.springbase.model.Musico;
import com.pabloct.springbase.model.Piano;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        AppBean.valoresConstructor(context);
        AppBean.referenciaConstructor(context);
        AppBean.valoresMetodos(context);
        AppBean.inyeccionBeanInterno(context);
        AppBean.inyeccionColecciones(context);
    }

    public static void valoresConstructor(ApplicationContext context) {
        Musico jara = (Musico) context.getBean("jara");

        System.out.println("Numero de Canciones: " + jara.getNumeroCanciones());
    }

    public static void referenciaConstructor(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("slash");

        System.out.println("------------------------------------------");
        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Tipo de instrumento: " + musico.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + musico.getInstrumento().getMarca());
    }

    public static void valoresMetodos(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("lennon");

        System.out.println("------------------------------------------");
        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Musico: " + musico.getNombres() + " " + musico.getApellidos());
    }

    public static void inyeccionBeanInterno(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("raulGarcia");
        System.out.println("------------------------------------------");
        System.out.println("Nombre: " + musico.getNombres());
        System.out.println("Apellido: " + musico.getApellidos());
        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Tipo de instrumento: " + musico.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + musico.getInstrumento().getMarca());
    }

    public static void inyeccionColecciones(ApplicationContext context) {

        Musico musico = (Musico) context.getBean("adrian");
        System.out.println("------------------------------------------");
        System.out.println("Nombre: " + musico.getNombres());
        System.out.println("Apellido: " + musico.getApellidos());
        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        //System.out.println("Instrumentos: " + musico.getInstrumentos());

        for (Object object : musico.getInstrumentos()) {
            Instrumento instrumento = (Instrumento) object;
            System.out.println("Instrumento-nombre: " + instrumento.getNombre());
            System.out.println("Instrumento-marca: " + instrumento.getMarca());
            System.out.println("Instrumento-tipo: " + instrumento.getTipo());
            if (object.getClass().equals(Guitarra.class)) {
                System.out.println("Es una guitarra!!!");
            } else if (object.getClass().equals(Piano.class)) {
                System.out.println("Es un piano!!!");
            }
        }
    }
}
