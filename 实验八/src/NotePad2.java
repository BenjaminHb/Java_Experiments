import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by benjaminzhang on 20/05/2017.
 * Copyright © benjaminzhang 2017.
 */

class NotePad2 extends JFrame {
    // 系统组件声明
    private final JMenuBar menuBar = new JMenuBar();
    private final JEditorPane content = new JEditorPane();
    private final JScrollPane scroll = new JScrollPane(content);
    private final JFileChooser filechooser = new JFileChooser();
    private final BorderLayout bord = new BorderLayout();
    private final JPanel pane = new JPanel();
    private File file = null;
    protected String clipboard;

    // 定义文件菜单
    private final JMenu fileMenu = new JMenu();
    private final JMenuItem newMenuItem = new JMenuItem();
    private final JMenuItem openMenuItem = new JMenuItem();
    private final JMenuItem saveMenuItem = new JMenuItem();
    private final JMenuItem saveAsMenuItem = new JMenuItem();
    private final JMenuItem pageSetupMenuItem = new JMenuItem();
    private final JMenuItem printMenuItem = new JMenuItem();
    private final JMenuItem exitMenuItem = new JMenuItem();
    // 定义编辑菜单
    private final JMenu editMenu = new JMenu();
    private final JMenuItem cutMenuItem = new JMenuItem();
    private final JMenuItem copyMenuItem = new JMenuItem();
    private final JMenuItem pasteMenuItem = new JMenuItem();

    // 定义帮助菜单
    private final JMenuItem aboutMenuItem = new JMenuItem();
    private final JMenu helpMenu = new JMenu();

    // 构造函数
    private NotePad2() {
        initComponents();
    }

