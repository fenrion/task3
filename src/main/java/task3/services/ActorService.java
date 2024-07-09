package task3.services;

import task3.models.Actor;
import task3.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Transactional
    public void save(Actor actor) {
        actorRepository.save(actor);
    }
    public Actor findOneById(int index){
        Optional<Actor> actor=actorRepository.findById(index);
        Actor act = actor.orElse(null);
        if (act!=null){
            System.out.println(act.getMovieList());
            System.out.println(act.getPhoneNumberList());
        }
        return actor.orElse(null);
    }
    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    @Transactional
    public void update(int id, Actor updatedActor) {
        updatedActor.setId(id);
        actorRepository.save(updatedActor);
    }

    @Transactional
    public void removeActorById(int index){
        actorRepository.deleteById(index);
    }
}
