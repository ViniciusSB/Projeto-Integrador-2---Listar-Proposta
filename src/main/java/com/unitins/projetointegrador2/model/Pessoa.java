package com.unitins.projetointegrador2.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Pessoa extends AuditoriaModel implements org.springframework.security.core.userdetails.UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String matricula;

    @Email(message = "Por favor, informe um e-mail válido")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    private String cpf;

    private String senha;

    private String roles = "";

    private String permissions = "";

    @Column(name = "reset_token")
    private String resetToken;

    @ManyToMany
    @JoinTable(name = "ArquivoPessoa",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idArquivo"))
    private List<Arquivo> arquivos;

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    private List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    private List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        this.getRoleList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });

        this.getPermissionList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority( r);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.cpf;
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
