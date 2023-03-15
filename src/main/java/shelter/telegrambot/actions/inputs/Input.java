package shelter.telegrambot.actions.inputs;

import com.pengrad.telegrambot.model.Update;

public interface Input<T> {
     T execute(Update update, String message);
}
