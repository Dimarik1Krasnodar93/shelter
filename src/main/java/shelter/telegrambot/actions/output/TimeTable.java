package shelter.telegrambot.actions.output;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.telegrambot.actions.output.Action;
import shelter.telegrambot.listener.TelegramBotUpdatesListener;

@Component
public class TimeTable implements Action {
    @Autowired
    TelegramBot telegramBot;

    @Override
    public void execute(long chatId) {
        TelegramBotUpdatesListener.sendMessage(telegramBot, chatId,
                "09-18 per day");
    }

    @Override
    public boolean needInput() {
        return false;
    }
}
