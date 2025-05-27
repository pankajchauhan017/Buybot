
package ui;

import ai.BuyBotBrain;
import javax.swing.*;
import java.awt.*;

public class ChatBotUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private BuyBotBrain bot;

    public ChatBotUI() {
        setTitle("BuyBot - AI Chat Assistant");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        bot = new BuyBotBrain();

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.addActionListener(e -> {
            String userText = inputField.getText();
            chatArea.append("You: " + userText + "\n");
            String response = bot.respond(userText);
            chatArea.append("BuyBot: " + response + "\n\n");
            inputField.setText("");
        });

        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);

        setVisible(true);
    }
}
