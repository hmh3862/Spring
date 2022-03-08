package kr.green.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.boot.dao.StudentDAO;
import kr.green.boot.vo.StudentVO;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void insert(StudentVO studentVO) {
		studentDAO.insert(studentVO);
	}

	@Override
	public List<StudentVO> selectList() {
		return studentDAO.selectList();
	}

	@Override
	public StudentVO selectByIdx(int id) {
		return studentDAO.selectByIdx(id);
	}

	@Override
	public void update(StudentVO studentVO) {
		studentDAO.update(studentVO);
	}

	@Override
	public void delete(int id) {
		studentDAO.delete(id);
	}
}
