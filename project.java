import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class project {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Login System");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            JLabel userLabel = new JLabel("Username:");
            userLabel.setBounds(50, 50, 100, 30);
            frame.add(userLabel);

            JLabel passLabel = new JLabel("Password:");
            passLabel.setBounds(50, 100, 100, 30);
            frame.add(passLabel);

            JTextField userField = new JTextField();
            userField.setBounds(150, 50, 180, 30);
            frame.add(userField);

            JPasswordField passField = new JPasswordField();
            passField.setBounds(150, 100, 180, 30);
            frame.add(passField);

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(150, 150, 100, 30);
            frame.add(loginButton);

            JLabel statusLabel = new JLabel("");
            statusLabel.setBounds(150, 200, 200, 30);
            frame.add(statusLabel);

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = userField.getText();
                    String password = new String(passField.getPassword());

                    if (username.equals("admin") && password.equals("1234")) {
                        statusLabel.setText("Login successful!");
                    } else {
                        statusLabel.setText("Invalid username or password.");
                    }
                }
            });

            frame.setVisible(true);
        }
}
