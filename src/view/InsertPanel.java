package view;

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

public class InsertPanel extends JPanel{
	private JFrame parent;
	private EngController controller = new EngController();
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private BufferedImage image;
	
	
	public InsertPanel(JFrame parent) {
		this.parent = parent;
		//백그라운드 이미지 그려주기
		try {
			image = ImageIO.read(new File("images/add.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// null레이아웃
		setLayout(null);
		
		//component setting
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

		//화면전환 리스너
		btn1.addActionListener(addListener(1));
		//추가버튼 기능 구현 리스너
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
				List<Eng> list = new EngController().loadEngList();
				System.out.println("Insert패널 단어 추가됨");
				System.out.println("list size : "+list.size());
				System.out.println("list : "+list);
				JOptionPane.showMessageDialog(null, "단어 추가가 완료되었습니다.");
			}
		});

		add(btn1);
		add(btn2);
		add(txt1);
		add(txt2);
		add(txt3);

	}
	
	//화면전환 리스너
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
	
	//백그라운드 그려주기 메서드 오버라이딩
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
