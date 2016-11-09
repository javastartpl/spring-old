package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {
}