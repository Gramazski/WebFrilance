package action.list;

import action.ActionCommand;
import action.command.*;

/**
 * Created by gs on 10.12.2016.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LogInCommand();
        }
    },
    CHANGE_DATA{
        {
            this.command = new ChangeDataCommand();
        }
    },
    CREATE_CUSTOM{
        {
            this.command = new CreateCustomCommand();
        }
    },
    ADD_ORDER{
        {
            this.command = new AddOrderCommand();
        }
    },
    ADD_MIND{
        {
            this.command = new AddMindCommand();
        }
    },
    /*LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },*/
    REGISTR{
        {
            this.command = new RegisterCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
