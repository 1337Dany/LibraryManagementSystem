package ui.tablemodels;

import data.entity.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {
    private final List<Book> books;
    private final String[] columnNames = {"ID", "Title", "Author", "Publisher", "Publication Year", "ISBN"};

    public BookTableModel(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthor();
            case 3:
                return book.getPublisher().getName(); // Assuming Publisher has a getName() method
            case 4:
                return book.getPublicationYear();
            case 5:
                return book.getIsbn();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}