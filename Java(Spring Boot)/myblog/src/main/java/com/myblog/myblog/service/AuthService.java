package com.myblog.myblog.service;

import com.myblog.myblog.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
