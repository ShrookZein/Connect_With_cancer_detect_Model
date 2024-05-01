package com.global.cancer_detect.config;

import com.global.cancer_detect.Entity.RoleModel;
import com.global.cancer_detect.Entity.User;
import com.global.cancer_detect.service.RoleService;
import com.global.cancer_detect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {
    private final UserService userService;

    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {


        if (roleService.findAll().isEmpty()) {
            roleService.save(new RoleModel(null, "admin"));
            roleService.save(new RoleModel(null, "user"));
            roleService.save(new RoleModel(null, "doctor"));
        }


        if (userService.findAll().isEmpty()) {

            Set<RoleModel> adminRoles = new HashSet<>();
            adminRoles.add(roleService.findByName("admin"));

            Set<RoleModel> userRoles = new HashSet<>();
            userRoles.add(roleService.findByName("user"));

            Set<RoleModel>  doctorRoles = new HashSet<>();
            doctorRoles.add(roleService.findByName("doctor"));

            userService.save(new User((Long) null, "Nour","Shaheen", "nour@gmail.com", "12345678",null, null,"Egypt",null,null,adminRoles,true,true,true,true));

            userService.save(new User(null, "Ali","Mohamed", "ali@gmail.com", "12345678",null,null,null,null, null,userRoles,true,true,true,true));

            userService.save(new User(null, "Shrook","Zein", "srouk7007@gmail.com", "12345678","http://localhost:8080/uploads/1.jpg",4.0,"Egypt","fhhfdjfjdghdghjj", null,doctorRoles,true,true,true,true));
            userService.save(new User(null, "Maha","Gaber", "Maha20@gmail.com", "12345678","http://localhost:8080/uploads/2.jpg",5.0,"Egypt","hdhfhhdhfhdhfhhdjxjsjd", null,doctorRoles,true,true,true,true));
            userService.save(new User(null, "Noha","Zein", "Noha@gmail.com", "12345678","http://localhost:8080/uploads/3.jpg",4.5,"Egypt","kjdfvjfjsfkjvhskfhvksfhks", null,doctorRoles,true,true,true,true));
            userService.save(new User(null, "Mohamed","Maher", "mohamed20@gmail.com", "123456789","http://localhost:8080/uploads/4.jpg",5.0,"Egypt","sdfjsargfjwrgfrkjrfsfnnnfdnnf", null,doctorRoles,true,true,true,true));
        }

    }
}
