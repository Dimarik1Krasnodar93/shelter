package shelter.telegrambot.actions.output;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.telegrambot.listener.TelegramBotUpdatesListener;

@Component
public class SaverContacts implements Action {
    @Autowired
    TelegramBot telegramBot;
    @Override
    public void execute(long chatId) {
        TelegramBotUpdatesListener.sendMessage(telegramBot, chatId,
                "Enter your name and phone number by using space");
    }

    @Override
    public boolean needInput() {
        return true;
    }
}
