package command;

import mediator.ModelMediator;
import memento.MementoCaretaker;

public class UndoCmd implements Command {
    private MementoCaretaker caretaker;
    private ModelMediator modelMediator;
    public UndoCmd() {
        this.caretaker = MementoCaretaker.getInstance();
        this.modelMediator = ModelMediator.getInstance();
    }

    @Override
    public void execute() {
        modelMediator.restoreStateDiagram(caretaker.undo());
    }
}
