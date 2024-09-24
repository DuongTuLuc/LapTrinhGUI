
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class DemoJRadioButton extends JFrame {

    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btTinh;
    private JRadioButton rdCong, rdTru, rdNhan, rdChia;

    public DemoJRadioButton() {
        setTitle("Tinh toan don gian");
        taoGiaoDien();

        //setSize(400,300);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2, 5, 5));
        p1.add(lb1 = new JLabel("So 1"));
        p1.add(txtSo1 = new JTextField());
        txtSo1.setPreferredSize(new Dimension(100, 30));
        p1.add(lb2 = new JLabel("So 2"));
        p1.add(txtSo2 = new JTextField());

        JPanel p2 = new JPanel();
        p2.add(rdCong = new JRadioButton("+"));
        p2.add(rdTru = new JRadioButton("-"));
        p2.add(rdNhan = new JRadioButton("*"));
        p2.add(rdChia = new JRadioButton("/"));

        p1.add(lb3 = new JLabel("Phep tinh"));
        p1.add(p2);

        p1.add(lb4 = new JLabel("Ket qua"));
        p1.add(txtKq = new JTextField());

        add(p1);
        add(btTinh = new JButton("Tinh"), BorderLayout.SOUTH);

        //tao ButtonGroup de nhom cac JRadioButton
        ButtonGroup btgPhepTinh = new ButtonGroup();
        btgPhepTinh.add(rdCong);
        btgPhepTinh.add(rdTru);
        btgPhepTinh.add(rdNhan);
        btgPhepTinh.add(rdChia);
        rdCong.setSelected(true);

        //tiep nhan su kien khi nguoi dung nhan nut tinh
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //lay gia tri so1,so2
                    double x = Double.parseDouble(txtSo1.getText());
                    double y = Double.parseDouble(txtSo2.getText());
                    double kq;
                    //xet phep toan duoc chon
                    if (rdCong.isSelected()) {
                        kq = x + y;
                    } else if (rdTru.isSelected()) {
                        kq = x - y;
                    } else if (rdNhan.isSelected()) {
                        kq = x * y;
                    } else {
                        kq = x / y;
                    }
                    
                    //Hien ket qua
                   txtKq.setText(String.valueOf(kq));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Loi nhap lieu", "Thong bao", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    public static void main(String[] args) {
        DemoJRadioButton frm = new DemoJRadioButton();
        frm.setVisible(true);
    }
}
