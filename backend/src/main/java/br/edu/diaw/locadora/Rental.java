package br.edu.diaw.locadora;
import jakarta.persistence.*;import java.time.LocalDate;
@Entity @Table(name="rentals") public class Rental {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @ManyToOne(optional=false) @JoinColumn(name="client_id") public Account client;
 @ManyToOne(optional=false) @JoinColumn(name="car_id") public Car car;
 public LocalDate startDate,endDate;
 @Enumerated(EnumType.STRING) public Status status=Status.PENDING;
 public String financialOpinion,reviewedBy;
 @OneToOne(mappedBy="rental",cascade=CascadeType.ALL,orphanRemoval=true) public CreditAgreement credit;
 public enum Status{PENDING,APPROVED,REJECTED,CONTRACTED,CANCELED}
}
