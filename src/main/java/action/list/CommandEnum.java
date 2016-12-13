package action.list;

import action.ActionCommand;
import action.command.ChangeDataCommand;
import action.command.LogInCommand;
import action.command.RegisterCommand;

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
