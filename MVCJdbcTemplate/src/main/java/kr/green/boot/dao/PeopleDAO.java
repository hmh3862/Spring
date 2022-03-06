package kr.green.boot.dao;

import java.util.List;

import kr.green.boot.vo.PeopleVO;

public interface PeopleDAO {
	// 1개 얻기
	PeopleVO selectByIdx(int idx);
	// 모두 얻기
	List<PeopleVO> selectAll();
	// 저장
	boolean insert(PeopleVO peopleVO);
	// 수정
	boolean update(PeopleVO peopleVO);
	// 삭제
	boolean delete(PeopleVO peopleVO);
}
