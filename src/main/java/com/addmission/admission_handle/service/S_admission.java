package com.addmission.admission_handle.service;

import com.addmission.admission_handle.model.M_admission;

import java.util.List;


public interface S_admission {
    List<M_admission> getAllAdmission();
    void saveAdmission(M_admission m_admission);
    M_admission getStudentById(Long id);
    void updateAdmission(M_admission m_admission);
    void deleteAdmissionById(Long id);
}
