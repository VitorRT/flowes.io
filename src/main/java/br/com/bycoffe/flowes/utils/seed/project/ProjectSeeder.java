package br.com.bycoffe.flowes.utils.seed.project;

import br.com.bycoffe.flowes.models.project.Project;
import br.com.bycoffe.flowes.models.project.dto.RegisterDataProject;
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.utils.deadline.Deadline;
import br.com.bycoffe.flowes.utils.deadline.DeadlineEnd;
import br.com.bycoffe.flowes.utils.deadline.DeadlineStart;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public abstract class ProjectSeeder {
    public static void seed(ProjectRepository projectRepository) {
        /** Criando projects para workspaces */
        log.info("[ Seed ] - Semeando projects...");
        projectRepository.saveAll(List.of(
                new Project(new RegisterDataProject(
                        new Workspace(1L),
                        "Escola 📚✨",
                        new Deadline(
                                new DeadlineStart(LocalDateTime.now()),
                                new DeadlineEnd(LocalDateTime.of(2023, 11, 20, 9, 30, 0))
                        ),
                        "#A402A9",
                        "Tarefas de a fazeres da minha escola"
                ))
        ));
        log.info("[ Seed ] - Semente de projects plantada!");
        System.out.println("\n");
        /** FIM */
    }
}
