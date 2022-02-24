package com.crs.lt.restcontroller;

import com.crs.lt.dao.AdminDaoImplementation;
import com.crs.lt.model.Course;
import com.crs.lt.model.Professor;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static org.apache.logging.log4j.LogManager.getLogger;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminRestController {

    private static final Logger LOGGER = getLogger(AdminRestController.class);

    @Autowired
    private AdminDaoImplementation adminDao;

    /**
     * Api for retreiving the list of courses
     * @return List of Courses
     * @throws SQLException
     */
    @GetMapping("/view-course")
    public @ResponseBody
    List<Course> viewCoursesByCatalogId() throws SQLException {
        List<Course> courses = new ArrayList<Course>();
        try {
            courses = adminDao.viewCoursesByCatalogId();
        } catch (Exception e){
            e.printStackTrace();
            LOGGER.error("Unable to view Courses");
        }
        return courses;
    }

    /** Api for deleting course based on courseCode
     * @param courseCode
     */
    @DeleteMapping("/delete-course/{courseCode}")
    public String deleteCourse(@PathVariable String courseCode) {
        try {
            adminDao.deleteCourse(courseCode);
            return "Course Successfully deleted";
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to delete Course ");
        }
        return "Unable to delete course";
    }

    /**
     * Api or adding course
     * @param course Object
     * @return
     */
    @PostMapping("/add-course")
    public @ResponseBody String addCourse(@RequestBody  Course course) {
        try {
            adminDao.addCourse(course);
            return  "Course Successfully added";
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to add Course");
        }
        return "Course can't be added";
    }

    /**
     * @param professor object
     * @return
     */
    @PutMapping("/add-professor")
    public @ResponseBody String addProfessor(@RequestBody Professor professor) {
        try {
            adminDao.addProfessor(professor);
            System.out.println("Professor Successfully added");
            return "Added professor successfully";
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to add professor");
        }
        return "Unable to add professor";
    }

    /**
     * @param studentId
     */
    @PutMapping("/approve-student/{studentId}")
    public void approveStudent(@PathVariable int studentId) {
        try {
            adminDao.approveStudent(studentId);
            System.out.println("Student is Successfully approved");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Student is not approved");
        }
    }

    /**
     * @param professorId
     * @param courseCode
     */
    @PutMapping("/assign-course/{professorId}")
    public void assignCourse(@PathVariable String professorId, String courseCode) {
        try {
            adminDao.assignCourse(professorId, courseCode);
            System.out.println("Course Successfully Assigned");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Professor can't be assigned to given course");
        }
    }

}
