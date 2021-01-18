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
	
	//IO에서 파일을 읽어와 List<Eng>로 리턴
	public List<Eng> loadEngList(){
		return io.loadEngList();
	}
	
	//Io에서 수정된내용을 List<Eng> 타입으로 전달해 수정내용 저장
	public void modifyList(List<Eng> list) {
		io.modifyList(list);
	}
}
