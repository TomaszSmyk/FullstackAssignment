package pl.smyk.tomasz.FullstackAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class FullstackAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackAssignmentApplication.class, args);
	}


}
