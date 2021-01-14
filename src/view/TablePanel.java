package view;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.EngController;
import util.MyUtill;
import vo.Eng;

public class TablePanel extends JPanel {
	private JFrame parent;
	private BufferedImage image;
	List<Eng> list = MainFrame.list;
	JScrollPane scrollPane = new JScrollPane();
	JTable table;
	DefaultTableModel model;

	public TablePanel(JFrame parent) {
		this.parent = parent;
		try {
			image = ImageIO.read(new File("images/main.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// null레이
		setBackground(Color.gray);
		setLayout(null);
		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("삭제");
		JButton btn3 = new JButton("뒤로");
		JButton btn4 = new JButton("새로고침");

		btn1.setBounds(145, 0, 60, 45);
		btn2.setBounds(205, 0, 60, 45);
		btn3.setBounds(265, 0, 60, 45);
		btn4.setBounds(0, 0, 145, 45);

		btn1.addActionListener(addListener(4));
		btn2.addActionListener(addListener(5));
		btn3.addActionListener(addListener(0));
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 테이블 새로고침
				reload();
				// 다시 화면 그려줌
				JPanel nextPanel = MainFrame.panels[1];
				MyUtill.changePanel(parent, TablePanel.this, nextPanel);

			}
		});

		// 330 500
		reload();
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);

	}

	public ActionListener addListener(int num) {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel nextPanel = MainFrame.panels[num];
				MyUtill.changePanel(parent, TablePanel.this, nextPanel);
			}
		};
		return listener;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public void reload() {
		remove(scrollPane);
		list = new EngController().loadEngList();
		// 윤지
		// 컬럼정보
		Object[] columnNames = { "단어", "뜻", "예문" };

		// 행 내용 입력
		Object[][] rowData = new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {
			Eng vc = list.get(i);
			rowData[i][0] = vc.getWord();
			rowData[i][1] = vc.getMeaning();
			rowData[i][2] = vc.getSentence();
		}
		model = new DefaultTableModel(rowData, columnNames);
		table = new JTable(model);

		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 45, 330, 425);
		add(scrollPane);
		//윤지
	}

}
