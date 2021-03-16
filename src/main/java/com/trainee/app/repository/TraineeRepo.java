package com.trainee.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.trainee.app.entity.Bsunit;
import com.trainee.app.entity.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Integer> {

	
	@Query("select t from Trainee t where t.traineeBatch='React' ")
	Collection<Trainee> getMin();
	
	List<Trainee> findByTraineeBatch(String traineeBatch);

	List<Trainee> findByTraineeIdBetween(int id1, int id2);
}

