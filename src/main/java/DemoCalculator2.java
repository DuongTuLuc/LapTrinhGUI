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

public class DemoCalculator2 extends JFrame {

    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btTinh, btNhapLai; 
    private JRadioButton rdCong, rdTru, rdNhan, rdChia;

    public DemoCalculator2() {
        setTitle("Tinh toan don gian");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2, 5, 5)); 
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
        txtKq.setEditable(false); 

        add(p1, BorderLayout.CENTER); 
        JPanel pButton = new JPanel();
        pButton.add(btTinh = new JButton("Tinh"));
        pButton.add(btNhapLai = new JButton("Nhap lai")); 
        add(pButton, BorderLayout.SOUTH); 

        // Tạo ButtonGroup để nhóm các JRadioButton
        ButtonGroup btgPhepTinh = new ButtonGroup();
        btgPhepTinh.add(rdCong);
        btgPhepTinh.add(rdTru);
        btgPhepTinh.add(rdNhan);
        btgPhepTinh.add(rdChia);
        rdCong.setSelected(true); 

        // Tiếp nhận sự kiện khi người dùng nhấn nút "Tinh"
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lấy giá trị số 1, số 2
                    double x = Double.parseDouble(txtSo1.getText());
                    double y = Double.parseDouble(txtSo2.getText());
                    double kq;

                    // Xét phép toán được chọn
                    if (rdCong.isSelected()) {
                        kq = x + y;
                    } else if (rdTru.isSelected()) {
                        kq = x - y;
                    } else if (rdNhan.isSelected()) {
                        kq = x * y;
                    } else {
                        if (y == 0) {
                            JOptionPane.showMessageDialog(null, "Khong the chia cho 0", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Nếu chia cho 0, không thực hiện tính toán
                        }
                        kq = x / y;
                    }
                    
                    // Hiển thị kết quả
                    txtKq.setText(String.valueOf(kq));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Loi nhap lieu", "Thong bao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Chức năng cho nút "Nhập lại"
        btNhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSo1.setText("");
                txtSo2.setText(""); 
                txtKq.setText("");  
                rdCong.setSelected(true); 
            }
        });
    }

    public static void main(String[] args) {
        DemoCalculator2 frm = new DemoCalculator2();
        frm.setVisible(true);
    }
}
