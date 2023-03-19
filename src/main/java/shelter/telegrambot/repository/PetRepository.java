package shelter.telegrambot.repository;

import shelter.telegrambot.model.Pet;

public interface PetRepository {
    Pet findById(int id);
}
