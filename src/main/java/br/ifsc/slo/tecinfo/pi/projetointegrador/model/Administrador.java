package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codAdm;
    private String login;
    private String senha;

    public Administrador( int codAdm, String login, String senha){
        this.codAdm = codAdm;
        this.login = login;
        this.senha = senha;
    }

    public Administrador(){
    }

    public int getCodAdm() {
        return codAdm;
    }

    public void setCodAdm(int codAdm) {
        this.codAdm = codAdm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
