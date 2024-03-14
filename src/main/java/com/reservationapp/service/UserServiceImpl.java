package com.reservationapp.service;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.exception.ResourceNotFoundException;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    public UserRegistrationDto createUser(UserRegistration userRegistration){
        userRepository.save(userRegistration);
        return null;

    }


    public UserRegistration getUserById(long id) {
        return userRepository.findById(id).get();

    }

    public void deletUser(long id) {
        Optional<UserRegistration> byId = userRepository.findById(id);
        if (byId.isPresent()){
            userRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("User Not found with Id:"+id);
        }
    }

    public List<UserRegistrationDto> getAllUsers() {
        List<UserRegistration> listOfUsers = userRepository.findAll();
        List<UserRegistrationDto> allusers = listOfUsers.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
        return allusers;
    }

    UserRegistration mapToEntity(UserRegistrationDto userRegistrationDto){
        return modelMapper.map(userRegistrationDto, UserRegistration.class);
    }

    UserRegistrationDto mapToDto(UserRegistration userRegistration){
        return modelMapper.map(userRegistration, UserRegistrationDto.class);
    }

    public UserRegistrationDto updateUser(UserRegistrationDto userRegistrationDto, long id) {
        UserRegistration user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User Not found with id" + id)
        );
        UserRegistration mappeduser = mapToEntity(userRegistrationDto);
            mappeduser.setId(user.getId());
        UserRegistration saved = userRepository.save(mappeduser);
        UserRegistrationDto dtos = mapToDto(mappeduser);
        return dtos;
    }
}
