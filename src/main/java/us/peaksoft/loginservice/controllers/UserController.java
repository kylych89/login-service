package us.peaksoft.loginservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.peaksoft.loginservice.models.dto.UserDto;
import us.peaksoft.loginservice.services.UserService;

import java.util.List;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserDto saveUser(@RequestHeader("auth") String auth, @RequestBody UserDto userDto) {
        return userService.createUSer(auth, userDto);
    }

    @PutMapping("/save")
    public UserDto updateUser(@RequestHeader("auth") String auth, @RequestBody UserDto userDto) {
        return userService.updateUser(auth, userDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@RequestHeader("auth") String auth, @PathVariable Long id) {
        return userService.deactivateUser(auth, id);
    }

    @GetMapping("/get/{id}")
    public UserDto getUserById(@RequestHeader("auth") String auth, @PathVariable Long id) {
        return userService.findUserById(auth, id);
    }

    @GetMapping("/list")
    public List<UserDto> getAllUsers(@RequestHeader("auth") String auth) {
        return userService.findAllUsers(auth);
    }

}
