package kr.green.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.boot.dao.PeopleDAO;
import kr.green.boot.vo.PeopleVO;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	PeopleDAO peopleDAO;

	@Override
	public List<PeopleVO> selectList() {
		return peopleDAO.selectAll();
	}

	@Override
	public boolean insert(PeopleVO peopleVO) {
		return peopleDAO.insert(peopleVO);
	}

	@Override
	public boolean update(PeopleVO peopleVO) {
		return peopleDAO.update(peopleVO);
	}

	@Override
	public boolean delete(PeopleVO peopleVO) {
		return peopleDAO.delete(peopleVO);
	}

}
