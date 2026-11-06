package br.edu.diaw.locadora;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CreditRepository extends JpaRepository<CreditAgreement,Long>{}
