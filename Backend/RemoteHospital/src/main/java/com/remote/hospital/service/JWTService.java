package com.remote.hospital.service;



import com.remote.hospital.entity.Hospital;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.HospitalRepository;
import com.remote.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Service
public class JWTService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmailAddress(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),true,true,true,true, Collections.singleton(getAuthority(user)));
    }

    public  UserDetails loadHospitalByEmail(String email){
        Hospital hospital = hospitalRepository.findByEmail(email);
        System.out.println(hospital);
        if (hospital == null){
            throw new UsernameNotFoundException("Hospital Not Found with email "+ email);
        }
      return new org.springframework.security.core.userdetails.User(hospital.getEmail(), hospital.getPassword(),true,true,true,true, Collections.singleton(getHospitalAuthority(hospital)));
    }

    private SimpleGrantedAuthority getAuthority(User user) {
        if (user.getRole() == null) {
            return new SimpleGrantedAuthority("ROLE_USER");
        } else {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
            return authority;
        }
    }

    private SimpleGrantedAuthority getHospitalAuthority(Hospital hospital) {

            return new SimpleGrantedAuthority("ROLE_HOSPITAL");

    }

    public Hospital saveHospital(Hospital h)
    {
        Hospital newHospital = new Hospital();
        newHospital.setImage(h.getImage());

        newHospital.setCreatedOn(h.getCreatedOn());
        newHospital.setActive(false);
        newHospital.setDoctorHospitals(h.getDoctorHospitals());
        newHospital.setEmail(h.getEmail());
        newHospital.setAccountManagerName(h.getAccountManagerName());
        newHospital.setClosingTime(h.getClosingTime());
        newHospital.setOpeningTime(h.getOpeningTime());
        newHospital.setHospitalRegistrationId(h.getHospitalRegistrationId());
        newHospital.setLocation(h.getLocation());
        newHospital.setPhoneNumber(h.getPhoneNumber());
        newHospital.setType(h.getType());
        newHospital.setUpdatedBy(h.getUpdatedBy());
        newHospital.setUpdatedOn(h.getUpdatedOn());
        newHospital.setName(h.getName());
        newHospital.setPassword(bcryptEncoder.encode(h.getPassword()));
        return hospitalRepository.save(newHospital);
    }
    public User save(User user) {
        User newUser = new User();
        newUser.setUser_name(user.getUser_name());
        newUser.setPhone_number(user.getPhone_number());
        newUser.setEmailAddress(user.getEmailAddress());

        newUser.setBlood_group(user.getBlood_group());
        newUser.setCnic(user.getCnic());
        newUser.setAddress(user.getAddress());
        newUser.setDisplay_image(user.getDisplay_image());
        newUser.setGender(user.getGender());
        newUser.setDoctorHospitals(user.getDoctorHospitals());

        newUser.setRole(user.getRole());

        newUser.setCreated_on(new Date());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setCreated_by(Long.parseLong("0"));

        newUser.setActive(true);

        return userRepo.save(newUser);

    }

}
//
//        return authority;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.emptyList();
//    }}

