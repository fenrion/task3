package task3.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import task3.dto.ActorDTO;
import task3.dto.ActorOneDTO;
import task3.dto.ActorSingleDTO;
import task3.mapper.ActorMapper;
import task3.models.Actor;
import task3.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService  actorService;
    private final ActorMapper actorMapper;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ActorController(ActorService actorService, ActorMapper actorMapper) {
        this.actorService = actorService;
        this.actorMapper = actorMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<Actor> actors = actorService.findAll();
        List<ActorDTO> actorDTOList = actorMapper.toActorDTOList(actors);
        return ResponseEntity.ok().body(objectMapper.writeValueAsString(actorDTOList));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findById(@PathVariable int id) throws JsonProcessingException {
        Actor actor = actorService.findOneById(id);
        ActorOneDTO actorOneDTO = actorMapper.toActorOneDTO(actor);
        if (actor!=null){
            return ResponseEntity.ok().body(objectMapper.writeValueAsString(actorOneDTO));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody ActorSingleDTO actorSingleDTO){
        Actor actor = actorMapper.toActorFromActorSingleDTO(actorSingleDTO);
        actorService.save(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping(value = "/{id}",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> update(@PathVariable int id, @RequestBody ActorSingleDTO actorDTO){
        Actor actor = actorMapper.toActorFromActorSingleDTO(actorDTO);
        actorService.update(id,actor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        actorService.removeActorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
