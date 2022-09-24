package com.kh.hanmadang.web.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class HomeForm {
  private Map<String, String> homePosts;          //포스트 항목: 공연ID, 포스터 link
  private Map<String, String> promotionPosts;     //포스트 항목: 홍보글ID, 포스터 link

}
