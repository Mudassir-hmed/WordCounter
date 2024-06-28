import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    // GUI components
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    // Constructor
    public WordCounter() {
        // Set the title of the window
        setTitle("Word Counter");

        // Create text area
        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create label to display word count
        wordCountLabel = new JLabel("Word Count: 0");

        // Create button to count words
        countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(wordCountLabel, BorderLayout.SOUTH);
        panel.add(countButton, BorderLayout.NORTH);

        // Add the panel to the frame
        add(panel);

        // Set default close operation and size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // Action listener for the button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            int wordCount = countWords(text);
            wordCountLabel.setText("Word Count: " + wordCount);
        }
    }

    // Method to count words
    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCounter());
    }
}
