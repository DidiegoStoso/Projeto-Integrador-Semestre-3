package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garcom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codGarcom;
    private long cpf;
    private String nome;
    private String email;
    private String login;
    private String senha;

    public Garcom( int codigo, long cpf, String nome, String email, String login, String senha){
        this.codGarcom = codGarcom;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Garcom(){
    }

    public int getCodGarcom() {
        return codGarcom;
    }

    public void setCodGarcom(int codGarcom) {
        this.codGarcom = codGarcom;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString(){
        return "Garcom{" + "codigo" + codGarcom + ", cpf=" + cpf + ", nome=" + nome + ", e-mail=" + email + '}';
    }
}
