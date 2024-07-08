package task3.mapper;

import org.springframework.stereotype.Component;
import task3.dto.ActorDTO;
import task3.dto.ActorOneDTO;
import task3.dto.ActorSingleDTO;
import task3.dto.ActorUpdateDTO;
import task3.models.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorOneDTO toActorOneDTO(Actor actor);
    List<ActorDTO> toActorDTOList(List<Actor> actors);
    Actor toActorFromActorSingleDTO(ActorSingleDTO actorSingleDTO);
    Actor toActorFromActorUpdateDTO(ActorUpdateDTO actorUpdateDTO);
}
