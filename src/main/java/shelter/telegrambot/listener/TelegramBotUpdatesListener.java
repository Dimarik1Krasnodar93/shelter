package shelter.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shelter.telegrambot.actions.inputoutput.InputOutputActions;
import shelter.telegrambot.actions.output.Action;
import shelter.telegrambot.actions.output.EmptyAction;
import shelter.telegrambot.actionsInfo.ActionInfo;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener
{
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    private Action lastAction = new EmptyAction();
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    ActionInfo actionInfo;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        for(Update update : updates) {
            logger.info("Processing update: {}", update);
            lastAction = InputOutputActions.execute(actionInfo, lastAction, update);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    public static void sendMessage(TelegramBot telegramBot, long chatId, String textToSend) {
        SendMessage message = new SendMessage(chatId, textToSend);
        try {
            telegramBot.execute(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
}

