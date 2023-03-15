package shelter.telegrambot.actions.output;



public interface Action {
    void execute(long chatId);
    boolean needInput();
}
