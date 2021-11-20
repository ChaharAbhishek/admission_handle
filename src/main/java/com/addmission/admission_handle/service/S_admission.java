package com.addmission.admission_handle.service;

import com.addmission.admission_handle.model.M_admission;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public interface S_admission {
    List<M_admission> getAllAdmission();
    M_admission saveAdmission(M_admission m_admission);
    M_admission getStudentById(Long id);
    M_admission updateAdmission(M_admission m_admission);
}
