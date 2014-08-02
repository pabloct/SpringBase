package com.pabloct.springbase.model;

import java.util.List;

public class Musico extends Persona {

    private int numeroCanciones;
    private Instrumento instrumento;
    private List<Instrumento> instrumentos;

    public Musico(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public Musico(int numeroCanciones, Instrumento instrumento) {
        this.numeroCanciones = numeroCanciones;
        this.instrumento = instrumento;
    }

    public Musico() {
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }
}
