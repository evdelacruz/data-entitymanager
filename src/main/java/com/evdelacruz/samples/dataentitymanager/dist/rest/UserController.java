package com.evdelacruz.samples.dataentitymanager.dist.rest;

import com.evdelacruz.samples.dataentitymanager.service.UserService;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.ProfileVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserSearchCriteriaVO;
import com.evdelacruz.samples.dataentitymanager.service.contract.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Autowired UserService userService;

    public UserController() {}

    @GetMapping
    public List<UserVO> get(UserSearchCriteriaVO criteria) {
        return userService.loadAll(criteria).collect(toList());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserVO user) {
        return created(fromCurrentRequest().path("/{id}").buildAndExpand(userService.add(user)).toUri()).build();
    }

    @GetMapping("/{id}")
    public UserVO get(@PathVariable int id) {
        return userService.load(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userService.remove(id);
        return noContent().build();
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<Void> updateProfile(@PathVariable int id, @RequestBody ProfileVO profile) {
        userService.update(id, profile);
        return noContent().build();
    }
}
