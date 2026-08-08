package courseapi.demo;

import java.util.List;

public interface CourseService {
    Course save(Course course);
    List<Course> getAll();
    Course getById(String id);
    Course update(String id, Course course);
    void delete(String id);
}
