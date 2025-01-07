package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.model.Sangpum;
import pack.model.SangpumDto;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SangpumBean {
    private int code, su, dan;
    private String sang;

    public static Sangpum toEntity(SangpumBean bean) {
        return Sangpum.builder()
                      .code(bean.getCode())
                      .sang(bean.getSang())
                      .su(bean.getSu())
                      .dan(bean.getDan())
                      .build();
    }
}
