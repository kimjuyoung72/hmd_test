package com.kh.hanmadang.web.admin;

import com.kh.hanmadang.domain.PEvent;
import com.kh.hanmadang.domain.PFacility;
import com.kh.hanmadang.domain.svc.admin.AdminPostSVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/posts")
public class AdminPostController {

  private final AdminPostSVC adminPostSVC;

  //포스터 이미지 링크 화면
  @GetMapping("/poster")
  public String posterLinkForm() {

    return "admin/post/posterLinkForm";
  }
  //포스터 이미지 처리
  @PostMapping("/poster")
  public String getPoster() {

    return "redirect:/admin/posts/poster";
  }

  //신고게시물 화면
  @GetMapping("/dclr")
  public String dclrPostForm() {

    return "/admin/post/dclrPostForm";
  }
  //신고게시물 처리
  @PostMapping("/dclr")
  public String decideDclr() {

    return "redirect:/admin/posts/dclr";
  }
  //공연정보 등록화면
  @GetMapping("/add")
  public String addForm() {

    return "admin/post/addForm";
  }
  //등록처리
  @PostMapping("/add")
  public String add() {

    return "redirect:/admin/posts/{id}";
  }
  //공연정보 조회
  @GetMapping("/{id}")
  public String eventInfo() {

    return "admin/post/eventInfo";
  }
  //공연정보 수정화면
  @GetMapping("/{id}/edit")
  public String editForm() {

    return "admin/post/eventInfo";
  }

  //수정처리
  @PostMapping("/{id}/edit")
  public String edit() {

    return "redirect:/admin/posts/{id}";
  }

  //공연목록
  @GetMapping("/pub/event/list")
  public String all(Model model) {
    List<PEvent> list = adminPostSVC.pEventList();

    model.addAttribute("list", list);

    return "admin/post/pEventList";
  }


  //공연목록
  @GetMapping("/pall")
  public String pall(Model model) {
    List<PEvent> eventList =adminPostSVC.pEventList();
    List<PFacility> facilityList = adminPostSVC.pall();

    List<PEvent> elist = new ArrayList<>();
    List<PFacility> flist = new ArrayList<>();

    // PEvent와 PFacility에서 공연장 번호가 같은 리스트만 추출하여 저장
    // => 현재 공연중인 공연장의 정보만 나옴
    for(PEvent e : eventList){
      for(PFacility f : facilityList){

        // 공연장 시설번호가 같은지 확인
        if(f.getMt10id().equals(e.getMt10id())) {

          // 주소 뒤의 ( 이후 문자 제거
          // => 정확한 주소 검색을 위한 코드
          String addres = f.getAdres();

          if(addres.contains("울산") || addres.contains("부산") ||
              addres.contains("경상") ) {

            if(addres.contains("(")){
              int idx = addres.indexOf("(");
              addres = addres.substring(0,idx);
              f.setAdres(addres);
            } else {
              f.setAdres(addres);
            }
            log.info("e info = {}", e);
            log.info("f info = {}", f);
            elist.add(e);
            flist.add(f);
          }
        }
      }
    }
    // 중복 제거를 위한 Set
    Set<PEvent> seteList = new HashSet<PEvent>(elist);
    Set<PFacility> setfList = new HashSet<PFacility>(flist);
//
//         log.info("list ={}",seteList);
//         log.info("================");
//         log.info("list ={}",setfList);

    model.addAttribute("elist", seteList);
    model.addAttribute("flist", setfList);

    return "admin/post/pall";
  }

}