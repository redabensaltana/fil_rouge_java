package com.redabens.restosir.controllers;


import com.redabens.restosir.dto.AuthResponseDto;
import com.redabens.restosir.dto.LoginDto;
import com.redabens.restosir.repositories.ChefRepo;
import com.redabens.restosir.repositories.ManagerRepo;
import com.redabens.restosir.repositories.WaiterRepo;
import com.redabens.restosir.security.JWTGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins="http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final ManagerRepo managerRepo;
    private final WaiterRepo waiterRepo;
    private final ChefRepo chefRepo;

//    private  PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;


    public AuthController(AuthenticationManager authenticationManager, ManagerRepo managerRepo, WaiterRepo waiterRepo,ChefRepo chefRepo,JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.managerRepo = managerRepo;
        this.waiterRepo = waiterRepo;
        this.chefRepo = chefRepo;
        this.jwtGenerator = jwtGenerator;

    }



    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        System.out.println("authentication = ");
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication,loginDto.getRole());
            if (loginDto.getRole().equals("Manager"))
                return new ResponseEntity<>(new AuthResponseDto(token,managerRepo.findByEmail(loginDto.getEmail()).getId()), HttpStatus.OK);
            else if (loginDto.getRole().equals("Waiter"))
                return new ResponseEntity<>(new AuthResponseDto(token,waiterRepo.findByEmail(loginDto.getEmail()).getId()), HttpStatus.OK);
            else if (loginDto.getRole().equals("Chef"))
                return new ResponseEntity<>(new AuthResponseDto(token,chefRepo.findByEmail(loginDto.getEmail()).getId()), HttpStatus.OK);
            else
                return null;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }



    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
//        if(personRepo.existsByEmail(registerDto.getEmail())){
//            return new ResponseEntity<>("Email is taken", HttpStatus.BAD_REQUEST);
//        }
//
//        Person person = new Person();
//        person.setEmail(registerDto.getEmail().toLowerCase());
//        person.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//        person.setLast_name(registerDto.getLast_name());
//        person.setFirst_name(registerDto.getFirst_name());
//        person.setPhone_number(registerDto.getPhone_number());
//        person.setAdresse(registerDto.getAdresse());
//        Roles role = roleRepo.findByName("User").get();
//        person.setRoles(Collections.singletonList(role));
//        personRepo.save(person);
//        return new ResponseEntity<>("User registred success",HttpStatus.OK);
//    }

    //test post method
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("test",HttpStatus.OK);
    }
}
