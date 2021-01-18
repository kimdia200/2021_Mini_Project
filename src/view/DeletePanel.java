package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EngController;
import util.MyUtill;
import vo.Eng;

public class DeletePanel extends JPanel {
	private JFrame parent;
	private EngController controller = new EngController();
	private JTextField txt1;
	private BufferedImage image;
	private List<Eng> list = MainFrame.list;

	public DeletePanel(JFrame parent) {
		this.parent = parent;

		// 백그라운드 이미지 그려주기
		try {
			image = ImageIO.read(new File("images/delete.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// null레이아웃
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		// component setting
		JButton btn1 = new JButton("뒤로");
		JButton btn2 = new JButton("삭제");
		txt1 = new JTextField("영단어");

		btn1.setBounds(265, 0, 60, 45);
		btn2.setBounds(260, 250, 60, 45);
		txt1.setBounds(50, 250, 200, 45);

		// 뒤로가기버튼 리스너
		btn1.addActionListener(addListener(1));
		// 삭제요청 버튼 리스너
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String word = txt1.getText();
				Eng temp = new Eng(word, "", "");
				list = new EngController().loadEngList();
				if (list.contains(temp)) {
					controller.deleteList(new Eng(word, "", ""));
					txt1.setText("영단어");
					List<Eng> list = new EngController().loadEngList();
					System.out.println("Delete패널 단어 삭제됨");
					System.out.println("list size : " + list.size());
					System.out.println("list : " + list);
					JOptionPane.showMessageDialog(null, "단어가 삭제 되었습니다.(중복시 1개만 제거)");
				}else
					JOptionPane.showMessageDialog(null, "현재 목록에는 입력하신 단어가 없습니다.");
			}
		});

		add(btn1);
		add(btn2);
		add(txt1);

	}

	// 화면전환 리스너 메서드
	public ActionListener addListener(int num) {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel nextPanel = MainFrame.panels[num];
				MyUtill.changePanel(parent, DeletePanel.this, nextPanel);
			}
		};
		return listener;
	}

	// 백그라운드이미지 메서드 오버라이딩
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
