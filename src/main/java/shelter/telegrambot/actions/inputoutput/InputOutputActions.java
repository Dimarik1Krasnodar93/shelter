package shelter.telegrambot.actions.inputoutput;

import com.pengrad.telegrambot.model.Update;
import shelter.telegrambot.actions.inputs.Input;
import shelter.telegrambot.actions.output.Action;
import shelter.telegrambot.actions.output.EmptyAction;
import shelter.telegrambot.actionsInfo.ActionInfo;

public class InputOutputActions {

    public static Action execute(ActionInfo actionInfo, Action lastAction, Update update) {
        String messageText = update.message().text();
        if (!lastAction.needInput()) {
            Action action = actionInfo.getAction(messageText);
            action.execute(update.message().chat().id());
            lastAction = action;
        } else {
            Input input = actionInfo.getActionInput(lastAction);
            input.execute(update, messageText);
            lastAction = new EmptyAction();
        }
        return lastAction;
    }
}
