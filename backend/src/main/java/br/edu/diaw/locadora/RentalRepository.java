package br.edu.diaw.locadora;
import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
public interface RentalRepository extends JpaRepository<Rental,Long>{List<Rental> findByClientIdOrderByIdDesc(Long clientId);List<Rental> findAllByOrderByIdDesc();boolean existsByClientId(Long clientId);}
