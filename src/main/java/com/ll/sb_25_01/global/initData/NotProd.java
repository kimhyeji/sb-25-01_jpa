package com.ll.sb_25_01.global.initData;

import com.ll.sb_25_01.domain.article.article.entity.Article;
import com.ll.sb_25_01.domain.article.article.service.ArticleService;
import com.ll.sb_25_01.domain.member.member.entity.Member;
import com.ll.sb_25_01.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Profile("!prod")
@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner initNotProdData(
            MemberService memberService,
            ArticleService articleService
    ) {
        return new ApplicationRunner() {
            @Override
            @Transactional
            public void run(ApplicationArguments args) {
                Member member1 = memberService.join("user1", "1234").getData();
                Member member2 = memberService.join("user2", "1234").getData();

                Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
                Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

                Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
                Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

                article1.addComment(member2, "댓글1");
                article1.addComment(member2, "댓글2");
            }
        };
    }
}
