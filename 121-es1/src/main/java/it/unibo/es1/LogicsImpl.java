package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> values;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.values.add(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.values.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return new ArrayList<>(this.values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        final List<Boolean> enabled = new ArrayList<>(this.size());
        for (int i = 0; i < this.size(); i++) {
            if (this.values.get(i) == this.size()) {
                enabled.add(false);
            } else {
                enabled.add(true);
            }
        }
        return enabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        this.values.set(elem, this.values.get(elem) + 1);
        return this.values.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return "<<" + this.values.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining("|")) + ">>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (int i = 0; i < this.size() - 1; i++) {
            if (!this.values.get(i).equals(this.values.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
