package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codPedido;
    private Garcom garcom;
    private String itens;
    private int nMesa;
    private int valor;

    public Pedido( int codPedido, Garcom garcom, String itens, int nMesa, int valor){
        this.codPedido = codPedido;
        this.garcom = garcom;
        this.itens = itens;
        this.nMesa = nMesa;
        this.valor = valor;
    }

    public Pedido(){
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public int getnMesa() {
        return nMesa;
    }

    public void setnMesa(int nMesa) {
        this.nMesa = nMesa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
