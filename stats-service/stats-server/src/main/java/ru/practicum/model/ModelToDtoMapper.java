package ru.practicum.model;

import lombok.experimental.UtilityClass;

import ru.practicum.dto.HitRequestDto;
import ru.practicum.dto.ViewStatsDto;

@UtilityClass
public class ModelToDtoMapper {

    public EndpointHit toHitModel(HitRequestDto requestDto) {
        return EndpointHit.builder()
                .app(requestDto.getApp())
                .uri(requestDto.getUri())
                .ip(requestDto.getIp())
                .timestamp(requestDto.getTimestamp())
                .build();
    }

    public ViewStatsDto toViewStatsDto(ViewStats viewStats) {
        ViewStatsDto dto = new ViewStatsDto();
        dto.setApp(viewStats.getApp());
        dto.setUri(viewStats.getUri());
        dto.setHits(viewStats.getHits());
        return dto;
    }
}