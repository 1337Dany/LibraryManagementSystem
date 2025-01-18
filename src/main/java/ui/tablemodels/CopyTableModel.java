package ui.tablemodels;

import data.entity.Copy;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CopyTableModel extends AbstractTableModel {
    private final List<Copy> copies;
    private final String[] columnNames = {"ID", "Book", "Copy Number", "Status"};

    public CopyTableModel(List<Copy> copies) {
        this.copies = copies;
    }

    @Override
    public int getRowCount() {
        return copies.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Copy copy = copies.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return copy.getId();
            case 1:
                return copy.getBook().getId(); // Assuming Book has a getId() method
            case 2:
                return copy.getCopyNumber();
            case 3:
                return copy.getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}