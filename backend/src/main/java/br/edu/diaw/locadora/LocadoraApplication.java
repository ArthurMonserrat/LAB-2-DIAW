package br.edu.diaw.locadora;
import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.Bean;import org.springframework.beans.factory.annotation.Value;import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication public class LocadoraApplication {
 public static void main(String[] args){SpringApplication.run(LocadoraApplication.class,args);}
 @Bean CommandLineRunner seed(CarRepository cars,AccountRepository users,PasswordEncoder enc,@Value("${app.agent-username}") String agent,@Value("${app.agent-password}") String pass,@Value("${app.bank-username}") String bank,@Value("${app.bank-password}") String bankPass){return args->{
 if(cars.count()==0){cars.save(new Car("MAT-001",2024,"Toyota","Corolla","ABC1D23","COMPANY",179,"https://images.unsplash.com/photo-1621007947382-bb3c3994e3fb?w=1000"));cars.save(new Car("MAT-002",2025,"Jeep","Compass","DEF4G56","BANK",249,"https://images.unsplash.com/photo-1568844293986-8d0400bd4745?w=1000"));cars.save(new Car("MAT-003",2023,"Volkswagen","Polo","GHI7J89","CLIENT",119,"https://images.unsplash.com/photo-1549317661-bd32c8ce0db2?w=1000"));}
 seedAgent(users,enc,agent,pass,"COMPANY","Agente da locadora");seedAgent(users,enc,bank,bankPass,"BANK","Agente do banco");
 };}
 private void seedAgent(AccountRepository users,PasswordEncoder enc,String login,String password,String kind,String name){if(login!=null&&!login.isBlank()&&password!=null&&!password.isBlank()&&users.findByUsernameIgnoreCase(login).isEmpty()){Account a=new Account();a.username=login;a.passwordHash=enc.encode(password);a.name=name;a.role="AGENT";a.agentType=kind;users.save(a);}}
}
