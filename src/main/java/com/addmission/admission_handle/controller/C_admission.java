package com.addmission.admission_handle.controller;

import com.addmission.admission_handle.model.M_admission;
import com.addmission.admission_handle.repository.R_admission;
import com.addmission.admission_handle.service.S_admission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController  //you cannnot use rest controller if you want to show html file o
public class C_admission {

    //insert----update----delete----show
    @Autowired
    private R_admission r_admission;

    //adding dependency
    private S_admission s_admission;
    public C_admission(S_admission s_admission) //constructor based depencency
    {
        this.s_admission = s_admission;
    }

    //insert
    //@RequestMapping(value = "/insert_admission",method = RequestMethod.POST)
    @PostMapping("/new_admission")
    public M_admission admission_insert(@RequestBody M_admission admissions)
    {
        r_admission.save(admissions);
        return admissions;
    }



    //show all admission
    @GetMapping("/all_admission")
    public ModelAndView show_admission()
    {
        ModelAndView modelAndView = new ModelAndView("admissionshow");
        modelAndView.addObject("admissions", s_admission.getAllAdmission());
        return modelAndView;
    }

    //new admission form
    @GetMapping("/admissions/new")
    public ModelAndView create_form()
    {
        ModelAndView modelAndView = new ModelAndView("newadmission");
        modelAndView.addObject("admissions",new M_admission());
        return modelAndView;
    }

    //save admission
    @PostMapping("/save_admission")
    public String saveStudent(@ModelAttribute("admissions") M_admission m_admission)
    {
        s_admission.saveAdmission(m_admission);
        return "redirect:/all_admission";
    }

    //edit details admission
    @GetMapping("/all_admission/edit/{id}")
    public ModelAndView updateAdmission(@PathVariable Long id)
    {
        ModelAndView modelAndView = new ModelAndView("edit_admission");
        modelAndView.addObject("admissions",s_admission.getStudentById(id));
        return modelAndView;
    }


    @PostMapping("/save_admission/{id}")
    public String updateAdmission(@PathVariable Long id, @ModelAttribute ("admissions") M_admission m_admission, Model model)
    {
        //get admission detail from database by id
        M_admission exitingadmission = s_admission.getStudentById(id);
        //exitingadmission.setRollno(id);
        exitingadmission.setName(m_admission.getName());
        exitingadmission.setAddress(m_admission.getAddress());
        exitingadmission.setPhoneno(m_admission.getPhoneno());
        exitingadmission.setCourseid(m_admission.getCourseid());
        exitingadmission.setDateofadmission(m_admission.getDateofadmission());
        exitingadmission.setRemark(m_admission.getRemark());

        //save updated data
        s_admission.updateAdmission(exitingadmission);
        return "redirect:/all_admissions";

    }



}
