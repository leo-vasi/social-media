package com.leo.socialmedia.config;

import com.leo.socialmedia.domain.Post;
import com.leo.socialmedia.domain.User;
import com.leo.socialmedia.dto.AuthorDTO;
import com.leo.socialmedia.dto.CommentDTO;
import com.leo.socialmedia.repository.PostRepository;
import com.leo.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User("maria@gmail.com", null,  "Maria Brown");
        User alex = new User("alex@gmail.com", null, "Alex Green");
        User bob = new User("bob@gmail.com",null, "Bob Grey");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post("Vou viajar para São Paulo", sdf.parse("21/03/2018"), null, "Partiu viagem", new AuthorDTO(maria));
        Post post2 = new Post("Vou viajar para São Paulo", sdf.parse("23/03/2018"), null, "Bom dia", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO(new AuthorDTO(alex), sdf.parse("21/03/2018"), "Boa viagem");
        CommentDTO c2 = new CommentDTO(new AuthorDTO(bob), sdf.parse("22/03/2018"), "Bom proveito");
        CommentDTO c3 = new CommentDTO(new AuthorDTO(alex), sdf.parse("23/03/2018"), "Boa sorte");

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);


    }
}
