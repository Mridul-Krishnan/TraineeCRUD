/**
 * 
 */
package com.trainee.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.app.entity.Bsunit;
import com.trainee.app.entity.Trainee;
import com.trainee.app.repository.BsunitRepo;
import com.trainee.app.repository.TraineeRepo;

/**
 * @author Mri scan
 *
 */
@Service("service")
@Transactional
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeRepo dao;
	
	@Autowired
	BsunitRepo daob;
	
	@Override
	public void addTrainee(Trainee trainee) {
		dao.save(trainee);
	}
	@Override
	public void removeTrainee(int traineeId) {
		dao.deleteById(traineeId);
	}
	@Override
	public void updateTrainee(Trainee trainee) {
		dao.save(trainee);
	}
	@Override
	public Optional<Trainee> getTraineeById(int traineeId) {
		return dao.findById(traineeId);
	}
	@Override
	public List<Trainee> showTrainee() {
		return dao.findAll();
	}
	
	@Override
	public Collection<Trainee> getMin()
	{
		return dao.getMin();
	}
	
	@Override 
	public List<Trainee> findByTraineeBatch(String traineeBatch)
	{
		return dao.findByTraineeBatch(traineeBatch);
	}
	@Override
	public List<Trainee> findByTraineeIdBetween(int id1, int id2) {
		// TODO Auto-generated method stub
		return dao.findByTraineeIdBetween(id1,id2);
	}
	public void addBsunit(Bsunit bsunit) {
		// TODO Auto-generated method stub
		 daob.save(bsunit);
	}
	public List<Bsunit> showBsunit() {
		// TODO Auto-generated method stub
		return daob.findAll();
	}
}
