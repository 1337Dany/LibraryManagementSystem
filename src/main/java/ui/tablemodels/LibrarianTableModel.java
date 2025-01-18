package ui.tablemodels;

import data.entity.Librarian;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LibrarianTableModel extends AbstractTableModel {
    private final List<Librarian> librarians;
    private final String[] columnNames = {"ID", "Name", "Email", "Phone"};

    public LibrarianTableModel(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    @Override
    public int getRowCount() {
        return librarians.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Librarian librarian = librarians.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> librarian.getId();
            case 1 -> librarian.getUser();
            case 2 -> librarian.getEmploymentDate();
            case 3 -> librarian.getPosition();
            default -> null;
        };
    }

}