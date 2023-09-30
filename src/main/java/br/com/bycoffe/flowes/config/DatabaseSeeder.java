package br.com.bycoffe.flowes.config;

import br.com.bycoffe.flowes.repository.ClientRepository;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.TaskRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import br.com.bycoffe.flowes.utils.seed.Seeder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Value("${flowes.application.database.seed}")
    private Boolean environment;
    

    Logger log = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Override
    public void run(String... args) throws Exception {
        // if(this.environment == null) this.environment = "DEVELOPMENT";
        if(this.environment != null && this.environment) {
            Seeder.seed(
                    clientRepository,
                    workspaceRepository,
                    projectRepository,
                    taskRepository
            );
        }
    }
}
