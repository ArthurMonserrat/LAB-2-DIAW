package br.edu.diaw.locadora;
import jakarta.persistence.*;import java.util.*;
@Entity @Table(name="accounts") public class Account {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(unique=true,nullable=false) public String username;
 @Column(nullable=false) public String passwordHash;
 public String name,cpf,rg,address,profession,agentType;
 @Column(nullable=false) public String role="CLIENT";
 @OneToMany(mappedBy="account",cascade=CascadeType.ALL,orphanRemoval=true) public List<Income> incomes=new ArrayList<>();
}
