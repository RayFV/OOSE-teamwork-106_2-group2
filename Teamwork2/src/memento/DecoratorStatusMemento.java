package memento;

import java.awt.Color;
import java.awt.Point;

import statediagram.Component;
import statediagram.Note;
import statediagram.State;
import statediagram.StateDiagram;
import statediagram.Transition;

public class DecoratorStatusMemento extends ObjectStatusMemento {
    private ObjectStatusMemento component;
    public DecoratorStatusMemento(String className, int id, int group,
        Color color, float size, String text, int x, int y, Point p,
        Component component
    ) {
        super(className, id, group, color, size, text, x, y, p);
        this.component = component.save();
    }

    public Component getComponent() {
        Component re;
        ObjectStatusMemento m = this.component;
        if (m instanceof StateStatusMemento) {
            System.out.println("Decorator restore State");
            re = new State();
        }
        else if (m instanceof TransitionStatusMemento) {
            System.out.println("Decorator restore Transition");
            re = new Transition();
        }
        else if (m instanceof NoteStatusMemento) {
            System.out.println("Decorator restore Note");
            re = new Note();
        }
        else {
            System.out.println("Decorator restore StateDiagram");
            re = new StateDiagram();
        }
        re.restore(m);

        return re;
    }
}
