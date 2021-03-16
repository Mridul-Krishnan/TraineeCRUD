/**
 * 
 */
package com.trainee.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.app.entity.Bsunit;
import com.trainee.app.entity.Trainee;
import com.trainee.app.service.TraineeServiceImpl;

/**
 * @author Mri scan
 *
 */
//cool stuff
@RestController
@RequestMapping("/trainee")
public class TraineeController { //http://localhost:8080/trainee/getTrainee/1001
	
	@Autowired
	TraineeServiceImpl service;
	@RequestMapping("/getTrainee/{tid}")
	public Optional<Trainee> getTraineeById(@PathVariable("tid") int traineeId)
	{
		return service.getTraineeById(traineeId);
	}
	
	@RequestMapping("/getTrainee/all")
	public List<Trainee> showTrainee()
	{
		return service.showTrainee();
	}
	
	@PostMapping("/addTrainee")
	public int addTrainee(@RequestBody Trainee trainee) {
		service.addTrainee(trainee);
		return trainee.getTraineeId();
	}
	
	@PutMapping("/updateTrainee")
	public int updateTrainee(@RequestBody Trainee trainee) {
		service.updateTrainee(trainee);
		return trainee.getTraineeId();
	}
	
	@DeleteMapping("/deleteTrainee/{tid}")
	public String updateTrainee(@PathVariable("tid") int traineeId) {
		Optional<Trainee> trainee = service.getTraineeById(traineeId);
		service.removeTrainee(traineeId);
		return "Deleted:\n" + trainee;
	}
	
	@GetMapping("/getMin")
	public Collection<Trainee> getMin()
	{
		return service.getMin();
	}
	
	@GetMapping("/getTraineeBatch/{traineeBatch}")
	public List<Trainee> findByTraineeBatch(@PathVariable("traineeBatch") String traineeBatch)
	{
		return service.findByTraineeBatch(traineeBatch);
	}
	
	@GetMapping("/getBetweenId/{id1}/{id2}")
	public List<Trainee> findByTraineeIdBetween(@PathVariable("id1") int id1, @PathVariable("id2") int id2)
	{
		return service.findByTraineeIdBetween(id1,id2);
	}
	
	@PostMapping("/addBsunit")
	public String addBsunit(Bsunit bsunit)
	{
		service.addBsunit(bsunit);
		return "Added:\n" + bsunit;
	}
	
	@GetMapping("/showBsunit")
	public List<Bsunit> showBsunit()
	{
		return service.showBsunit();
	}
	
}
