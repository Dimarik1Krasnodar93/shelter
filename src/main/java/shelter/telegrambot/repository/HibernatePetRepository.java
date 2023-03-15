package shelter.telegrambot.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import shelter.telegrambot.model.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Repository
public class HibernatePetRepository implements PetRepository {
    private final SessionFactory sessionFactory;
    private final CrudRepository crudRepository;
    
    public static final String FIND_PET_BY_ID =
            "SELECT p FROM Pet AS p JOIN FETCH p.typePet WHERE p.id = :id";
    @Override
    public Pet findById(int id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<Pet> list = crudRepository.query(FIND_PET_BY_ID, Pet.class, map);
        if (list.isEmpty()) {
            throw new NoSuchElementException("Element was not found by id");
        }
        return crudRepository.query(FIND_PET_BY_ID, Pet.class, map).get(0);
    }
}
