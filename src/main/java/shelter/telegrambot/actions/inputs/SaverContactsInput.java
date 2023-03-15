package shelter.telegrambot.actions.inputs;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.telegrambot.listener.TelegramBotUpdatesListener;
import shelter.telegrambot.repository.HibernateClientRepository;
import shelter.telegrambot.model.Client;

@Component
public class  SaverContactsInput<T> implements Input {

    @Autowired
    private HibernateClientRepository hibernateClientRepository;
    @Autowired
    private TelegramBot telegramBot;

    @Override
    public T execute(Update update, String message) {
        String[] array = message.split(" ");
        if (array.length < 2) {
            throw new IllegalArgumentException("Incorrect name or phone. "
                    + "There should be only 1 space");
        }
        Client client = new Client(0, array[0], array[1]);
        hibernateClientRepository.save(client);
        TelegramBotUpdatesListener.sendMessage(telegramBot, update.message().chat().id(),
                "Done!");
        return null;
    }
}
