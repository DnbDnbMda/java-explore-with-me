package ru.practicum.user.dto;

import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserShortDto {
    private Long id;
    private String name;
}