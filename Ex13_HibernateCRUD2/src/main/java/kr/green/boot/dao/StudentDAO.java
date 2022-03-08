package kr.green.boot.dao;

import java.util.List;

import kr.green.boot.vo.StudentVO;

public interface StudentDAO {
	// 1. 저장
	void insert(StudentVO studentVO);
	// 2. 모두 보기
	List<StudentVO> selectList();
	
	// 3. 1개보기
	StudentVO selectByIdx(int id);
	// 4. 수정
	void update(StudentVO studentVO);
	// 5. 삭제
	void delete(int id);
}
