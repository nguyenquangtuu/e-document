package command;

import model.Document;

public interface DocumentCommand {
    void execute() throws Exception;
    void undo() throws Exception;
    String getDescription();
    Document getDocument();
}

