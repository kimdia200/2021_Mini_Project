package controller;

import java.util.List;

import io.EngIO;
import vo.Eng;

public class EngController {
	private EngIO io = new EngIO();
	
	//컨트롤러 !!여러개 입력준비완료
	
	//IO에서 값을 추가후 파일로 저장
	public void insertList(Eng eng) {
		io.insertList(eng);
	}
	
	//IO에서 값을 제거후 파일로 저장
	public void deleteList(Eng eng) {
		io.deleteList(eng);
	}
	
	//IO에서 파일을 읽어와 보내줌
	public List<Eng> loadEngList(){
		return io.loadEngList();
	}
	
	public void modifyList(List<Eng> list) {
		io.modifyList(list);
	}
}
