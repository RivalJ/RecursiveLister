import javax.swing.*;
import FileTools.*;

import java.awt.*;
import java.io.File;

public class GUI extends JFrame {
    JPanel centerPanel = new JPanel(), buttonsPanel = new JPanel();
    JTextArea logArea = new JTextArea();
    JScrollPane logScroll = new JScrollPane(logArea);

    public GUI(){
        super("File Organizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 850);
        setLocationRelativeTo(null);

        addTitle();
        addCenterPanel();
        addButtonsPanel();

        setVisible(true);
    }
    private void addTitle(){
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("File Organizer");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }
    private void addCenterPanel(){
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        logScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        logScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        logScroll.setPreferredSize(new Dimension(700, 700));

        centerPanel.add(logScroll);
        add(centerPanel, BorderLayout.CENTER);
    }
    private void addButtonsPanel(){
        JButton startButton = new JButton("Start");
        buttonsPanel.add(startButton);
        startButton.addActionListener(e -> {
            logArea.setText("");
            for(File file : FileLister.RecursiveListFiles(
                    FileGrabber.GetFileFromUser(
                            JFileChooser.DIRECTORIES_ONLY)
            )){
                logArea.append(file.getAbsolutePath() + "\n");
                logArea.append("\n");
            }
        });

        JButton quitButton = new JButton("Quit");
        buttonsPanel.add(quitButton);
        quitButton.addActionListener(e -> System.exit(0));
        buttonsPanel.add(quitButton);

        startButton.setPreferredSize(new Dimension(100, 50));
        quitButton.setPreferredSize(new Dimension(100, 50));

        add(buttonsPanel, BorderLayout.SOUTH);
    }

}
