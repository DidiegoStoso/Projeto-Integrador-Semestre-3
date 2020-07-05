package br.ifsc.slo.tecinfo.pi.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;


@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codRole;
    private String nomeRole;

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
        return this.nomeRole;
    }
}
