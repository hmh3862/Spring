package kr.green.boot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.green.boot.vo.PeopleVO;

@Repository("peopleDAO")
public class PeopleDAOImpl implements PeopleDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	@Override
	public PeopleVO selectByIdx(int idx) {
		return jdbcTemplate.queryForObject("select * from people where id=?", new Object[] {idx}, new PeopleMapper());
	}

	@Override
	public List<PeopleVO> selectAll() {
		return jdbcTemplate.query("select * from people order by id desc", new PeopleMapper());
	}

	@Override
	public boolean insert(PeopleVO peopleVO) {
		return jdbcTemplate.update("insert into people values (?,?,?,?)",
				                   peopleVO.getId(), peopleVO.getFirstName(),peopleVO.getLastName(),peopleVO.getAge())>0;
	}

	@Override
	public boolean update(PeopleVO peopleVO) {
		return jdbcTemplate.update("update people set first_name=?, last_name=?, age=? where id=?", 
				                    peopleVO.getFirstName(),peopleVO.getLastName(),peopleVO.getAge(), peopleVO.getId())>0;
	}

	@Override
	public boolean delete(PeopleVO peopleVO) {
		return jdbcTemplate.update("delete from people where id=?", peopleVO.getId())>0;
	}
	
}
