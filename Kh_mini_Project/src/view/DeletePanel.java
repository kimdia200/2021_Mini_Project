package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	JTextField txt1;
	private BufferedImage image;
	
	public DeletePanel(JFrame parent) {
		this.parent = parent;
		try {
			image = ImageIO.read(new File("images/delete.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// null레이
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		JButton btn1 = new JButton("뒤로");
		JButton btn2 = new JButton("삭제");
		txt1 = new JTextField("영단어");

		btn1.setBounds(265, 0, 60, 45);
		btn2.setBounds(260, 250, 60, 45);
		txt1.setBounds(50, 250, 200, 45);

		btn1.addActionListener(addListener(1));
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = txt1.getText();
				
				controller.deleteList(new Eng(word,"",""));
				JOptionPane.showMessageDialog(null, "단어가 삭제 되었습니다.(중복시 1개만 제거)");
				txt1.setText("영단어");
				System.out.println(new EngController().loadEngList());
			}
		});

		add(btn1);
		add(btn2);
		add(txt1);

	}

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
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
