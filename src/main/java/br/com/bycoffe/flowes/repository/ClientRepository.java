package br.com.bycoffe.flowes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.client.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Page<Client> findAllByActiveTrue(Pageable pagination);

}
