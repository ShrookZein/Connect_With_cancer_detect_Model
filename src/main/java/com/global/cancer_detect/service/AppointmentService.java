package com.global.cancer_detect.service;

import com.global.cancer_detect.Entity.AppointmentModel;
import com.global.cancer_detect.Entity.User;
import com.global.cancer_detect.repository.AppointmentRepo;
import com.global.cancer_detect.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private UserService userService;
    public ResponseEntity<List<AppointmentModel>> findAllAppointmentByDoctorId(Long id){
        return ResponseEntity.ok(appointmentRepo.findByUserId(id));
    }
    public ResponseEntity<List<AppointmentModel>> findAllAppointments(){
        return ResponseEntity.ok(appointmentRepo.findAll());
    }
    public ResponseEntity<AppointmentModel> findAppointmentByid(Long id){
        return ResponseEntity.ok(appointmentRepo.getById(id));
    }
    public ResponseEntity<AppointmentModel> saveAppointment(String day,String date,Boolean cancle,Boolean confirmed,String fromm,String too,Long userId,Long doctorId){
        User user =userService.findById(userId);
        System.out.println(user);
        User doctor= userService.findById(doctorId);
        System.out.println(doctor);
        Set<User>appointUserAndDoctor=new HashSet<>();
        appointUserAndDoctor.add(user);
        appointUserAndDoctor.add(doctor);
        Set<AppointmentModel>appointmentModels=new HashSet<>();
        AppointmentModel appointmentModel1=new AppointmentModel(null,day,date,cancle,confirmed,fromm,too,appointUserAndDoctor);
//        AppointmentModel appointmentModel2= appointmentRepo.save(appointmentModel1);
//        appointmentRepo.save(appointmentModel1);
//        appointmentModels.add(appointmentRepo.getById());
//        user.setAppointments(appointmentModels);
//        doctor.setAppointments(appointmentModels);
//        userService.save(user);
//        userService.save(doctor);
//        System.out.println(user);
//        return ResponseEntity.ok(appointmentRepo.getById(appointmentModel2.getId()));
        return ResponseEntity.ok(appointmentRepo.save(appointmentModel1));
    }

}
