
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class TinhToanDonGian extends JFrame {

    private JLabel lb1, lb2, lb3;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btCong, btTru, btNhan, btChia;

    public TinhToanDonGian() {
        setTitle("Tinh toan don gian");
        taoGiaoDien();

        //setSize(400,300);
        pack();
        setLocationRelativeTo(null);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 5, 5));
        p1.add(lb1 = new JLabel("So 1"));
        p1.add(txtSo1 = new JTextField());
        txtSo1.setPreferredSize(new Dimension(100, 30));
        p1.add(lb2 = new JLabel("So 2"));
        p1.add(txtSo2 = new JTextField());
        p1.add(lb3 = new JLabel("Ket qua"));
        p1.add(txtKq = new JTextField());

        JPanel p2 = new JPanel();
        p2.add(btCong = new JButton("Cong"));
        p2.add(btTru = new JButton("Tru"));
        p2.add(btNhan = new JButton("Nhan"));
        p2.add(btChia = new JButton("Chia"));

        //set bo cuc cho thung chua chinh cua cua so
        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        //tiep nhan va xu li du kien
        btCong.addActionListener((ActionEvent e) -> {
            double x1 = Double.parseDouble(txtSo1.getText());
            double x2 = Double.parseDouble(txtSo2.getText());
            double kq = x1 + x2;
            txtKq.setText(String.valueOf(kq));
        });
        
        //tiep nhan va xu li du kien
        btTru.addActionListener((ActionEvent e) -> {
            double x1 = Double.parseDouble(txtSo1.getText());
            double x2 = Double.parseDouble(txtSo2.getText());
            double kq = x1 - x2;
            txtKq.setText(String.valueOf(kq));
        });
        
        //tiep nhan va xu li du kien
        btNhan.addActionListener((ActionEvent e) -> {
            double x1 = Double.parseDouble(txtSo1.getText());
            double x2 = Double.parseDouble(txtSo2.getText());
            double kq = x1 * x2;
            txtKq.setText(String.valueOf(kq));
        });
        
        //tiep nhan va xu li du kien
        btChia.addActionListener((ActionEvent e) -> {
            double x1 = Double.parseDouble(txtSo1.getText());
            double x2 = Double.parseDouble(txtSo2.getText());
            double kq = x1 / x2;
            txtKq.setText(String.valueOf(kq));
        });
    }

    public static void main(String[] args) {
        TinhToanDonGian frm = new TinhToanDonGian();
        frm.setVisible(true);
    }
}
