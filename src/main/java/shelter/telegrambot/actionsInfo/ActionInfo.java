package shelter.telegrambot.actionsInfo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import shelter.telegrambot.actions.output.Action;
import shelter.telegrambot.actions.output.GetterPetInfo;
import shelter.telegrambot.actions.output.SaverContacts;
import shelter.telegrambot.actions.inputs.Input;

@AllArgsConstructor
@Component
public class ActionInfo {
    @Autowired
    @Qualifier("welcome")
    private Action welcome;
    @Autowired
    @Qualifier("shelterInfo")
    private Action shelterInfo;
    @Autowired
    @Qualifier("timeTable")
    private Action timeTable;
    @Autowired
    @Qualifier("securityRecommendations")
    private Action securityRecommendations;
    @Autowired
    @Qualifier("saverContacts")
    private Action saverContacts;
    @Autowired
    @Qualifier("callVolunteer")
    private Action callVolunteer;
    @Autowired
    @Qualifier("getterPetInfo")
    private Action getterPetInfo;

    @Autowired
    @Qualifier("saverContactsInput")
    private Input saverContactsInput;
    @Autowired
    @Qualifier("petInfo")
    private Input petInfo;

    public Action getAction(String text) {
        switch (text) {
            case "/Start":
                return welcome;
            case "/ShelterInfo":
                return shelterInfo;
            case "/TimeTable":
                return timeTable;
            case "/SecurityRecommendations":
                return securityRecommendations;
            case "/SaveContactInfo":
                return saverContacts;
            case "/GetPetInfo":
                return getterPetInfo;
            default:
                return callVolunteer;
        }
    }

    public Input getActionInput(Action lastAction) {
        if (lastAction instanceof SaverContacts) {
            return saverContactsInput;
        }
        if (lastAction instanceof GetterPetInfo) {
            return petInfo;
        }
        return null;
    }
}
