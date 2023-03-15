package shelter.telegrambot.actions.inputs;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.telegrambot.listener.TelegramBotUpdatesListener;
import shelter.telegrambot.model.Pet;
import shelter.telegrambot.repository.HibernatePetRepository;

@Component
public class PetInfo implements Input {
    @Autowired
    private HibernatePetRepository hibernatePetRepository;
    @Autowired
    private TelegramBot telegramBot;

    @Override
    public Object execute(Update update, String message) {
        try {
            int id = Integer.parseInt(message);
            Pet pet =  hibernatePetRepository.findById(id);
            TelegramBotUpdatesListener.sendMessage(telegramBot, update.message().chat().id(),
                    pet.toString());
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
