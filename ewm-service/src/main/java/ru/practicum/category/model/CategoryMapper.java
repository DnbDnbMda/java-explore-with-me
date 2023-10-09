package ru.practicum.category.model;

import lombok.experimental.UtilityClass;

import ru.practicum.category.dto.NewCategoryDto;
import ru.practicum.category.dto.CategoryDto;

@UtilityClass
public class CategoryMapper {

    public Category toModel(NewCategoryDto categoryRequestDto) {
        return Category.builder()
                .name(categoryRequestDto.getName())
                .build();
    }

    public CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}