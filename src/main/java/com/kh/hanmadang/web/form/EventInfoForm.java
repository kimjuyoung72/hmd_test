package com.kh.hanmadang.web.form;

import com.kh.hanmadang.domain.PEvent;
import com.kh.hanmadang.domain.PFacility;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventInfoForm {
  private PEvent pEvent;
  private PFacility pFacility;
}
