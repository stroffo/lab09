package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final Queue<String> queue = new LinkedList<>();
    private final List<String> history = new LinkedList<>();

    @Override
    public void enqueue(String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        queue.add(str);
    }

    @Override
    public String dequeueAndPrint() {
        if (this.peek() == null) {
            throw new IllegalStateException();
        }

        var element = queue.remove();

        System.out.println(element);
        history.add(element);

        return element;
    }

    @Override
    public String peek() {
        return queue.peek();
    }

    @Override
    public List<String> getPrintHisory() {
        return history;
    }
}
