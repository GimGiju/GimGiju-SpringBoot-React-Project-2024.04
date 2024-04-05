package com.example.reactProject.service;

import com.example.reactProject.dao.UserDao;
import com.example.reactProject.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao uDao;
    @Override
    public List<User> userList() {

        return uDao.userList();
    }
}
