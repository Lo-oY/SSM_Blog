package com.ly.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ly.util.ResponseDto;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

/**
 * Created by cilu on 2017/10/26.
 */
public class XMappingJackson2JsonView extends MappingJackson2JsonView {

    public XMappingJackson2JsonView() {
        super();
        this.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected Object filterModel(Map<String, Object> model) {
        ResponseDto response = null;
        Map result = (Map) super.filterModel(model);
        if (result.size() == 1) {
            Object object = result.values().iterator().next();
            if (object instanceof ResponseDto)
                return object;
            response = new ResponseDto();
            response.setItem(object);
        } else {
            response = new ResponseDto();
            response.setItem(result);
        }
        return response;
    }
}
