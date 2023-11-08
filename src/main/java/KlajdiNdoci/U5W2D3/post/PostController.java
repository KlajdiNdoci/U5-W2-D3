package KlajdiNdoci.U5W2D3.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getPost() {
        return postService.getPosts();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Post savePost(@RequestBody Post body) {
        return postService.save(body);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        postService.findByIdAndDelete(id);
    }

    @PutMapping("/{id}")
    public Post findByIdAndUpdate(@PathVariable int id, @RequestBody Post body) {
        return postService.findByIdAndUpdate(id, body);
    }
}
