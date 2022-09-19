package com.kh.hanmadang.domain.svc.admin;

import com.kh.hanmadang.domain.PEvent;
import com.kh.hanmadang.domain.PFacility;

import java.util.List;
import java.util.Set;

public interface ApiPubSVC {

  List<PEvent> apiCall(String fromDate, String toDate);

  List<PFacility> apiCall2(Set<String> facIds);
}
