package br.edu.diaw.locadora;
import jakarta.persistence.*;import java.math.BigDecimal;
@Entity @Table(name="incomes") public class Income {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @ManyToOne(optional=false) @JoinColumn(name="account_id") public Account account;
 public String employer;
 @Column(precision=14,scale=2) public BigDecimal monthlyAmount;
}
