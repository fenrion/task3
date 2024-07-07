package task3.controllers;

import org.springframework.http.MediaType;
import task3.dto.ActorDTO;
import task3.mapper.ActorMapper;
import task3.models.Actor;
import task3.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService  actorService;
    private final ActorMapper actorMapper;

    @Autowired
    public ActorController(ActorService actorService, ActorMapper actorMapper) {
        this.actorService = actorService;
        this.actorMapper = actorMapper;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello people";
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActorDTO> findAll(){
        List<Actor> actors = actorService.findAll();
        System.out.println(actors);
        List<ActorDTO> actorDTOList = actorMapper.toActorDTOList(actors);
        System.out.println(actorDTOList);
        return actorDTOList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> findById(@PathVariable int id){
        Actor actor = actorService.findOneById(id);
        if (actor!=null){
            System.out.println(actor);
            return ResponseEntity.ok(actorMapper.toActorDTO(actor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
