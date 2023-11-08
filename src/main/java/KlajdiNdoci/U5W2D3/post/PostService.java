package KlajdiNdoci.U5W2D2.post;

import KlajdiNdoci.U5W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return this.posts;
    }

    public Post save(Post body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1000));
        this.posts.add(body);
        return body;
    }

    public Post findById(long id) {
        Post found = null;
        for (Post user : this.posts) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }

    public void findByIdAndDelete(int id) {
        this.posts.removeIf(current -> current.getId() == id);
    }

    public Post findByIdAndUpdate(int id, Post body) {
        Post found = null;

        for (Post user : this.posts) {
            if (user.getId() == id) {
                found = user;
                found.setId(id);
                found.setCover(body.getCover());
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setTempoDiLettura(body.getTempoDiLettura());
                found.setContenuto(body.getContenuto());
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }

}
