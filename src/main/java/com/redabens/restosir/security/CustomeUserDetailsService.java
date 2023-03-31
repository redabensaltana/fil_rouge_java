package com.redabens.restosir.security;

import com.redabens.restosir.entities.Chef;
import com.redabens.restosir.entities.Manager;
import com.redabens.restosir.entities.Waiter;
import com.redabens.restosir.repositories.ChefRepo;
import com.redabens.restosir.repositories.ManagerRepo;
import com.redabens.restosir.repositories.WaiterRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    private ChefRepo chefRepo;
    private WaiterRepo waiterRepo;
    private ManagerRepo managerRepo;

    public CustomeUserDetailsService(ChefRepo chefRepo,WaiterRepo waiterRepo,ManagerRepo managerRepo) {
        this.chefRepo = chefRepo;
        this.waiterRepo = waiterRepo;
        this.managerRepo = managerRepo;
    }


    public UserDetails loadUserByUsername(String email,String role) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (role.equals("waiter")) {
            Waiter waiter = waiterRepo.findByEmail(email);
            authorities.add((new SimpleGrantedAuthority("Waiter")));
            return new User(waiter.getEmail(), waiter.getPassword(), authorities);
        } else if (role.equals("chef")) {
            Chef chef = chefRepo.findByEmail(email);
            authorities.add((new SimpleGrantedAuthority("Chef")));
            return new User(chef.getEmail(), chef.getPassword(), authorities);
        } else if (role.equals("manager")) {
            Manager manager = managerRepo.findByEmail(email);
            authorities.add((new SimpleGrantedAuthority("Manager")));
            return new User(manager.getEmail(), manager.getPassword(), authorities);
        }
        return null;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
