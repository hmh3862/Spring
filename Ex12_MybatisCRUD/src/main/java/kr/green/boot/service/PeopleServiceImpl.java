package kr.green.boot.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.boot.dao.PeopleDAO;
import kr.green.boot.vo.PeopleVO;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService{

	@Autowired
	private PeopleDAO peopleDAO;

	@Override
	public PeopleVO selectByIdx(int id) {
		PeopleVO peopleVO = null;
		try {
			peopleVO = peopleDAO.selectByIdx(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peopleVO;
	}

	@Override
	public List<PeopleVO> selectList() {
		List<PeopleVO> list = null;
		try {
			list = peopleDAO.selectList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(PeopleVO peopleVO) {
		try {
			peopleDAO.insert(peopleVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(PeopleVO peopleVO) {
		try {
			peopleDAO.update(peopleVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			peopleDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}	}
	
	
}
