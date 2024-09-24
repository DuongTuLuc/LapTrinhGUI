import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoCalculator3 extends JFrame {

    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btTinh, btNhapLai;
    private JComboBox<String> cboPhepTinh;

    public DemoCalculator3() {
        setTitle("Tính toán đơn giản");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2, 5, 5));
        
        p1.add(lb1 = new JLabel("Số 1"));
        p1.add(txtSo1 = new JTextField());
        
        p1.add(lb2 = new JLabel("Số 2"));
        p1.add(txtSo2 = new JTextField());

        p1.add(lb3 = new JLabel("Phép tính"));
        p1.add(cboPhepTinh = new JComboBox<>());

        p1.add(lb4 = new JLabel("Kết quả"));
        p1.add(txtKq = new JTextField());
        txtKq.setEditable(false); 

        add(p1, BorderLayout.CENTER);
        
        JPanel pButton = new JPanel();
        pButton.add(btTinh = new JButton("Tính"));
        pButton.add(btNhapLai = new JButton("Nhập lại"));
        add(pButton, BorderLayout.SOUTH);

        // Khởi tạo dữ liệu cho phép tính bằng chữ
        cboPhepTinh.addItem("Cộng");
        cboPhepTinh.addItem("Trừ");
        cboPhepTinh.addItem("Nhân");
        cboPhepTinh.addItem("Chia");
        cboPhepTinh.setSelectedIndex(0); 

        // Tiếp nhận sự kiện khi người dùng nhấn nút "Tính"
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lấy giá trị số 1, số 2
                    double x = Double.parseDouble(txtSo1.getText());
                    double y = Double.parseDouble(txtSo2.getText());
                    double kq = 0;

                    // Xét phép toán được chọn
                    String pheptinh = (String) cboPhepTinh.getSelectedItem();
                    switch (pheptinh) {
                        case "Cộng":
                            kq = x + y;
                            break;
                        case "Trừ":
                            kq = x - y;
                            break;
                        case "Nhân":
                            kq = x * y;
                            break;
                        case "Chia":
                            if (y == 0) {
                                JOptionPane.showMessageDialog(null, "Không thể chia cho 0", "Error", JOptionPane.ERROR_MESSAGE);
                                return; // Nếu chia cho 0, không thực hiện tính toán
                            }
                            kq = x / y;
                            break;
                    }

                    // Hiển thị kết quả
                    txtKq.setText(String.valueOf(kq));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi nhập liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
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
                cboPhepTinh.setSelectedIndex(0); 
                txtSo1.requestFocus(); 
            }
        });
    }

    public static void main(String[] args) {
        DemoCalculator3 frm = new DemoCalculator3(); 
        frm.setVisible(true);
    }
}
