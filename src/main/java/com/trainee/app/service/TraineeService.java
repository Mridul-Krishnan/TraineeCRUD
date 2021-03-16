/**
 * 
 */
package com.trainee.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.trainee.app.entity.Trainee;

/**
 * @author Mri scan
 *
 */
public interface TraineeService {
	
	void addTrainee(Trainee trainee);
	void removeTrainee(int traineeId);
	void updateTrainee(Trainee trainee);
	Optional<Trainee> getTraineeById(int traineeId);
	List<Trainee> showTrainee();
	Collection<Trainee> getMin();
	List<Trainee> findByTraineeBatch(String traineeBatch);
	List<Trainee> findByTraineeIdBetween(int id1, int id2);
}
