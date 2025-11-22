package it.unibo.mvc;

/**
 *
 */
public interface Controller {
    public void enqueue(final String str) throws NullPointerException;

    public String dequeueAndPrint() throws IllegalStateException;

    public String peek();

    public java.util.List<String> getPrintHisory();
}
