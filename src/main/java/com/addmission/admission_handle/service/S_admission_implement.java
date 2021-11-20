package com.addmission.admission_handle.service;

import com.addmission.admission_handle.model.M_admission;
import com.addmission.admission_handle.repository.R_admission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_admission_implement implements S_admission{

    private R_admission r_admission;    //we use only one parameterised constructor that's why we don't need to add @autowired

    public S_admission_implement(R_admission r_admission) {
        this.r_admission = r_admission;
    }

    @Override
    public List<M_admission> getAllAdmission() {
        return r_admission.findAll();
    }

    @Override
    public M_admission saveAdmission(M_admission m_admission) {
        return r_admission.save(m_admission);
    }

    @Override
    public M_admission getStudentById(Long id) {
        return r_admission.findById(id).get();
    }

    @Override
    public M_admission updateAdmission(M_admission m_admission) {
        return r_admission.save(m_admission);
    }
}
