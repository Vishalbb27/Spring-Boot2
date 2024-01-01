package com.example.MycoolApp;

import com.example.MycoolApp.student.StudentDAO;
import com.example.MycoolApp.student.StudentEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		scanBasePackages = {"com.example"}
)
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			
			//createMultipleStudent(studentDAO);

			//System.out.println(studentDAO.findById(1));

			//System.out.println(studentDAO.findAll());

			//System.out.println(studentDAO.findByLastName("Doe"));

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all student");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted Row Count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		StudentEntity student = studentDAO.findById(1);
		student.setLastName("Jacob");

		studentDAO.update(student);


	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		StudentEntity tempStudent1 = new StudentEntity("John","Doe");
		StudentEntity tempStudent2 = new StudentEntity("Mary","Doe");
		StudentEntity tempStudent3 = new StudentEntity("Smith","Doe");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println(("Saving the students..."));
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");

		StudentEntity tempStudent = new StudentEntity("Doe","John");
		//save th student object
		System.out.println("Saving the student ....");

		studentDAO.save((tempStudent));
		//display id of the saved student
		System.out.print("Saved student. Generated id: " + tempStudent.getId());
	}
}
