package Topics.DesignPatterns.SOLID_Principles.SingleResponsibilityGood;

import java.util.ArrayList;

public class Board {

    public int size;
    public ArrayList<String> spots;

    public Board(int size) {
        this.size = size;
        this.spots = new ArrayList<>();

        // Initializes a row of three squares, then goes down to the next row.
        for (int i = 0; i < size; i++) {
            this.spots.add(String.valueOf(3 * i));
            this.spots.add(String.valueOf(3 * i + 1));
            this.spots.add(String.valueOf(3 * i + 2));
        }
    }

    // Calculates all the values at an index
    public ArrayList<String> valuesAt(ArrayList<Integer> indexes) {
        ArrayList<String> values = new ArrayList<>();

        for (int index : indexes) {
            values.add(this.spots.get(index));
        }

        return values;
    }
}
