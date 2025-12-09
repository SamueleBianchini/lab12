package it.unibo.es2;

import java.util.List;
import java.util.ArrayList;

/**
 * This class implements the Logics interface.
 */
public final class LogicsImpl implements Logics {

    private final List<List<Boolean>> matrix;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        matrix = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final List<Boolean> temp = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                temp.add(false);
            }
            this.matrix.add(temp);
        }
    }

    @Override
    public String hit(final Pair<Integer, Integer> pair) {
        if (!this.matrix.get(pair.x()).get(pair.y())) {
            this.matrix.get(pair.x()).set(pair.y(), true);
            return "*";
        } else {
            this.matrix.get(pair.x()).set(pair.y(), false);
            return " ";
        }
    }

    @Override
    public Boolean end() {
        Boolean test = true;
        for (final List<Boolean> i : matrix) {
            for (final Boolean j : i) {
                if (!j) {
                    test = false;
                    break;
                }
            }
            if (test) {
                return true;
            } else {
                test = true;
            }
        }
        for (int y = 0; y < matrix.size(); y++) {
            for (final List<Boolean> x : matrix) {
                if (!x.get(y)) {
                    test = false;
                    break;
                }
            }
            if (test) {
                return true;
            } else {
                test = true;
            }
        }
        return false;
    }
}
