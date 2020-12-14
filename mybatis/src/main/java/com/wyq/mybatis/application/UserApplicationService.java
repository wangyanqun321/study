package com.wyq.mybatis.application;

import com.wyq.mybatis.mybatis.dataobject.User;
import com.wyq.mybatis.mybatis.dataobject.UserMapper;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 王艳群
 * @description UserService
 * @date 2020/7/11
 */
@Service
public class UserApplicationService {

    private UserMapper userMapper;

    public UserApplicationService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // @Transactional
    public User getUser(String id) {
        return userMapper.selectById(id);
    }

    public void testUpload(MultipartFile file) {
        Resource resource = file.getResource();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("file", resource);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject("http://localhost:8080/upload", paramMap, String.class);
        System.out.println(response);
    }

}
