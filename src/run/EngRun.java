package run;

import java.util.List;

import io.EngIO;
import view.MainFrame;
import vo.Eng;

public class EngRun {
	public static void main(String[] args) {
		//메인 화면으로 연결
		new MainFrame(330, 500, "자기전에 영단어").setVisible(true);
		
		//시작할때 현재 저장된 객체 갯수, 내용 확인하기위함
		EngIO io = new EngIO();
		List<Eng> list = io.loadEngList();
		System.out.println(list.size());
		System.out.println(list);
	}
}