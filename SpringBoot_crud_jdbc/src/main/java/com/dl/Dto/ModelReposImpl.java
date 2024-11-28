package com.dl.Dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dl.model.Model;
@Repository
public class ModelReposImpl implements ModelRepos{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	private static final String INSERT_MODEL_QUERY="INSERT INTO MODEL(id,fname,lname,email) values(?,?,?,?)";
	private static final String UPDATE_MODEL_BY_ID_QUERY="UPDATE MODEL SET fname=?,lname=? WHERE ID=?";
	private static final String GET_MODEL_BY_ID_QUERY = "SELECT * FROM MODEL WHERE id = ?";
	private static final String DELETE_MODEL_BY_ID="DELETE FROM MODEL WHERE id=?";
	private static final String GET_MODEL_QUERY="SELECT * FROM MODEL";
 	
	
	
	
	
	
	@Override
	public Model saveModel(Model model) {
		jdbcTemplate.update(INSERT_MODEL_QUERY,model.getId(),model.getFname(),model.getLname(),model.getEmail());
		return model;
	}

	@Override
	public Model updateModel(Model model) {
		jdbcTemplate.update(UPDATE_MODEL_BY_ID_QUERY, model.getFname(),model.getLname(),model.getId());
		return model;
	}

	@Override
	public Model getById(int id) {
		
		return jdbcTemplate.queryForObject(GET_MODEL_BY_ID_QUERY, (rs, rowNum) ->{
			return new  Model(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"));
		},id );
	}

	@Override
	public List<Model> getAllModel() {
		
		return jdbcTemplate.query(GET_MODEL_QUERY,(rs, rowNum) -> {
			return new  Model(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"));
		});
	}
	

	@Override
	public String deleteById(int id) {
		jdbcTemplate.update(DELETE_MODEL_BY_ID, id);
		
		return "Model get delete with id:"+id;
	}

}
