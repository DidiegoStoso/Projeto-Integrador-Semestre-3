package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Garcom implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codGarcom;
    private long cpf;
    private String nome;
    private String email;
    private String login;
    private String senha;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "garcons_roles",
            joinColumns = @JoinColumn(
                    name = "garcom_id",referencedColumnName = "codGarcom"),
            inverseJoinColumns = @JoinColumn (
                    name = "role_id", referencedColumnName = "codRole"))
    private List<Role> roles;

    public Garcom(){
    }

    public Garcom( int codigo, long cpf, String nome, String email, String login, String senha, List<Role> roles){
        this.codGarcom = codGarcom;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
