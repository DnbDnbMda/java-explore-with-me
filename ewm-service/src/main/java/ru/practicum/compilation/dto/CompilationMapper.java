package ru.practicum.compilation.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.experimental.UtilityClass;

import ru.practicum.compilation.model.Compilation;
import ru.practicum.event.dto.EventShortDto;
import ru.practicum.event.model.Event;
import ru.practicum.utils.ObjectMapperConfig;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class CompilationMapper {

    public Compilation toModel(NewCompilationDto dto, List<Event> events) {
        return Compilation.builder()
                .title(dto.getTitle())
                .pinned(dto.getPinned())
                .events(events).build();
    }

    public CompilationDto toDto(Compilation model, List<EventShortDto> eventShortDtos) {
        return CompilationDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .pinned(model.getPinned())
                .events(eventShortDtos)
                .build();

    }

    public Compilation patchMappingToModel(Compilation existedCompilation,
                                           UpdateCompilationRequest updateDto,
                                           List<Event> events) {
        ObjectMapper mapper = ObjectMapperConfig.getPatchMapperConfig();
        Map<String, String> updateDtoMap = mapper.convertValue(updateDto, Map.class);
        Map<String, String> existedCompMap = mapper.convertValue(existedCompilation, Map.class);
        Map<String, String> changedFields = updateDtoMap.entrySet().stream()
                .filter(entry -> entry.getValue() != null
                        && !entry.getKey().equals("events"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        existedCompMap.putAll(changedFields);
        Compilation updatedComp = mapper.convertValue(existedCompMap, Compilation.class);
        updatedComp.setEvents(events);
        return updatedComp;
    }
}