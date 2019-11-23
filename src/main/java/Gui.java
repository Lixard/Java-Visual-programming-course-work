import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


final class Gui extends JFrame {

    Gui() {
        super("Javadoc to html converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label = new JLabel("Программа конвертирует javadoc в html страницу.");
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createRigidArea(new Dimension(10, 15)));

        JButton button = new JButton("Выбрать java файл");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(e -> {
            JFileChooser fileOpen = new JFileChooser();
            int ret = fileOpen.showDialog(null, "Выбрать файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileOpen.getSelectedFile();
//                label.setText(file.getName());
                if (getFileExtension(file).equals(".java")) {
                    try {
                        HtmlCreator creator = new HtmlCreator(file);
//                        creator.test();
//                        creator.generateHTML();
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Неправильный тип файла");
                }
            }
        });

        panel.add(button);
        panel.add(Box.createVerticalGlue());
        getContentPane().add(panel);
        setPreferredSize(new Dimension(350, 120));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @NotNull
    private String getFileExtension(@NotNull File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }
}
