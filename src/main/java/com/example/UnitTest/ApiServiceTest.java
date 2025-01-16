package com.example.UnitTest;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ApiServiceTest {

    @Test
    public void testFetchPosts() {
        ApiService apiService = new ApiService();

        try {
            // API 호출
            List<Map<String, Object>> posts = apiService.fetchPosts();

            System.out.println("Fetched posts: " + posts);
            System.out.println("Number of posts: " + posts.size());
            System.out.println("First post: " + posts.get(0));

            // 결과 검증
            assertThat("posts가 null이 아닌지 확인", posts, is(notNullValue()));
            assertThat("리스트 크기가 0보다 큰지 확인", posts.size(), is(greaterThan(0)));
            assertThat("첫 번째 게시물이 title 키를 포함하는지 확인", posts.get(0), hasKey("title"));
            
            
            assertThat("posts가 null이어야 합니다", posts, is(nullValue()));
            assertThat("리스트 크기가 0보다 작거나 같은지 확인", posts.size(), is(lessThanOrEqualTo(0)));
            assertThat("첫 번째 게시물이 title 키를 포함하지 않는지 확인", posts.get(0), not(hasKey("title")));



        } catch (Exception e) {
            e.printStackTrace();
            assertThat("API 호출 Exception " + e.getMessage(), is(false));
        }
    }
}
