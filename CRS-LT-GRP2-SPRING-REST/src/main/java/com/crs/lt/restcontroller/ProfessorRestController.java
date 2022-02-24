package com.crs.lt.restcontroller;

import com.crs.lt.dao.AdminDaoImplementation;
import com.crs.lt.dao.ProfessorDao;
import com.crs.lt.dao.ProfessorDaoImplementation;
import com.crs.lt.model.Course;
import com.crs.lt.model.EnrolledStudent;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestController
@CrossOrigin
@RequestMapping("/api/professor")
public class ProfessorRestController {

    private static final Logger LOGGER = getLogger(AdminRestController.class);

    @Autowired
    private ProfessorDao professorDao;

    @PutMapping("/add-grade/{studentId}/{courseCode}/{grade}")
    public @ResponseBody  String addGrade(@PathVariable  int studentId,@PathVariable  String courseCode,@PathVariable String grade) throws SQLException{
        Boolean gradeAdded = false ;
        try {
            gradeAdded = professorDao.addGrade(studentId, courseCode, grade);
        } catch (Exception e){
            LOGGER.error("Unable to add Grade");
        }
        if (gradeAdded){
            return "Grade successfully added";
        }
        return "Unable to add the grade";
    };
    @GetMapping("/{profId}/get-courses")
    public @ResponseBody  List<Course> getCourses(@PathVariable  int profId) throws SQLException{
        List<Course> courses = new ArrayList<Course>();
        try {
            courses = professorDao.getCoursesByProfessorId(profId);
        } catch (Exception e){
            LOGGER.error("Unable to get Courses");
        }
        return courses;
    };

    @GetMapping("/{profId}/view-enrolled-students")
    public @ResponseBody  List<EnrolledStudent> viewEnrolledStudents(@PathVariable int profId) throws SQLException{
        List<EnrolledStudent> enrolledStudents = new ArrayList<>();
        try {
            enrolledStudents = professorDao.getEnrolledStudents(profId);
        } catch (Exception e){
            LOGGER.error("Unable to get enrolled students");
        }
        return  enrolledStudents;
    };


}
