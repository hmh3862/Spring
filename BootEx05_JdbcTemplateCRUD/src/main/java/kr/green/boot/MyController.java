package kr.green.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.boot.dao.PeopleDAO;
import kr.green.boot.service.PeopleService;
import kr.green.boot.vo.PeopleVO;

@RestController
public class MyController {

	@Autowired
	PeopleService peopleService;
	
	@Autowired
	PeopleDAO peopleDAO;
	
	@RequestMapping(value = "/rest/list")
	public List<PeopleVO> selectList(){
		return peopleService.selectList();
	}
	
//	@RequestMapping(value = "/rest/selectByIdx")
//  public PeopleVO selectByIdx(@RequestParam int id) { // /rest/selectByIdx?id=3
//     return peopleDAO.selectByIdx(id);
//  }
	
	@RequestMapping(value = "/rest/selectByIdx/{id}")
	public PeopleVO selectByIdx(@PathVariable String id){ // /rest/selectByIdx/3
		return peopleDAO.selectByIdx(Integer.parseInt(id));
	}
}
