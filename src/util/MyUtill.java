package util;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyUtill {
	public static void init(JFrame f, int width, int height, String title) {
		f.setTitle(title);
		f.setSize(width,height);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void changePanel(JFrame parent, JPanel current, JPanel next) {
		parent.remove(current);
		parent.add(next);
		parent.revalidate(); //container 하위 계층 구조를 새로고침
		parent.repaint(); //화면 다시 그리기
		
	}
	
}
