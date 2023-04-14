package br.com.bycoffe.flowes.config;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.task.Task;
import br.com.bycoffe.flowes.models.task.dto.RegisterDataTask;
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.repository.ClientRepository;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.TaskRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import br.com.bycoffe.flowes.utils.TaskCategory.Category;
import br.com.bycoffe.flowes.utils.deadline.Deadline;
import br.com.bycoffe.flowes.utils.deadline.DeadlineEnd;
import br.com.bycoffe.flowes.utils.deadline.DeadlineStart;
import br.com.bycoffe.flowes.utils.deadline.DeadlineTask;

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
    

    Logger log = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Override
    public void run(String... args) throws Exception {
        System.out.println("A Puga Semando o BD! <3");

        /** Criando contas dos clientes */
        log.info("[ Seed ] - Semeando clientes...");
        clientRepository.saveAll(List.of(
            new Client(new RegisterUpdateDataClient("Vitu 🎴", "vitu.barberino@gmail.com", "teste123", LocalDate.of(2004, 3, 24))),
            new Client(new RegisterUpdateDataClient("ʬ Mirelaah ʬ", "mirelaah.sun@gmail.com", "pugalinda", LocalDate.of(2004, 7, 16))),
            new Client(new RegisterUpdateDataClient("Hioda Takashi", "hioda.takashi@gmail.com", "kewanforever", LocalDate.of(2004, 3, 24))),
            new Client(new RegisterUpdateDataClient("Yuu 💕", "yuuh.takashi@gmail.com", "darklove@ever", LocalDate.of(2007, 8, 18)))
        ));
        log.info("[ Seed ] - Semente de clientes plantada!");
        System.out.println("\n");
        /** FIM */

        /** Criando workspaces para contas */
        log.info("[ Seed ] - Semeando workspaces...");
       
        workspaceRepository.saveAll(List.of(
          new Workspace(new RegisterDataWorkspace(new Client(1L), "MyTale 💌", LocalDateTime.of(2023, 11, 20, 15, 0, 0), "Todos os projetos do projeto MyTale", "mytale.png")),
          new Workspace(new RegisterDataWorkspace(new Client(2L), "Miih ✨", LocalDateTime.of(2023, 11, 20, 15, 0, 0), null, null)),
          new Workspace(new RegisterDataWorkspace(new Client(3L), "Kewan", LocalDateTime.of(2023, 11, 20, 15, 0, 0), "Área de trabalho para os projetos do meu clã.", null)),
          new Workspace(new RegisterDataWorkspace(new Client(4L), "Espaço da Yuu!", LocalDateTime.of(2023, 11, 20, 15, 0, 0), "Meu espaço pessoal 😊", "yuu.png"))
        ));
        log.info("[ Seed ] - Semente de workspaces plantada!");
        System.out.println("\n");
        /** FIM */


        /** Criando projects para workspaces */
        log.info("[ Seed ] - Semeando projects...");
        projectRepository.saveAll(List.of(
        new Project(new RegisterDataProject(new Workspace(1L), "Software Design 🔨", new Deadline(new DeadlineStart(LocalDateTime.now()), new DeadlineEnd(LocalDateTime.of(2023, 11, 20, 9, 30, 0))), "#FF8606", null)),
        new Project(new RegisterDataProject(new Workspace(2L), "Treino 💪", new Deadline(new DeadlineStart(LocalDateTime.now()), new DeadlineEnd(LocalDateTime.of(2023, 11, 20, 9, 30, 0))), "#00BCD2", "Projeto verão mirelah saradão!")),
        new Project(new RegisterDataProject(new Workspace(3L), "Bar do King! 🍻", new Deadline(new DeadlineStart(LocalDateTime.now()), new DeadlineEnd(LocalDateTime.of(2023, 11, 20, 9, 30, 0))), "#00BCD2", "Tarefas da rotina do meu trabalho")),
        new Project(new RegisterDataProject(new Workspace(4L), "Escola 📚✨", new Deadline(new DeadlineStart(LocalDateTime.now()), new DeadlineEnd(LocalDateTime.of(2023, 11, 20, 9, 30, 0))), "#A402A9", "Tarefas de a fazeres da minha escola"))
        ));
        log.info("[ Seed ] - Semente de projects plantada!");
        System.out.println("\n");
        /** FIM */

        /** Criando tasks para projects */
        log.info("[ Seed ] - Semeando tasks...");
        taskRepository.saveAll(List.of(
            new Task(new RegisterDataTask(new Project(1L), "Levantamento de Requisitos", "Requisitos de Usuário", "#F6E300", new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.HOJE)),
            new Task(new RegisterDataTask(new Project(1L), "Criar 10 Regras de Negócio", "Regras de Negócio", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 19, 0, 0)), Category.HOJE)),
            new Task(new RegisterDataTask(new Project(1L), "Iniciar BackLog do Produto", "Backlog", "#4B6CFF", new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 19, 0, 0)), Category.HOJE)),
            new Task(new RegisterDataTask(new Project(2L), "Realizar 10 agachamentos", "Aquecimento", "#23FD89", new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.HOJE)),
            new Task(new RegisterDataTask(new Project(2L), "Fazer 4 séries de legpress - 10 repetições", "Treino de Perna", "#FD239D", new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.HOJE)),
            new Task(new RegisterDataTask(new Project(2L), "Fazer 4 séries de afundo - 10 repetições", "Treino de Perna", "#FD239D", new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.HOJE)),
            new Task(new RegisterDataTask(new Project(3L), "Limpar bar", "Limpeza", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
            new Task(new RegisterDataTask(new Project(3L), "Lavar a louça", "Limpeza", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
            new Task(new RegisterDataTask(new Project(3L), "Arrumar mesas", "Limpeza", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
            new Task(new RegisterDataTask(new Project(3L), "Servir clientes no bar", "trabalho", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA)),
            new Task(new RegisterDataTask(new Project(3L), "Cozinhar", "trabalho", null, new DeadlineTask(LocalDateTime.now(), LocalDateTime.of(2023, 04, 15, 16, 0, 0)), Category.AMANHA))
        ));
        log.info("[ Seed ] - Semente de tasks plantada!");
        System.out.println("\n");
        /** FIM */

    }
}
