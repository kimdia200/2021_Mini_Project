package view;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.EngController;
import util.MyUtill;
import vo.Eng;

public class StudyPanel extends JPanel {

	private JFrame parent;
	private JLabel txt1;
	private JLabel txt2;
	private JLabel txt3;
	private List<Eng> list = MainFrame.list;
	int size = list.size();	
	int ran = (int)(Math.random()*size);
	private BufferedImage image;
	
	public StudyPanel(JFrame parent) {
		this.parent = parent;
		//백그라운드 이미지 그려주기
		try {
			image = ImageIO.read(new File("images/study.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// null레이아웃
		setLayout(null);
		
		//component setting
		JButton btn1 = new JButton("뒤로");
		JButton btn2 = new JButton("next");
		txt1 = new JLabel();
		txt2 = new JLabel();
		txt3 = new JLabel();
		
		//component내용 새로채워주기
		reload();

		btn1.setBounds(265, 0, 60, 45);
		btn2.setBounds(135, 400, 60, 45);
		txt1.setBounds(73, 260, 180, 45);
		txt2.setBounds(73, 310, 180, 45);
		txt3.setBounds(73, 360, 180, 45);
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt3.setHorizontalAlignment(SwingConstants.CENTER);
		Font font1 = new Font("HY견고딕", Font.BOLD, 27);
		txt1.setFont(font1);
		Font font2 = new Font("HY견고딕", Font.PLAIN, 20);
		txt2.setFont(font2);
		txt1.setForeground(Color.white);
		txt2.setForeground(Color.white);
		txt3.setForeground(Color.white);

		//화면전환 리스너
		btn1.addActionListener(addListener(0));
		//next버튼 기능구현 리스너
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reload();
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
				MyUtill.changePanel(parent, StudyPanel.this, nextPanel);
				reload();
			}
		};
		return listener;
	}
	public void reload() {
		list=new EngController().loadEngList();
		size=list.size();
		ran = (int)(Math.random()*size);
		if(list.size()!=0) {
			txt1.setText(list.get(ran).getWord());
			txt2.setText(list.get(ran).getMeaning());
			txt3.setText(list.get(ran).getSentence());
		}else {
			JPanel nextPanel = MainFrame.panels[0];
			MyUtill.changePanel(parent, StudyPanel.this, nextPanel);
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
