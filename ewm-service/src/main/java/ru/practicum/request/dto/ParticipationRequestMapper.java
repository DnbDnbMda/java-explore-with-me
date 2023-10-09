package ru.practicum.request.dto;

import lombok.experimental.UtilityClass;
import ru.practicum.event.model.Event;
import ru.practicum.request.model.ParticipationRequestState;
import ru.practicum.request.model.ParticipationRequest;
import ru.practicum.user.model.User;

import java.time.LocalDateTime;

@UtilityClass
public class ParticipationRequestMapper {

    public ParticipationRequest toModel(User user, Event event) {
        return ParticipationRequest.builder()
                .requester(user)
                .event(event)
                .created(LocalDateTime.now())
                .status(ParticipationRequestState.PENDING)
                .build();
    }

    public ParticipationRequestDto toDto(ParticipationRequest model) {
        return ParticipationRequestDto.builder()
                .created(model.getCreated())
                .status(model.getStatus())
                .id(model.getId())
                .event(model.getEvent().getId())
                .requester(model.getRequester().getId())
                .build();
    }
}