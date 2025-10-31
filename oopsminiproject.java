//GAYATHRI P
//2117240070087

PROGRAM:
 SERVER:
Foodservermain.java:

package Server;
import java.net.*;
import java.io.*;

public class FoodserverMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println(" Server started on port 5000...");
            DatabaseManager db = new DatabaseManager();

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, db)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

Dbconnection.java:
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection - Handles database connection using JDBC
 */
public class DBConnection {

    // Update these with your MySQL details
    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery";
    private static final String USER = "root";
    private static final String PASSWORD = "gayu007";

    // Singleton Connection instance
    private static Connection connection = null;

    // Private constructor to prevent object creation
    private DBConnection() {}

    // Method to get database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(" Database Connected Successfully!");
            } 
            catch (ClassNotFoundException e) {
                System.out.println(" JDBC Driver not found!");
                e.printStackTrace();
            } 
            catch (SQLException e) {
                System.out.println("Database Connection Failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Optional: Close connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println(" Database Connection Closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
package Database;

import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        // Get connection from DBConnection class
        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println(" Connection Test Successful!");
            DBConnection.closeConnection();
        } else {
            System.out.println(" Connection Test Failed!");
        }
    }
}

CLIENT:
foodclient.java:
package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodClient extends JFrame implements ActionListener {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField usernameField, qtyField, itemIdField;
    private JPasswordField passwordField;
    private JTextArea displayArea;
    private JButton loginBtn, registerBtn, orderBtn, backBtn;

    public FoodClient() {
        setTitle(" Food Delivery System");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Card Layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(loginPanel(), "LOGIN");
        mainPanel.add(menuPanel(), "MENU");

        add(mainPanel);
        setVisible(true);
    }

    // ---------- LOGIN PANEL ----------
    private JPanel loginPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(250, 245, 240));

        // Gradient Header
        JPanel header = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 140, 0), getWidth(), getHeight(), new Color(255, 69, 0));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setPreferredSize(new Dimension(600, 80));
        JLabel title = new JLabel(" Welcome to Food Delivery", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.setLayout(new BorderLayout());
        header.add(title, BorderLayout.CENTER);

        // Center Login Form
        JPanel formPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(40, 150, 40, 150));

        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        loginBtn = createButton("Login", new Color(46, 204, 113));
        registerBtn = createButton("Register", new Color(52, 152, 219));

        formPanel.add(usernameField);
        formPanel.add(passwordField);
        formPanel.add(loginBtn);
        formPanel.add(registerBtn);

        panel.add(header, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);

        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);

        return panel;
    }

    // ---------- MENU PANEL ----------
    private JPanel menuPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(250, 245, 240));

        // Header
        JLabel header = new JLabel("🍴 MENU", JLabel.CENTER);
        header.setOpaque(true);
        header.setBackground(new Color(255, 99, 71));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setPreferredSize(new Dimension(600, 60));

        // Menu display
        displayArea = new JTextArea("""
            === MENU ===
            1. Pizza     - ₹299
            2. Burger    - ₹149
            3. Pasta     - ₹199
            4. Fries     - ₹99
            5. Sandwich  - ₹129
        """);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 15));
        displayArea.setBorder(BorderFactory.createTitledBorder("Available Items"));
        displayArea.setBackground(Color.WHITE);

        // Order Panel
        JPanel orderPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        orderPanel.setBackground(new Color(255, 250, 240));
        orderPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));

        itemIdField = new JTextField();
        itemIdField.setBorder(BorderFactory.createTitledBorder("Item ID"));
        qtyField = new JTextField();
        qtyField.setBorder(BorderFactory.createTitledBorder("Quantity"));

        orderBtn = createButton("Place Order", new Color(241, 196, 15));
        backBtn = createButton("Logout", new Color(231, 76, 60));

        orderBtn.addActionListener(this);
        backBtn.addActionListener(this);

        orderPanel.add(itemIdField);
        orderPanel.add(qtyField);
        orderPanel.add(orderBtn);
        orderPanel.add(backBtn);

        panel.add(header, BorderLayout.NORTH);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        panel.add(orderPanel, BorderLayout.SOUTH);

        return panel;
    }

    // ---------- BUTTON DESIGN ----------
    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(color);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(color.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(color);
            }
        });
        return btn;
    }

    // ---------- ACTION HANDLER ----------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            JOptionPane.showMessageDialog(this, "Login Successful (Demo Mode)");
            cardLayout.show(mainPanel, "MENU");
        } else if (e.getSource() == registerBtn) {
            JOptionPane.showMessageDialog(this, " Registration Successful (Demo Mode)");
        } else if (e.getSource() == orderBtn) {
            String id = itemIdField.getText();
            String qty = qtyField.getText();
            JOptionPane.showMessageDialog(this, " Order Placed!\nItem ID: " + id + "\nQuantity: " + qty);
        } else if (e.getSource() == backBtn) {
            cardLayout.show(mainPanel, "LOGIN");
        }
    }

    public static void main(String[] args) {
        new FoodClient();
    }
}
