package shelter.telegrambot.repository;

import shelter.telegrambot.model.Client;

public interface ClientRepository {
    void save(Client client);
}
