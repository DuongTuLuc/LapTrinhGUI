
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class LoginFrame extends JFrame {

    private JLabel lbUser, lbPass;
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btLogin, btReset;

    public LoginFrame(String title) {
        super(title);
        createGUI();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        processEvent();
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 10));
        p.add(lbUser = new JLabel("User name"));
        p.add(txtUser = new JTextField(10));
        p.add(lbPass = new JLabel("Password"));
        p.add(txtPass = new JPasswordField(10));
        p.add(btLogin = new JButton("Login"));
        p.add(btReset = new JButton("Reset"));

        btLogin.setIcon(new ImageIcon(this.getClass().getResource("/images/enter.png")));
        btReset.setIcon(new ImageIcon(this.getClass().getResource("/images/reset-password.png")));

        add(p);
    }

    public static void main(String[] args) {
        LoginFrame frm = new LoginFrame("Login system");
        frm.setVisible(true);
    }

    private void processEvent() {
        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code xu ly
                String user = txtUser.getText();
                String pass = txtPass.getText();
                if (user.equals("admin") || pass.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Dang nhap thanh cong");
                } else {
                    JOptionPane.showMessageDialog(null, "That bai", "Loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code xu ly
               txtUser.setText("");
               txtPass.setText("");
               txtUser.requestFocus();
            }
        });
    }
}
