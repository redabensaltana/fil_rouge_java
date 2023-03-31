package com.redabens.restosir.controllers;

import com.redabens.restosir.dto.WaiterDto;
import com.redabens.restosir.entities.Waiter;
import com.redabens.restosir.Response.Response;
import com.redabens.restosir.services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/waiter")
public class WaiterController {

    @Autowired
    WaiterService waiterService;

    @GetMapping("/all")
    public Response getAll() {
        Response response = new Response();
        Map map = new HashMap<>();
        List<Waiter> waiters = waiterService.getAll();
        if (waiters != null) {
//            waiters = waiters.stream().map(waiter -> {
//                waiter.setOrders(null);
//                return waiter;
//            }).toList();
            map.put("waiters", waiters);
            response.setData(map);
            response.setMessage("success");
            response.setStatus(200);
        }else{
            response.setMessage("No waiters found");
            response.setStatus(404);
        }
        return response;
    }
//
//    @GetMapping("/{id}")
//    public Response getPostById(@PathVariable int id) {
//        Response response = new Response();
//        Map map = new HashMap<>();
//        Post post = waiterService.getPostById(id);
//        if (post != null) {
//            post.getComments().forEach(c -> {
//                c.setPost(null);
//                c.getUser().setPosts(null);
//                c.getUser().setComments(null);
//            });
//            post.getUser().setPosts(null);
//            post.getUser().setComments(null);
//            post.getUser().setPosts(null);
//            map.put("post", post);
//            response.setData(map);
//            response.setMessage("success");
//            response.setStatus(200);
//        }else{
//            response.setMessage("No post found");
//            response.setStatus(404);
//        }
//        return response;
//    }
//
//    @PostMapping
//    public Response add(@RequestBody PostDto postDto) {
//        Response response = new Response();
//        Map map = new HashMap<>();
//        waiterService.savePost(postDto);
//        map.put("post", postDto);
//        response.setData(map);
//        response.setMessage("success : post added");
//        response.setStatus(200);
//        return response;
//    }
//
//    @PutMapping("/{id}")
//    public Response update(@RequestBody PostDto postDto, @PathVariable int id) {
//        Response response = new Response();
//        Map map = new HashMap<>();
//        waiterService.updatePost(postDto, id);
//        map.put("post", postDto);
//        response.setData(map);
//        response.setMessage("success : post updated");
//        response.setStatus(200);
//        return response;
//    }
//
//    @DeleteMapping("/{id}")
//    public Response delete(@PathVariable int id) {
//        Response response = new Response();
//        waiterService.deletePost(id);
//        response.setMessage("success : post deleted");
//        response.setStatus(200);
//        return response;
//    }
//
//    @PutMapping("/adopt/{id}/{userId}")
//    public Response adopt(@PathVariable int id , @PathVariable int userId) {
//        Response response = new Response();
//        waiterService.adopt(id,userId);
//        response.setMessage("success : pet adopted");
//        response.setStatus(200);
//        return response;
//    }

    @PostMapping("/add")
    public void add() {
        System.out.println("WaiterController.add");
    }

}

