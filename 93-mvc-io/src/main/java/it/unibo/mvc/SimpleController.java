package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    @Override
    public void enqueue(String str) {

    }

    @Override
    public String dequeueAndPrint() {
        return "";
    }

    @Override
    public String peek() {
        return "";
    }

    @Override
    public List<String> getPrintHisory() {
        return List.of();
    }
}
