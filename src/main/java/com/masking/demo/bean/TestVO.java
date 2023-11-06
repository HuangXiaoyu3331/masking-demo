package com.masking.demo.bean;

import com.masking.demo.annotation.Desensitization;
import com.masking.demo.enums.DesensitizationTypeEnum;
import lombok.Data;

@Data
public class TestVO {

    @Desensitization(type = DesensitizationTypeEnum.MOBILE)
    private String phone;
    @Desensitization(type = DesensitizationTypeEnum.ID_CARD)
    private String idCard;
    @Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 1, endExclude = 6)
    private String email;

}
