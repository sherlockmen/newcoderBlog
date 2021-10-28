package com.sherlockmen.newcoderBlog;


import com.sherlockmen.newcoderBlog.dao.DiscussPostMapper;
import com.sherlockmen.newcoderBlog.dao.LoginTicketMapper;
import com.sherlockmen.newcoderBlog.dao.UserMapper;
import com.sherlockmen.newcoderBlog.entity.DiscussPost;
import com.sherlockmen.newcoderBlog.entity.LoginTicket;
import com.sherlockmen.newcoderBlog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NewcoderBlogApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        User user1 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user1);

        User liubei = userMapper.selectByName("liubei");
        System.out.println(liubei);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        //user.setType(0);
        //user.setStatus(1);
        //user.setActivationCode("null");
        user.setHeaderUrl("http://www.baidu.com/155.png");
        user.setCreateTime(new Date());


        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int i = userMapper.updateStatus(150, 1);
        System.out.println(i);

        int i1 = userMapper.updateHeader(150, "http://baidu.com");
        System.out.println(i1);

        int abcdef = userMapper.updatePassword(150, "abcdef");
        System.out.println(abcdef);

    }

    @Test
    public void selectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost post:
             list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void TestSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc",1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

}
