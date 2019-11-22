package emartscan.emart.com.repositories;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import emartscan.emart.com.model.Test;

@Repository
public class TestRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
    public void selectById(Test test) {
        this.sqlSession.selectOne("selectById", test);
    }
    public List<Test> selectAll() {
        return this.sqlSession.selectList("selectAll");
    }
}
