package shelter.telegrambot.actions.output;

public class EmptyInputAction implements Action {
    @Override
    public void execute(long chatId) {

    }

    @Override
    public boolean needInput() {
        return true;
    }
}
