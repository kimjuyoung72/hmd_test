package com.kh.hanmadang.domain.dao.post;

public enum PostStatus {
  D("삭제"),I("임시저장"),W("경고");

  private final String description;

  PostStatus(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
