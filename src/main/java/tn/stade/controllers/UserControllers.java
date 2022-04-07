package tn.stade.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.stade.models.AuthenticationRequest;
import tn.stade.models.User;
import tn.stade.repositories.UserRepository;

@RestController
@RequestMapping("api/users")
public class UserControllers {

    @Autowired(required = false)
    private UserRepository userrepo;


    @PostMapping("/authenticate")
    public User authentiaction(@RequestBody AuthenticationRequest auth) {
        Optional<User> user = userrepo.findByEmail(auth.getEmail());
        if (user.isPresent()) {
            if (auth.getPassword().equals(user.get().getPassword())) {
                return user.get();
            } else throw new NullPointerException("password incorrect");

        }
        throw new NullPointerException("email or password incorrect");

    }


    @GetMapping("/all")
    public List<User> getall() {
        return userrepo.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        Optional<User> user = userrepo.findById(id);
        if (user.isPresent()) {

            return user.get();
        }
        throw new NullPointerException();

    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id) {
        userrepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable int id) {
        User existUser = userrepo.getOne(id);

        if (existUser != null) {

            existUser.setEmail(user.getEmail());
            existUser.setPrenom(user.getPrenom());
            existUser.setPassword(user.getPassword());
            existUser.setNom(user.getNom());
            return userrepo.save(existUser);
        }

        //  throw new ResourceNotFoundException("user not found");


        return existUser;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userrepo.save(user);

    }


}
