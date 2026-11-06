package br.edu.diaw.locadora;
import org.springframework.data.jpa.repository.JpaRepository;import java.util.Optional;
public interface AccountRepository extends JpaRepository<Account,Long>{Optional<Account> findByUsernameIgnoreCase(String username);}
