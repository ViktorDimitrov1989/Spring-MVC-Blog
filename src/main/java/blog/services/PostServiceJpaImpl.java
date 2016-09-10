
package blog.services;

import blog.models.Post;
import blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public List<Post> findLatest5() {

        List<Post> latestPosts = postRepo.findLatestPosts(new PageRequest(0, 5));
        return latestPosts;
        /*this.postRepo.findLatestPosts(new PageRequest(0, 5));*/
    }

    @Override
    public Post findById(Long id) {

        Post currentPost = postRepo.findOne(id);
        return currentPost;
    }

    @Override
    public Post create(Post post) {
        /*postRepo.save(post);
        return post;*/
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepo.delete(id);
    }
}
