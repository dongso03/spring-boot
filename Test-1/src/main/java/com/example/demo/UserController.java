package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
	private List<User> allUsers;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers); // users라는 이름으로 사용자 목록을 모델에 추가
        return "user"; // user.jsp 파일과 일치하는 뷰 이름 반환
    }

//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable int id) {
//        return userService.getUserById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//    }
//
//    @PostMapping("/user")
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public void deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//    }
}
