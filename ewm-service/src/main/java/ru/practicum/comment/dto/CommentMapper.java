package ru.practicum.comment.dto;

import lombok.experimental.UtilityClass;

import ru.practicum.comment.model.Comment;
import ru.practicum.event.model.Event;
import ru.practicum.user.model.User;

import java.time.LocalDateTime;

@UtilityClass
public class CommentMapper {

    public Comment toModel(CommentDto dto, User commentator, Event event) {
        return Comment.builder()
                .text(dto.getText())
                .commentator(commentator)
                .event(event)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public Comment patchModel(CommentDto dto, Comment existedComment) {
        existedComment.setText(dto.getText());
        existedComment.setTimestamp(LocalDateTime.now());
        return existedComment;
    }

    public CommentDto toDto(Comment model) {
        return CommentDto.builder()
                .id(model.getId())
                .text(model.getText())
                .commentatorId(model.getCommentator().getId())
                .eventId(model.getEvent().getId())
                .timestamp(model.getTimestamp())
                .build();
    }
}