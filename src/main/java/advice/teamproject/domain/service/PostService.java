package advice.teamproject.domain.service;


import advice.teamproject.domain.entity.Post;
import advice.teamproject.domain.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시물 저장하기
    public Post save(Post post) {
        return postRepository.save(post);
    }

    // 게시물 아이디로 찾기
    public Optional<Post> findPost(Long postId) {
        return postRepository.findById(postId);
    }

    // 모든 게시물 조회(게시물 목록)
    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    // 게시물 수정하기
    // updateParam 을 받아서 그 내용으로 수정한 다음에 다시 저장
    public void editPost(Long postId, Post updateParam) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setTitle(updateParam.getTitle());
            post.setContent(updateParam.getContent());
            postRepository.save(post);
        }
    }
}