package com.example.demo.api;

import com.example.demo.entity.Likes;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Store;
import com.example.demo.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/likes")
public class LikesApiController {

    private final LikesRepository likesRepository;

    @Autowired
    public LikesApiController(LikesRepository likesRepository) {this.likesRepository = likesRepository;}

    @GetMapping
    public Iterable<Likes> list() {
        return likesRepository.findAll();
    }

    @GetMapping("/{usersid}")
    public List<Likes> getLikesById(@PathVariable Long usersid) {
        return likesRepository.findByusersid(usersid);
    }

    //이거 꼭 usersid 필요?
    @PostMapping("/{usersid}")
    public Likes likesInsert(@RequestBody Likes likes) {
        return likesRepository.save(likes);
    }

    @PutMapping("/{usersid}")
    public Likes updateLikes(@PathVariable Long usersid, @RequestBody Likes updatedLikes) {
        Optional<Likes> optionalLikes = likesRepository.findById(usersid);
        if (optionalLikes.isPresent()) {
            Likes likes = optionalLikes.get();
            likes.setStoresid(updatedLikes.getStoresid());
            likes.setLikesid(updatedLikes.getLikesid());
            likes.setLikesstatus(updatedLikes.getLikesstatus());
            return likesRepository.save(likes);
        } else {
            throw new IllegalArgumentException("Menu not found with ID: " + usersid);
        }
    }

    @DeleteMapping("/{usersid}")
    public void deleteLikes(@PathVariable Long usersid) {
        likesRepository.deleteById(usersid);
    }


}
