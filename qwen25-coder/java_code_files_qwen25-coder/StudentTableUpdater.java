import java.lang.String;
import java.awt.Color;

public class StudentTableUpdater {

    public static void main(String[] args) {

        // Assuming students is an array of Student objects
        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Surname" + i);
        }

        // Assuming table is a Table object with appropriate methods
        Table table = new Table(10, 10);

        // Preferred method: using row and column methods
        for (int i = 0; i < students.length; i++) {
            table.row(i).column(0).setText(students[i].surname());
            table.row(i).column(0).setBackground(Color.RED);
        }

        // Less preferred method: direct access via operators
        for (int i = 0; i < students.length; i++) {
            table.cells[0][i].setText(students[i].surname());
            // Assuming an operator[] exists for setting background color
            // This is less clear and may not be available as described
            table.cells[0][i].setBackground(Color.RED);
        }
    }
}

class Student {
    private String surname;
    public Student(String surname) {
        this.surname = surname;
    }
    public String surname() {
        return surname;
    }
}

class Table {
    public Cell[][] cells;

    public Table(int rows, int columns) {
        cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public RowReference row(int i) {
        return new RowReference(cells[i]);
    }

    class RowReference {
        private Cell[] rowCells;
        public RowReference(Cell[] rowCells) {
            this.rowCells = rowCells;
        }

        public Cell column(int i) {
            return rowCells[i];
        }
    }
}

class Cell {
    public void setText(String text) {
        // Do nothing
    }

    public void setBackground(Color color) {
        // Do nothing
    }
}