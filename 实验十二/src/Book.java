import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by benjaminzhang on 18/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Book {
    private JPanel Book;
    private JButton executeButton;
    private JButton refreshButton;
    private JButton deleteButton;
    private JTextField ISBN;
    private JTextField bookName;
    private JTextField author;
    private JTextField publisher;
    private JTextField publishTime;
    private JTextArea database;
    private JButton createTableButton;
    private JButton createViewButton;
    private JLabel databaseJLabel;
    private JLabel executeResult;
    private JLabel executeResultJLabel;
    private JLabel ISBNJLabel;
    private JLabel publishTimeJLabel;
    private JLabel bookNameJLabel;
    private JLabel authorJLabel;
    private JLabel publisherJLabel;
    private JButton updateButton;

    private DBHelper dbHelper = new DBHelper();
    private String sql;
    private ResultSet resultSet;
    private String columnName = "ISBN\t\t\t\t书名\t\t\t\t作者\t\t\t\t出版社\t\t\t出版时间\n";
    private StringUtil stringUtil = new StringUtil();
    private String[] updateParas = new String[5];
    private String[] deleteParas = new String[1];

    public Book() {
        executeResult.setText("Connect to MySQL Database SUCCESSFUL.");

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "INSERT INTO `Book` (`ISBN`, `书名`, `作者`, `出版社`, `出版时间`) VALUES (?,?,?,?,?);";
                updateParas[0] = ISBN.getText();
                updateParas[1] = bookName.getText();
                updateParas[2] = author.getText();
                updateParas[3] = publisher.getText();
                updateParas[4] = publishTime.getText();
                boolean status = dbHelper.update(sql, updateParas);
                showQuery();
                if (status) executeResult.setText("Add SUCCESSFUL.");
                else    executeResult.setText("Add UNSUCCESSFUL.");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "UPDATE `Book` SET `书名` = ?, `作者` = ?, `出版社` = ?, `出版时间` = ? WHERE `ISBN`= ?;";
                updateParas[4] = ISBN.getText();
                updateParas[0] = bookName.getText();
                updateParas[1] = author.getText();
                updateParas[2] = publisher.getText();
                updateParas[3] = publishTime.getText();
                boolean status = dbHelper.update(sql, updateParas);
                showQuery();
                if (status) executeResult.setText("Update SUCCESSFUL.");
                else    executeResult.setText("Update UNSUCCESSFUL.");
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "DELETE FROM " +
                        "`Book` WHERE `ISBN`= ?;";
                deleteParas[0] = ISBN.getText();
                boolean status = dbHelper.update(sql, deleteParas);
                showQuery();
                if (status) executeResult.setText("Delete SUCCESSFUL.");
                else    executeResult.setText("Delete UNSUCCESSFUL.");
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuery();
                executeResult.setText("Refresh SUCCESSFUL.");
            }
        });
        createTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "CREATE TABLE `Test` (`Test` INT NOT NULL,PRIMARY KEY (`Test`));";
                dbHelper.update(sql);
                sql = "DROP TABLE `Test`;";
                dbHelper.update(sql);
                executeResult.setText("Create table SUCCESSFUL.");
            }
        });
        createViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sql = "CREATE VIEW `new_view` AS SELECT * FROM Book;";
                dbHelper.update(sql);
                sql = "DROP VIEW `new_view`;";
                dbHelper.update(sql);
                executeResult.setText("Create view SUCCESSFUL.");
            }
        });
    }

    public void showQuery(){
        sql = "SELECT * FROM Book";
        resultSet = dbHelper.query(sql);
        database.setText("");
        database.append(columnName);
        database.setEditable(false);
        try {
            while (resultSet.next()) {
                for (int j = 0; j < 5; j++) {
                    if (j != 4)
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
        JFrame frame = new JFrame("Book");
        frame.setContentPane(new Book().Book);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 500);
    }
}
