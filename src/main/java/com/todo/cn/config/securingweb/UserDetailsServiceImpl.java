package com.todo.cn.config.securingweb;

import com.todo.cn.domain.UsersVO;
import com.todo.cn.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersVO usersVO = adminMapper.findUserById(username);

        if(usersVO != null) {
            return usersVO;
        }
        throw new UsernameNotFoundException("User" + username + " not found");
    }
}
