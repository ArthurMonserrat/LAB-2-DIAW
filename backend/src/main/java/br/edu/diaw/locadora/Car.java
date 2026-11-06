package br.edu.diaw.locadora;
import jakarta.persistence.*;
@Entity @Table(name="cars") public class Car {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(unique=true,nullable=false) public String registration;
 public int year;
 public String brand,model;
 @Column(unique=true,nullable=false) public String plate;
 public String ownerType,imageUrl;
 public int dailyRate;
 public Car(){}
 public Car(String reg,int year,String brand,String model,String plate,String ownerType,int rate,String img){this.registration=reg;this.year=year;this.brand=brand;this.model=model;this.plate=plate;this.ownerType=ownerType;this.dailyRate=rate;this.imageUrl=img;}
}
