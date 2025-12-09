package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> values;
    private final List<Boolean> enabled;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.values = new ArrayList<>(size);
        this.enabled = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.values.add(0);
            this.enabled.add(true);
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
        return new ArrayList<>(this.enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        final int temp = this.values.get(elem);
        if (temp == this.size() - 1) {
            this.enabled.set(elem, false);
        }
        this.values.set(elem, temp + 1);
        return this.values.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        boolean test = false;
        for (Integer j = 0; j < this.size() - 1; j++) {
            if (!this.values.get(j).equals(this.values.get(j + 1))) {
                test = true;
                break;
            }
        }
        if (test) {
            String res = "<<";
            for (int i = 0; i < this.size(); i++) {
                if (i == this.size() - 1) {
                    res = res.concat(this.values.get(i).toString());
                } else {
                    res = res.concat(this.values.get(i).toString() + "|");
                }
            }
            res = res.concat(">>");
            return res;
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (final Integer i : this.values) {
            if (!i.equals(this.size())) {
                return false;
            }
        }
        return true;
    }
}
