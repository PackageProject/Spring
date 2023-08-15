package com.example.demo.api;

import com.example.demo.entity.Menu;
import com.example.demo.entity.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsersApiController {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersApiController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public Iterable<User> list() {
        return usersRepository.findAll();
    }

    @GetMapping("/{usersid}")
    public Optional<User> getMenuById(@PathVariable Long usersid) {
        return usersRepository.findById(usersid);
    }

    @PostMapping
    public User signUp(@RequestBody User user) {
        return usersRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam Long usersid) {
        Optional<User> optionalUser = usersRepository.findUsersByUsersid(usersid);
        if (optionalUser.isPresent()) {
            return "로그인 성공!";
        } else {
            return "로그인 실패 - 해당 사용자를 찾을 수 없습니다.";
        }
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        // 로그아웃 로직 처리
        return "로그아웃 성공!";
    }

    //닉네임 변경하는 코드(닉네임만)
    @PutMapping("/{usersid}")
    public User updatedUser(@PathVariable Long usersid, @RequestBody User updatedUser) {
        Optional<User> optionalUser = usersRepository.findById(usersid);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            //닉네임만 변경하는 경우니까
            user.setUsersnickname(updatedUser.getUsersnickname());
            return usersRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + usersid);
        }
    }


    @DeleteMapping("/{usersid}")
    public void deleteUser(@PathVariable Long usersid) {
        usersRepository.deleteById(usersid);
    }


    //usersnickname가지고 해야하지않나? 다시 얘기해보기
    @GetMapping("/checkid/{usersid}")
    public String checkId(@PathVariable("usersid") Long userid) {
        // 유저 아이디가 이미 사용 중인지 확인
        Optional<User> optionalUser = usersRepository.findById(userid);
        if (optionalUser.isPresent()) {
            return "이미 있는 아이디입니다";
        } else {
            return "사용 가능합니다";
        }
    }


}
