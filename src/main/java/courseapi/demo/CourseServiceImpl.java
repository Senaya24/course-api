package courseapi.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Override
    public Course update(String id, Course course) {
        Course existing = getById(id);
        existing.setTitle(course.getTitle());
        existing.setCredits(course.getCredits());
        existing.setDepartment(course.getDepartment());
        return courseRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        courseRepository.deleteById(id);
    }
}