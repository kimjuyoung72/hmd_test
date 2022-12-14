package com.kh.hanmadang.domain.api;

import com.kh.hanmadang.domain.PEvent;
import com.kh.hanmadang.domain.svc.admin.ApiPubSVC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pub")
@RequiredArgsConstructor
public class ApiPubDataController {

  private final ApiPubSVC apiExplorer;

  @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PEvent> getJsonData(){
    List<PEvent> res = apiExplorer.apiCall("20220901", "20220931");
    return res;
  }

  @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
  public  List<PEvent> getData(){
    List<PEvent> res = apiExplorer.apiCall("20220901", "20220931");
    return res;
  }

}