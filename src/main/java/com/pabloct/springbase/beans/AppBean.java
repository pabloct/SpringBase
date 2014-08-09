package com.pabloct.springbase.beans;

import com.pabloct.springbase.beans.model.Guitarra;
import com.pabloct.springbase.beans.model.Instrumento;
import com.pabloct.springbase.beans.model.Musico;
import com.pabloct.springbase.beans.model.Piano;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        //AppBean.valoresConstructor(context);
        //AppBean.referenciaConstructor(context);
        //AppBean.valoresMetodos(context);
        //AppBean.inyeccionBeanInterno(context);
        //AppBean.inyeccionColecciones(context);
        //AppBean.referenciaMetodos(context);
        //AppBean.inyeccionValoresNull(context);
        //AppBean.autoWireByName(context);
        AppBean.autoWireByType(context);
        AppBean.autoWireByConstructor(context);
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
                Guitarra guitarra = (Guitarra)instrumento;
                System.out.println("Es una guitarra!!!");
                System.out.println("Numero de cuerdas: "+guitarra.getNumeroCuerdas());
            } else if (object.getClass().equals(Piano.class)) {
                Piano piano = (Piano) instrumento;
                System.out.println("Es un piano!!!");
                System.out.println("Numero de octavas: "+piano.getNumeroOctavas());
            }
        }
    }

    public static void referenciaMetodos(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("lennon");

        System.out.println("------------------------------------------");
        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Musico: " + musico.getNombres() + " " + musico.getApellidos());
        System.out.println("Marca de instrumento: " + musico.getInstrumento().getMarca());
    }
    
    public static void inyeccionValoresNull(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("james");

        System.out.println("------------------------------------------");
        System.out.println("Numero de Canciones: " + musico.getNumeroCanciones());
        System.out.println("Musico: " + musico.getNombres() + " " + musico.getApellidos());
        System.out.println("Instrumento: " + musico.getInstrumento());
    }
    
    public static void autoWireByName(ApplicationContext context) {
        Musico musico = (Musico) context.getBean("noel");

        System.out.println("------------------- por nombre -----------------------");
        System.out.println("Nombre de instrumento: " + musico.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + musico.getInstrumento().getMarca());
    }
    
    public static void autoWireByType(ApplicationContext context) {
        System.out.println("------------ por tipo -------------------------");
        Musico cerati = (Musico) context.getBean("cerati");
        System.out.println("Nombre de instrumento: " + cerati.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + cerati.getInstrumento().getMarca());
    }
    
    public static void autoWireByConstructor(ApplicationContext context) {
        System.out.println("------------ por constructor ----------------------");
        Musico charly = (Musico) context.getBean("charly");
        System.out.println("Nombre de instrumento: " + charly.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + charly.getInstrumento().getMarca());
    }
    
    public static void autoWire(ApplicationContext context) {
        System.out.println("------------ por constructor ----------------------");
        Musico charly = (Musico) context.getBean("charly");
        System.out.println("Nombre de instrumento: " + charly.getInstrumento().getNombre());
        System.out.println("Marca de instrumento: " + charly.getInstrumento().getMarca());
    }
}
