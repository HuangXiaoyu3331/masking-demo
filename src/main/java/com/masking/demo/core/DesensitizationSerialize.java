package com.masking.demo.core;

import com.masking.demo.annotation.Desensitization;
import com.masking.demo.enums.DesensitizationTypeEnum;
import com.masking.demo.util.DesensitizationSerializeUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class DesensitizationSerialize extends JsonSerializer<String> implements ContextualSerializer {

    private DesensitizationTypeEnum type;

    private Integer startInclude;

    private Integer endExclude;

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty == null) {
            return serializerProvider.findNullValueSerializer(null);
        }

        if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
            Desensitization desensitization = beanProperty.getAnnotation(Desensitization.class);
            if (desensitization == null) {
                desensitization = beanProperty.getContextAnnotation(Desensitization.class);
            }

            if (desensitization != null) {
                // 创建定义的序列化类的实例并且返回，入参为注解定义的type,开始位置，结束位置。
                return new DesensitizationSerialize(desensitization.type(), desensitization.startInclude(),
                        desensitization.endExclude());
            }
        }
        return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
    }

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        switch (type) {
            case MY_RULE:
                jsonGenerator.writeString(DesensitizationSerializeUtil.hide(s, startInclude, endExclude));
                break;
            case MOBILE:
                jsonGenerator.writeString(DesensitizationSerializeUtil.desMobile(s));
                break;
            case ID_CARD:
                jsonGenerator.writeString(DesensitizationSerializeUtil.desIdCard(s));
                break;
            default:
        }
    }

}
