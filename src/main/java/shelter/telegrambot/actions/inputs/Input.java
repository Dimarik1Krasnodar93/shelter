package shelter.telegrambot.actions.inputs;

import com.pengrad.telegrambot.model.Update;

public interface Input {
    void save(Update update, String message);
}
