package br.com.bycoffe.flowes.utils.seed.client;

import br.com.bycoffe.flowes.models.client.Client;
import br.com.bycoffe.flowes.models.client.dto.RegisterUpdateDataClient;
import br.com.bycoffe.flowes.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Slf4j
public abstract class ClientSeeder {

    public static void seed(ClientRepository clientRepository) {
        log.info("[ Seed ] - Semeando clientes...");
        clientRepository.saveAll(List.of(
                new Client(new RegisterUpdateDataClient(
                        "Yuu 💕",
                        "yuuh.takashi@gmail.com",
                        "darklove@ever" + "@",
                        LocalDate.of(2007, 8, 18)
                ))
        ));
        log.info("[ Seed ] - Semente de clientes plantada!");
        System.out.println("\n");
    }
}
