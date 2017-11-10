package com.leafproject.proj;

import org.springframework.data.repository.CrudRepository;

import com.leafproject.proj.Comments;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comments, Long> {
    List<Comments> findByName(String name);
}