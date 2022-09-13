package com.todo.cn;

import com.todo.cn.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {

    @Autowired
    private TestMapper testMapper;

    @org.junit.jupiter.api.Test
    public void testSelect() {
        String id = testMapper.testSelect();
        System.out.println(id);
    }
}
