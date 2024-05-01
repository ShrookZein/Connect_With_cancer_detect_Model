package com.global.cancer_detect.Controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.global.cancer_detect.Entity.AppointmentModel;
import com.global.cancer_detect.Entity.User;
import com.global.cancer_detect.repository.AppointmentRepo;
import com.global.cancer_detect.repository.UserRepo;
import com.global.cancer_detect.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
//اشغلو لما ارن الفرونت
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@NoArgsConstructor
public class ApoointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/userId/{id}")
    public ResponseEntity<List<AppointmentModel>>findAllAppointmentByDoctorId(@PathVariable Long id){
        return appointmentService.findAllAppointmentByDoctorId(id);
    }
    @GetMapping()
    public ResponseEntity<List<AppointmentModel>>findAllAppointments(){
//        List<AppointmentModel>appointmentModels=appointmentService.findAllAppointments().getBody();
        return appointmentService.findAllAppointments();
    //        return appointmentService.findAllAppointmentByDoctorId(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentModel>findAppointmentById(@PathVariable Long id){
//        List<AppointmentModel>appointmentModels=appointmentService.findAllAppointments().getBody();
        return appointmentService.findAppointmentByid(id);
        //        return appointmentService.findAllAppointmentByDoctorId(id);
    }
    @PostMapping()
    public ResponseEntity<AppointmentModel>saveAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO){
        return appointmentService.saveAppointment(appointmentRequestDTO.getDay(),appointmentRequestDTO.getDate(),appointmentRequestDTO.getFromm(),appointmentRequestDTO.getToo(),appointmentRequestDTO.getUserId(),appointmentRequestDTO.getDoctorId());
    }
    @PutMapping("/cancle/{id}")
    public ResponseEntity<AppointmentModel>saveAppointmentCancle(@PathVariable Long id){
        return appointmentService.cancelAppointmentByid(id);
    }
    @PutMapping("/confirm/{id}")
    public ResponseEntity<AppointmentModel>saveAppointmentConfirm(@PathVariable Long id){
        return appointmentService.confirmAppointmentByid(id);
    }
}
