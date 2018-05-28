package command;

import mediator.ModelMediator;
import memento.MementoCaretaker;

public class AddMementoCmd implements Command {
    private MementoCaretaker caretaker;
    private ModelMediator modelMediator;
    public AddMementoCmd() {
        this.caretaker = MementoCaretaker.getInstance();
        this.modelMediator = ModelMediator.getInstance();
    }

    @Override
    public void execute() {
        caretaker.addMemento(modelMediator.saveStateDiagram());
    }
}
