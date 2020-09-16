package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 @RestController
 public class MyClassController {
	 
	 @Autowired
	 MyClassRepository myClassRepository;
	 
	 /*@PostMapping(path="/myClasses/ssign")
	 public void checkSign(@RequestBody MyClass data) {
		 MyClass myClass = new MyClass();
		 
		 myClass.setClassName(data.getClassName());
		 myClass.setStudentId(data.getStudentId());
		 myClass.setStudentName(data.getStudentName());
		 myClass.setStatus("ClassApproved");
		 myClassRepository.save(myClass);
	 }*/
	 
	 @PostMapping(path="/myClasses/sc")
	 public void studentChange(@RequestBody MyClass data) {
		 MyClass myClass = new MyClass();
		 
		 myClass.setClassName(data.getClassName());
		 myClass.setStudentId(data.getStudentId());
		 myClass.setStudentName(data.getStudentName());
		 myClass.setStatus(data.getStatus());
		 myClassRepository.save(myClass);
	 }

 }
