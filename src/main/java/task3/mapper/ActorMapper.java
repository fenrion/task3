package task3.mapper;

import org.springframework.stereotype.Component;
import task3.dto.ActorDTO;
import task3.dto.ActorOneDTO;
import task3.dto.ActorSingleDTO;
import task3.models.Actor;
import org.mapstruct.Mapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorOneDTO toActorOneDTO(Actor actor);
    List<ActorDTO> toActorDTOList(List<Actor> actors);
    Actor toActorFromActorSingleDTO(ActorSingleDTO actorSingleDTO);
}
