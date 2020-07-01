package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codRole;
    private String nomeRole;
    @ManyToMany(mappedBy = "roles")
    private List<Garcom> garcons;

    public Role(String nomeRole){
        this.nomeRole = nomeRole;
    }

    public Role(){
    }

    public int getCodRole(){
         return codRole;
    }

    public void setCodRole(int codRole){
        this.codRole = codRole;
    }

    public String getNomeRole(){
        return nomeRole;
    }

    public void setNomeRole(String nomeRole){
        this.nomeRole = nomeRole;
    }

    @Override
    public String getAuthority() {
        return nomeRole;
    }
}
