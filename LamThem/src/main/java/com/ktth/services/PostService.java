package com.ktth.services;

import com.ktth.dto.request.PostCreateRequest;
import com.ktth.dto.request.PostUpdateRequest;
import com.ktth.entities.Post;
import com.ktth.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    public Post getPostById(int id){
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay id Post"));
    }
    public void deletePost(int id){
        postRepository.deleteById(id);
    }
    public Post createPost(PostCreateRequest request){
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setComment(request.getComment());
        post.setAuthor(request.getAuthor());
        return postRepository.save(post);
    }
    public Post updatePost(int id, PostUpdateRequest request){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay id post"));

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setComment(request.getComment());
        post.setAuthor(request.getAuthor());
        return postRepository.save(post);
    }

    // Tìm kiem bai post theo id và theo keyword
    public List<Post> searchPost(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllPost();
        }
        return postRepository.searchByKeyword(keyword.trim());
    }


}
