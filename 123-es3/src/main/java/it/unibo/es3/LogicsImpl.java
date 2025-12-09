package it.unibo.es3;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * This class implements the Logics interface to handle the logic behind the GUI.
 */
public final class LogicsImpl implements Logics {

    private final Random rand = new Random();
    private List<List<Boolean>> matrix;

    /**
     * this constructor is used to create the structure of this logics handler.
     * 
     * @param size the size of the matrix.
     */
    public LogicsImpl(final int size) {
        //creation of the list with all false elements.
        this.matrix = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final List<Boolean> temp = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                temp.add(false);
            }
            this.matrix.add(temp);
        }
        //setting three elements randomly to true.
        int a;
        int b;
        int n = 3;
        while (n > 0) {
            a = rand.nextInt(size);
            b = rand.nextInt(size);
            if (!this.matrix.get(a).set(b, true)) {
                n--;
            }
        }
    }

    @Override
    public Boolean hit() {
        final List<List<Boolean>> result = new ArrayList<>();
        for (final List<Boolean> list : this.matrix) {
            result.add(new ArrayList<>(list));
        }
        for (int x = 0; x < this.matrix.size(); x++) {
            for (int y = 0; y < this.matrix.size(); y++) {
                if (this.matrix.get(x).get(y)) {
                    for (int x1 = x - 1; x1 <= x + 1; x1++) {
                        for (int y1 = y - 1; y1 <= y + 1; y1++) {
                            if (x1 < this.matrix.size() && y1 < this.matrix.size() 
                            && x1 >= 0 && y1 >= 0) {
                                result.get(x1).set(y1, true);
                            }
                        }
                    }
                }
            }
        }
        this.matrix = result;
        return true;
    }

    @Override
    public Boolean end() {
        return this.matrix.stream()
                            .allMatch(inner -> inner.stream()
                                                    .allMatch(element -> element));
    }

    @Override
    public Boolean getPair(final Pair<Integer, Integer> pair) {
        return this.matrix.get(pair.x()).get(pair.y());
    }
}

