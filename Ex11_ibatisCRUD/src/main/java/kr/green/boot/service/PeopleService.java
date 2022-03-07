package kr.green.boot.service;

import java.util.List;

import kr.green.boot.vo.PeopleVO;

public interface PeopleService {
	PeopleVO selectByIdx(int id);
	List<PeopleVO> selectList();
	void insert(PeopleVO peopleVO);
	void update(PeopleVO peopleVO);
	void delete(int id);
}
