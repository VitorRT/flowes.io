package br.com.bycoffe.flowes.utils.seed.workspace;

import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.workspace.Workspace;
import br.com.bycoffe.flowes.models.workspace.dto.RegisterDataWorkspace;
import br.com.bycoffe.flowes.repository.WorkspaceRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class WorkspaceSeeder {
    public static void seed(WorkspaceRepository workspaceRepository) {
        log.info("[ Seed ] - Semeando workspaces...");

        workspaceRepository.saveAll(List.of(
               new Workspace(new RegisterDataWorkspace(
                        new Client(1L),
                        "Espaço da Yuu!",
                        "Meu espaço pessoal 😊",
                        "https://images.pexels.com/photos/3289845/pexels-photo-3289845.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ))
        ));
        log.info("[ Seed ] - Semente de workspaces plantada!");
        System.out.println("\n");
        /** FIM */
    }
}
