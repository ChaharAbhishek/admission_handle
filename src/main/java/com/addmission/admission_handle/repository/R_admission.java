package com.addmission.admission_handle.repository;

import com.addmission.admission_handle.model.M_admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface R_admission extends JpaRepository<M_admission, Long> {
}
