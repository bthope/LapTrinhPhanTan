package com.ktth.baiktthck;

import com.ktth.entities.Post;
import com.ktth.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaiKtthckApplicationTests {

    @Autowired
    PostRepository postRepository;
    @Test
    void addPost() {
        postRepository.save(new Post("Bai viet 1","Noi dung bai viet 1","Comment 1","Author 1"));
        postRepository.save(new Post("Bai viet 2","Noi dung bai viet 2","Comment 2","Author 2"));
        postRepository.save(new Post("Bai viet 3","Noi dung bai viet 3","Comment 3","Author 3"));
        postRepository.save(new Post("Bai viet 4","Noi dung bai viet 4","Comment 4","Author 4"));
        postRepository.save(new Post("Bai viet 5","Noi dung bai viet 5","Comment 5","Author 5"));
        postRepository.save(new Post("Bai viet 6","Noi dung bai viet 6","Comment 6","Author 6"));
    }

}
