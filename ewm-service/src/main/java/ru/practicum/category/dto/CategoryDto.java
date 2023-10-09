package ru.practicum.category.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto {
    private Long id;
    private String name;
}