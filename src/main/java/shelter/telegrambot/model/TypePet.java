package shelter.telegrambot.model;

import javax.persistence.*;

@Entity
@Table(name = "types_pets")
//3.1 phase
//temp
public class TypePet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
