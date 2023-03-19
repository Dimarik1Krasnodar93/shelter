package shelter.telegrambot.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shelter.telegrambot.model.Client;
import shelter.telegrambot.model.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Repository
public class HibernateClientRepository implements ClientRepository {
    private final SessionFactory sessionFactory;
    private final CrudRepository crudRepository;



    @Override
    public void save(Client client) {
        crudRepository.run(session -> session.save(client));
    }


}
