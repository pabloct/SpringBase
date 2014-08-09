package com.pabloct.springbase.beans.model;

public class Piano extends Instrumento{
  private int numeroOctavas;  

    public int getNumeroOctavas() {
        return numeroOctavas;
    }

    public void setNumeroOctavas(int numeroOctavas) {
        this.numeroOctavas = numeroOctavas;
    }
}
