package shelter.telegrambot.actions.output;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.telegrambot.actions.output.Action;
import shelter.telegrambot.listener.TelegramBotUpdatesListener;

@Component
public class Rules implements Action {
    @Autowired
    TelegramBot telegramBot;
    @Override
    public void execute(long chatId) {
        TelegramBotUpdatesListener.sendMessage(telegramBot, chatId,
                "Before you get pet, you should pay some money");
    }

    @Override
    public boolean needInput() {
        return false;
    }

}
