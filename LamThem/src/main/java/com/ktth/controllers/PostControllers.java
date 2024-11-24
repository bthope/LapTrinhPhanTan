    package com.ktth.controllers;

    import com.ktth.dto.request.PostCreateRequest;
    import com.ktth.dto.request.PostUpdateRequest;
    import com.ktth.entities.Post;
    import com.ktth.services.PostService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    @RequestMapping("/post")
    public class PostControllers {
        @Autowired
        private PostService postService;

        @GetMapping
        public String listPost(Model model) {
            model.addAttribute("post", postService.getAllPost());
            return "post/list";
        }
        @GetMapping("/create")
        public String showCreatePostForm(Model model){
            model.addAttribute("postCreateRequest", new PostCreateRequest());
            return "post/create";
        }
        @PostMapping("/create")
        public String createPost(@ModelAttribute PostCreateRequest request){
            postService.createPost(request);
            return "redirect:/post";
        }
        @GetMapping("/update/{id}")
        public String showUpdatePostForm(@PathVariable("id") int id, Model model){
            Post post = postService.getPostById(id);
            model.addAttribute("post", post);
            return "post/update";
        }
        @PostMapping("/update/{id}")
        public String updatePost(@PathVariable("id") int id, @ModelAttribute PostUpdateRequest request){
            postService.updatePost(id,request);
            return "redirect:/post";
        }
        @GetMapping("/delete/{id}")
        public String deletePost(@PathVariable("id") int id){
            postService.deletePost(id);
            return "redirect:/post";
        }
        @GetMapping("/search")
        public String searchPost(@RequestParam(value = "search", required = false) String keyword, Model model) {
            List<Post> searchResults = postService.searchPost(keyword);
            model.addAttribute("post", searchResults);
            return "post/list";
        }
        @GetMapping("/detail/{id}")
        public String viewPostDetail(@PathVariable("id") int id, Model model) {
            Post post = postService.getPostById(id);
            model.addAttribute("post", post);
            return "post/detail";
        }


    }
