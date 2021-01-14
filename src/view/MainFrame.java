package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EngController;
import util.MyUtill;
import vo.Eng;

public class MainFrame extends JFrame {
	//배열크기 = 화면갯수;
	public static JPanel[] panels = new JPanel[6];
	public static List<Eng> list = new EngController().loadEngList();
	
	public MainFrame(int width, int height, String title) {
		MyUtill.init(this, width, height, title);
		panels[0] = new MainPanel(this); //메인 패널
		panels[1] = new TablePanel(this); //목록보기 패널
		panels[2] = new StudyPanel(this); //study 패널
		panels[3] = new TestPanel(this); //test 패널
		panels[4] = new InsertPanel(this); //추가 패널
		panels[5] = new DeletePanel(this); //삭제 패널
		setResizable(false); //사이즈 변경불가
		add(panels[0]); //메인 패널로 시작
	}
}