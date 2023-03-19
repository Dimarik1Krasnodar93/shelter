package shelter.telegrambot.repository;

import shelter.telegrambot.model.Client;
import shelter.telegrambot.model.Pet;

public interface ClientRepository {
    void save(Client client);

}
