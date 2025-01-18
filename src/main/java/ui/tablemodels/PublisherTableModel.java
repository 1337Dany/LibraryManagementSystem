package ui.tablemodels;

import data.entity.Publisher;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PublisherTableModel extends AbstractTableModel {
    private final List<Publisher> publishers;
    private final String[] columnNames = {"ID", "Name", "Address", "Phone"};

    public PublisherTableModel(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public int getRowCount() {
        return publishers.size();
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
        Publisher publisher = publishers.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> publisher.getId();
            case 1 -> publisher.getName();
            case 2 -> publisher.getAddress();
            case 3 -> publisher.getPhoneNumber();
            default -> null;
        };
    }
}