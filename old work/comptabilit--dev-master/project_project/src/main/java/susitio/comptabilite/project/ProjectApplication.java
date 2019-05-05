package susitio.comptabilite.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import susitio.comptabilite.project.dao.MessageRepository;
import susitio.comptabilite.project.dao.RoleRepository;
import susitio.comptabilite.project.entities.Message;
import susitio.comptabilite.project.entities.Role;
import susitio.comptabilite.project.services.ClientService;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProjectApplication.class, args);
		ProjectApplication projectApplication = new ProjectApplication();
		projectApplication.addDummyDBEntries(ctx);	
		}
	
	@Autowired
	public RoleRepository roleRepository;
	@Autowired
	public MessageRepository messageRepository ;
	@Autowired
	public ClientService clientService ;

	
	public void addDummyDBEntries(ApplicationContext ctx) {
		
		messageRepository = ctx.getBean(MessageRepository.class) ;
		messageRepository.save(new Message("hi","hi"));
		
		roleRepository = ctx.getBean(RoleRepository.class) ;
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("COLLABORATEUR"));
		roleRepository.save(new Role("CLIENT"));
	}
}
