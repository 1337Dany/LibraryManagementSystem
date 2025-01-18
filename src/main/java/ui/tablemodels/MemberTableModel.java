// src/main/java/ui/admin/MemberTableModel.java
package ui.tablemodels;

import data.entity.Member;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MemberTableModel extends AbstractTableModel {
    private final List<Member> members;
    private final String[] columnNames = {"ID", "Name", "Email", "Phone Number", "Address"};

    public MemberTableModel(List<Member> members) {
        this.members = members;
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = members.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> member.getId();
            case 1 -> member.getName();
            case 2 -> member.getEmail();
            case 3 -> member.getPhoneNumber();
            case 4 -> member.getAddress();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}