package ui.tablemodels;

import data.entity.Borrowing;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RentalHistoryTableModel extends AbstractTableModel {
    private final List<Borrowing> borrowings;
    private final String[] columnNames = {"ID", "User", "Book Copy", "Borrow Date", "Return Date"};

    public RentalHistoryTableModel(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    @Override
    public int getRowCount() {
        return borrowings.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Borrowing borrowing = borrowings.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return borrowing.getId();
            case 1:
                return borrowing.getMember();
            case 2:
                return borrowing.getCopy();
            case 3:
                return borrowing.getBorrowDate();
            case 4:
                return borrowing.getReturnDate();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}