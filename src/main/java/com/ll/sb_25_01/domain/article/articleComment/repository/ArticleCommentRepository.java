package com.ll.sb_25_01.domain.article.articleComment.repository;

import com.ll.sb_25_01.domain.article.articleComment.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    Optional<ArticleComment> findFirstByOrderByIdDesc();

    Optional<ArticleComment> findFirstByArticleIdOrderByIdDesc(int id);
}
