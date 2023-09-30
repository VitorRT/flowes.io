package br.com.bycoffe.flowes.utils.seed;

import br.com.bycoffe.flowes.repository.ClientRepository;
import br.com.bycoffe.flowes.repository.ProjectRepository;
import br.com.bycoffe.flowes.repository.TaskRepository;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import br.com.bycoffe.flowes.utils.seed.client.ClientSeeder;
import br.com.bycoffe.flowes.utils.seed.project.ProjectSeeder;
import br.com.bycoffe.flowes.utils.seed.task.TaskSeeder;
import br.com.bycoffe.flowes.utils.seed.workspace.WorkspaceSeeder;

public abstract class Seeder {
    public static void seed(
            ClientRepository clientRepository,
            WorkspaceRepository workspaceRepository,
            ProjectRepository projectRepository,
            TaskRepository taskRepository
    ) {
        ClientSeeder.seed(clientRepository);
        WorkspaceSeeder.seed(workspaceRepository);
        ProjectSeeder.seed(projectRepository);
        TaskSeeder.seed(taskRepository);
    }
}
