package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codComida;
    private String descricao;
    private int valor;

    public Comida( int codComida, String descricao, int valor){
        this.codComida = codComida;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Comida(){
    }

    public int getCodComida() {
        return codComida;
    }

    public void setCodComida(int codComida) {
        this.codComida = codComida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
