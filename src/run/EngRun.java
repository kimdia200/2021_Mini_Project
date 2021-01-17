package run;

import java.util.List;

import io.EngIO;
import view.MainFrame;
import vo.Eng;

public class EngRun {
	public static void main(String[] args) {
		//메인 화면으로 연결
		new MainFrame(330, 500, "자기전에 영단어").setVisible(true);
		
		EngIO io = new EngIO();
		List<Eng> list = io.loadEngList();
		System.out.println(list.size());
		System.out.println(list);
	}
}