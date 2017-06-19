import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by benjaminzhang on 19/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class AddressBook {
    private JButton addButton;
    private JButton refreshButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JLabel databaseJLabel;
    private JLabel executeResult;
    private JLabel executeResultJLabel;
    private JTextArea database;
    private JTextField id;
    private JTextField name;
    private JButton queryButton;
    private JLabel IDJLabel;
    private JLabel NameJLabel;
    private JPanel AddressBook;

    private DBHelper dbHelper = new DBHelper();
    private String sql;
    private ResultSet resultSet;
    private String columnName = "id\t\t\t\tname\n";
    private StringUtil stringUtil = new StringUtil();
    private String[] updateParas = new String[2];
    private String[] queryDeleteParas = new String[1];

    public AddressBook() {
        executeResult.setText("Connect to MySQL Database SUCCESSFUL.");

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "SELECT * FROM addressbook WHERE `ID` = ? OR `Name` = ?";
                updateParas[0] = id.getText();
                updateParas[1] = name.getText();
                resultSet = dbHelper.query(sql, updateParas);
                database.setText("");
                database.append(columnName);
                database.setEditable(false);
                try {
                    while (resultSet.next()) {
                        for (int j = 0; j < 2; j++) {
                            if (j != 1)
                                database.append(stringUtil.omitString(resultSet.getString(j + 1), 24));     //调整格式，使字符串对齐与第一行
                            else
                                database.append(resultSet.getString(j + 1));
                        }
                        database.append("\n");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                executeResult.setText("Query SUCCESSFUL.");
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "INSERT INTO `addressbook` (`ID`, `Name`) VALUES (?,?);";
                updateParas[0] = id.getText();
                updateParas[1] = name.getText();
                boolean status = dbHelper.update(sql, updateParas);
                showAllQuery();
                if (status) executeResult.setText("Add SUCCESSFUL.");
                else    executeResult.setText("Add UNSUCCESSFUL.");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "UPDATE `addressbook` SET `Name` = ? WHERE `ID`= ?;";
                updateParas[0] = name.getText();
                updateParas[1] = id.getText();
                boolean status = dbHelper.update(sql, updateParas);
                showAllQuery();
                if (status) executeResult.setText("Update SUCCESSFUL.");
                else    executeResult.setText("Update UNSUCCESSFUL.");
            }
        });
        deleteButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "DELETE FROM `addressbook` WHERE `ID`= ?;";
                queryDeleteParas[0] = id.getText();
                boolean status = dbHelper.update(sql, queryDeleteParas);
                showAllQuery();
                if (status) executeResult.setText("Delete SUCCESSFUL.");
                else    executeResult.setText("Delete UNSUCCESSFUL.");
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllQuery();
                executeResult.setText("Refresh SUCCESSFUL.");
            }
        });
    }

    public void showAllQuery(){
        sql = "SELECT * FROM addressbook";
        resultSet = dbHelper.query(sql);
        database.setText("");
        database.append(columnName);
        database.setEditable(false);
        try {
            while (resultSet.next()) {
                for (int j = 0; j < 2; j++) {
                    if (j != 1)
                        database.append(stringUtil.omitString(resultSet.getString(j + 1), 24));     //调整格式，使字符串对齐与第一行
                    else
                        database.append(resultSet.getString(j + 1));
                }
                database.append("\n");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddressBook");
        frame.setContentPane(new AddressBook().AddressBook);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 400);
    }
}
