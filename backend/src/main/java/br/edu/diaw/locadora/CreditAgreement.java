package br.edu.diaw.locadora;
import jakarta.persistence.*;import java.math.BigDecimal;
@Entity @Table(name="credits") public class CreditAgreement {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @OneToOne(optional=false) @JoinColumn(name="rental_id",unique=true) public Rental rental;
 @ManyToOne(optional=false) @JoinColumn(name="bank_id") public Account bank;
 @Column(precision=14,scale=2) public BigDecimal amount;
 public int installments;
}
