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

public class InsertPanel extends JPanel{
	private JFrame parent;
	private EngController controller = new EngController();
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private BufferedImage image;
	
	
	public InsertPanel(JFrame parent) {
		this.parent = parent;
		try {
			image = ImageIO.read(new File("images/add.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// null레이
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		JButton btn1 = new JButton("뒤로");
		JButton btn2 = new JButton("추가");
		txt1 = new JTextField("영단어");
		txt2 = new JTextField("영단어 뜻");
		txt3 = new JTextField("영단어 예문");

		btn1.setBounds(265, 0, 60, 45);
		btn2.setBounds(265, 300, 60, 45);
		txt1.setBounds(73, 250, 180, 45);
		txt2.setBounds(73, 300, 180, 45);
		txt3.setBounds(73, 350, 180, 45);

		btn1.addActionListener(addListener(1));
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String word = txt1.getText();
				String meaning = txt2.getText();
				String sentence = txt3.getText();
				controller.insertList(new Eng(word, meaning, sentence));
				txt1.setText("영단어");
				txt2.setText("영단어 뜻");
				txt3.setText("영단어 예문");
				JOptionPane.showMessageDialog(null, "단어 추가가 완료되었습니다.");
				System.out.println(new EngController().loadEngList());
			}
		});

		add(btn1);
		add(btn2);
		add(txt1);
		add(txt2);
		add(txt3);

	}
	public ActionListener addListener(int num){
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel nextPanel = MainFrame.panels[num];
				MyUtill.changePanel(parent, InsertPanel.this, nextPanel);
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
