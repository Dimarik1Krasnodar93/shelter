package shelter.telegrambot.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shelter.telegrambot.model.Client;

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
