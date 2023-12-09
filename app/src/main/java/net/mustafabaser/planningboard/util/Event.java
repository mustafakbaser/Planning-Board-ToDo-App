package net.mustafabaser.planningboard.util;

/**
 * Wraps a value exposed through LiveData that must be handled only once,
 * such as an error message shown in a Snackbar.
 */
public class Event<T> {
    private final T content;
    private boolean handled = false;

    public Event(T content) {
        this.content = content;
    }

    /**
     * Returns the content the first time it is called, then null.
     */
    public T getContentIfNotHandled() {
        if (handled) {
            return null;
        }
        handled = true;
        return content;
    }
}
