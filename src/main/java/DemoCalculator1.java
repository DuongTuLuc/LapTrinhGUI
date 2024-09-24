
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class DemoCalculator1 extends JFrame {

    private JLabel lb1, lb2, lb3;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btCong, btTru, btNhan, btChia, btExit;

    public DemoCalculator1() {
        setTitle("Tinh toan don gian");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 5, 5));
        p1.add(lb1 = new JLabel("So 1"));
        p1.add(txtSo1 = new JTextField());
        p1.add(lb2 = new JLabel("So 2"));
        p1.add(txtSo2 = new JTextField());
        p1.add(lb3 = new JLabel("Ket qua"));
        p1.add(txtKq = new JTextField());
        txtKq.setEditable(false);

        JPanel p2 = new JPanel();
        p2.add(btCong = new JButton("Cong"));
        p2.add(btTru = new JButton("Tru"));
        p2.add(btNhan = new JButton("Nhan"));
        p2.add(btChia = new JButton("Chia"));
        p2.add(btExit = new JButton("Ket thuc"));

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        // Tiếp nhận sự kiện cho các phép toán
        ActionListener operationListener = (ActionEvent e) -> {
            try {
                double x1 = Double.parseDouble(txtSo1.getText());
                double x2 = Double.parseDouble(txtSo2.getText());
                double kq = 0; // Biến lưu kết quả

                // Thực hiện phép toán dựa trên nút nhấn
                switch (e.getActionCommand()) {
                    case "Cong":
                        kq = x1 + x2;
                        break;
                    case "Tru":
                        kq = x1 - x2;
                        break;
                    case "Nhan":
                        kq = x1 * x2;
                        break;
                    case "Chia":
                        if (x2 == 0) {
                            JOptionPane.showMessageDialog(this, "Khong the chia cho 0!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        kq = x1 / x2;
                        break;
                }
                txtKq.setText(String.valueOf(kq));
            } catch (NumberFormatException ex) {
                // Xử lý khi nhập dữ liệu không hợp lệ
                JOptionPane.showMessageDialog(this, "Vui long nhap so hop le!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        };

        // Gán listener cho các nút
        btCong.addActionListener(operationListener);
        btTru.addActionListener(operationListener);
        btNhan.addActionListener(operationListener);
        btChia.addActionListener(operationListener);

        // Chức năng cho nút "Kết thúc"
        btExit.addActionListener((ActionEvent e) -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Ban co muon thoat?", "Xac nhan thoat",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // Đóng ứng dụng
            }
        });
    }

    public static void main(String[] args) {
        DemoCalculator1 frm = new DemoCalculator1(); // Tạo một đối tượng của lớp
        frm.setVisible(true); // Hiển thị cửa sổ
    }
}
