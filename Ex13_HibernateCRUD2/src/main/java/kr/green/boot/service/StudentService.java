package kr.green.boot.service;

import java.util.List;

import kr.green.boot.vo.StudentVO;

public interface StudentService {
	void insert(StudentVO studentVO);
	List<StudentVO> selectList();
	// 3. 1개보기
	StudentVO selectByIdx(int id);
	// 4. 수정
	void update(StudentVO studentVO);
	// 5. 삭제
	void delete(int id);
}
