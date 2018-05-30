package command;

import mediator.ModelMediator;
import memento.MementoCaretaker;

public class RedoCmd implements Command {
    private MementoCaretaker caretaker;
    private ModelMediator modelMediator;
    public RedoCmd() {
        this.caretaker = MementoCaretaker.getInstance();
        this.modelMediator = ModelMediator.getInstance();
    }

    @Override
    public void execute() {
        modelMediator.restoreStateDiagram(caretaker.redo());
    }
}
