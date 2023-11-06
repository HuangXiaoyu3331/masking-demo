package com.masking.demo.service.impl;

import com.masking.demo.bean.model.UserModel;
import com.masking.demo.bean.vo.UserVO;
import com.masking.demo.dao.UserMapper;
import com.masking.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserVO getUser(Integer id) {
        UserModel userModel = userMapper.selectByPrimaryKey(id);

        UserVO userVO = new UserVO();
            userVO.setId(userModel.getId());
        userVO.setUsername(userModel.getUsername());
        userVO.setMobile(userModel.getMobile());
        return userVO;
    }

}
