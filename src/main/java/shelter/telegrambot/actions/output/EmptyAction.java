package shelter.telegrambot.actions.output;

import shelter.telegrambot.actions.output.Action;

public class EmptyAction implements Action {
    @Override
    public void execute(long chatId) {

    }

    @Override
    public boolean needInput() {
        return false;
    }
}
