package memento;

import mediator.ModelMediator;
import java.util.*;

public class MementoCaretaker{
    private ArrayList<ObjectStatusMemento> historyStatus;
    private int nowIndex;
    private ModelMediator mediator;

    public MementoCaretaker() {
        this.historyStatus = new ArrayList<ObjectStatusMemento>();
        this.nowIndex = -1;

        this.mediator = ModelMediator.getInstance();
    }

    public void addMemento(ObjectStatusMemento memento) {
        //�N�o�Ӱʧ@�᪺Memento�M��
        for (int i = (this.historyStatus.size() - 1); i > this.nowIndex; i -= 1) {
            this.historyStatus.remove(i);
        }

        this.historyStatus.add(memento);
        this.nowIndex += 1;
    }

    private ObjectStatusMemento getMemento(int index) {
        return this.historyStatus.get(index);
    }

    public boolean canUndo() {
        if (this.nowIndex > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * �^�ǤW�@�B��Memento, ���s�b�ɷ|�^�ǳ̪쪺 (list[0])
     * @return �W�@�B��Memento
     */
    public ObjectStatusMemento undo() {
        if (this.canUndo()) {
            this.nowIndex -= 1;
        }

        return this.getMemento(this.nowIndex);
    }


    public boolean canRedo() {
        if (this.nowIndex < (this.historyStatus.size() - 1)) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * �^�ǤU�@�B��Memento, ���s�b�ɷ|�^�ǲ{�b�� (list[size()-1])
     * @return �U�@�B��Memento
     */
    public ObjectStatusMemento redo() {
        if (this.canRedo()) {
            this.nowIndex += 1;
        }

        return this.getMemento(this.nowIndex);
    }
}