    // 主函数
    public static void main(String args[]) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        NotePad2 NotePad2 = new NotePad2();
        NotePad2.setVisible(true);
    }

    private void initComponents() {

// 添加子菜单项到文件菜单
        fileMenu.setText("File");
        newMenuItem.setText("New");
        openMenuItem.setText("Open...");
        saveMenuItem.setText("Save...");
        saveAsMenuItem.setText("Save As...");
        exitMenuItem.setText("Exit");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

// 添加子菜单项到风格菜单
        editMenu.setText("Edit");
        cutMenuItem.setText("Cut");
        copyMenuItem.setText("Copy");
        pasteMenuItem.setText("Paste");
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

// 添加子菜单项到帮助菜单
        helpMenu.setText("Help");
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

// 定义文件菜单下的事件监听
        newMenuItem.addActionListener(new newMenuItem_actionAdapter(this));
        openMenuItem.addActionListener(new openMenuItem_actionAdapter(this));
        saveMenuItem.addActionListener(new saveMenuItem_actionAdapter(this));
        saveAsMenuItem.addActionListener(new saveAsMenuItem_actionAdapter(this));
        exitMenuItem.addActionListener(new exitMenuItem_actionAdapter(this));

// 定义编辑菜单下的事件监听
        cutMenuItem.addActionListener(new cutMenuItem_actionAdapter(this));
        copyMenuItem.addActionListener(new copyMenuItem_actionAdapter(this));
        pasteMenuItem.addActionListener(new pasteMenuItem_actionAdapter(this));

// 定义帮助菜单下的事件监听
        aboutMenuItem.addActionListener(new aboutMenuItem_actionAdapter(this));

// 填加菜单到菜单栏
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

// 对主窗口的一些设置
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Untitled - NotePad");
        this.setSize(640, 480);

        setJMenuBar(menuBar);
        pane.setLayout(bord);
        pane.add("Center", scroll);
        setContentPane(pane);
    }

    // 定义新建菜单项方法
    public void newMenuItemActionPerformed(ActionEvent evt) {
        file = null;
        if (!("".equals(content.getText()))) {
            Object[] options = {"Yes", "No", "Cancel"};
            int s = JOptionPane.showOptionDialog(null, "File " + getTitle() + " has been changed.\nDo you want to save them?", "Notepad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            switch (s) {
                case 0:
                    int returnVal = filechooser.showSaveDialog(this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        file = filechooser.getSelectedFile();
                        try {
                            FileWriter fw = new FileWriter(file);
                            fw.write(content.getText());
                            setTitle(filechooser.getSelectedFile().getName() + " - NotePad");
                            fw.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                case 1:
                    content.setText("");
                    setTitle("Untitled - NotePad");
            }
        }
    }

    // 定义打开菜单项方法
    public void openMenuItemActionPerformed(ActionEvent evt) {
        try {
            file = null;
            int returnVal = filechooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = filechooser.getSelectedFile();
                FileReader fr = new FileReader(file);
                int len = (int) file.length();
                char[] buffer = new char[len];
                fr.read(buffer, 0, len);
                fr.close();
                content.setText(new String(buffer));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 定义退出菜单项方法
    public void exitMenuItem_actionPerformed(ActionEvent e) {
        if (!("".equals(content.getText()))) {
            Object[] options = {"Yes", "No", "Cancel"};
            int s = JOptionPane.showOptionDialog(null, "File has been changed.\nDo you want to save them?", "NotePad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            switch (s) {
                case 0:
                    int returnVal = filechooser.showSaveDialog(this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        file = filechooser.getSelectedFile();
                        try {
                            FileWriter fw = new FileWriter(file);
                            fw.write(content.getText());
                            setTitle(filechooser.getSelectedFile().getName() + " - NotePad");
                            fw.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                case 1:
                    System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    // 保存事件
    public void saveMenuItemActionPerformed(ActionEvent evt) {
        int returnVal = filechooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = filechooser.getSelectedFile();

            try {
                FileWriter fw = new FileWriter(file);
                fw.write(content.getText());
                setTitle(filechooser.getSelectedFile().getName() + " - NotePad");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 另存为事件
    public void saveAsMenuItemActionPerformed(ActionEvent evt) {
        filechooser.setDialogTitle("Save As...");
        int returnVal = filechooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = filechooser.getSelectedFile();
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(content.getText());
                setTitle(filechooser.getSelectedFile().getName() + " - NotePad");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    // 剪贴事件
    public void cutMenuItemActionPerformed(ActionEvent evt) {
        String tempText = content.getSelectedText();
        clipboard = tempText;
        int start = content.getSelectionStart();
        int end = content.getSelectionEnd();
        content.replaceSelection("");
    }

    // 复制事件
    public void copyMenuItemActionPerformed(ActionEvent evt) {
        String tempText = content.getSelectedText();
        clipboard = tempText;
    }

    // 粘贴事件
    public void pasteMenuItemActionPerformed(ActionEvent evt) {
        try {
            if (clipboard != null) {
                content.replaceSelection("");
                int position = content.getCaretPosition();
                String text = content.getText();
                text = text.substring(0, position) + clipboard + text.substring(position, text.length());
                content.setText(text);
                content.setCaretPosition(position);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 关于事件
    public void aboutMenuItemActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Java NotePad\nJava Experiment_8_2\nCopyright © 2017 BenjaminZhang\nComputer School, Wuhan University",
                "About", JOptionPane.INFORMATION_MESSAGE);
    }

}

// 定义新建事件类
class newMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    newMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.newMenuItemActionPerformed(evt);
    }
}

// 定义打开事件类
class openMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    openMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.openMenuItemActionPerformed(evt);
    }
}

// 定义保存事件类
class saveMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    saveMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.saveMenuItemActionPerformed(evt);
    }
}

// 定义另存为事件类
class saveAsMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    saveAsMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.saveAsMenuItemActionPerformed(evt);
    }
}

// 定义剪贴事件类
class cutMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    cutMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.cutMenuItemActionPerformed(evt);
    }
}

// 定义复制事件类
class copyMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    copyMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.copyMenuItemActionPerformed(evt);
    }
}

// 定义粘贴事件类
class pasteMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    pasteMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.pasteMenuItemActionPerformed(evt);
    }
}

// 定义关于软件事件类
class aboutMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    aboutMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.aboutMenuItemActionPerformed(evt);
    }
}

// 定义退出事件类
class exitMenuItem_actionAdapter implements ActionListener {
    private final NotePad2 adaptee;

    exitMenuItem_actionAdapter(NotePad2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent evt) {
        adaptee.exitMenuItem_actionPerformed(evt);
    }
}