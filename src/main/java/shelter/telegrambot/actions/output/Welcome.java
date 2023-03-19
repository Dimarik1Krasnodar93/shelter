package shelter.telegrambot.actions.output;

import com.pengrad.telegrambot.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shelter.telegrambot.actions.output.Action;
import shelter.telegrambot.listener.TelegramBotUpdatesListener;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Welcome implements Action {
    @Autowired
    TelegramBot telegramBot;
    @Override
    public void execute(long chatId) {
        TelegramBotUpdatesListener.sendMessage(telegramBot, chatId,
                "Welcome! I'm chat-bot. Choose the link :\n" +
                        "/Start - main menu\n" +
                        "/ShelterInfo - information about shelter\n" +
                        "/GetPetInfo - information about shelter\n" +
                        "/TimeTable - get timetable, address and driving directions\n" +
                        "/SecurityRecommendations - give security recommendations\n" +
                        "/SaveContactInfo - write contacts and we'll recall you\n" +
                        "/CallVolunteer - call volunteer");
    }

    @Override
    public boolean needInput() {
        return false;
    }
}
