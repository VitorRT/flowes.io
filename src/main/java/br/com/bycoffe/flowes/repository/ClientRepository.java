package br.com.bycoffe.flowes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoffe.flowes.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
