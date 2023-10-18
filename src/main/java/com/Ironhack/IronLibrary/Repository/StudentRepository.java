package com.Ironhack.IronLibrary.Repository;

import com.Ironhack.IronLibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {


}
