package kr.green.boot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.green.boot.vo.StudentVO;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(StudentVO studentVO) {
		sessionFactory.openSession().save(studentVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentVO> selectList() {
		return sessionFactory.openSession().createCriteria(StudentVO.class).list();
	}

	@Override
	public StudentVO selectByIdx(int id) {
		return sessionFactory.openSession().find(StudentVO.class, id);
	}

	@Override
	public void update(StudentVO studentVO) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			StudentVO studentVO2 = session.get(StudentVO.class, studentVO.getId());
			studentVO2.setFirstName(studentVO.getFirstName());
			studentVO2.setLastName(studentVO.getLastName());
			studentVO2.setSection(studentVO.getSection());
			session.update(studentVO2);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			StudentVO studentVO = session.get(StudentVO.class,id);
			session.delete(studentVO);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
