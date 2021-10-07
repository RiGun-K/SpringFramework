package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anyboard.data.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
