package com.sherlockmen.newcoderBlog.service;

import com.sherlockmen.newcoderBlog.dao.DiscussPostMapper;
import com.sherlockmen.newcoderBlog.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDisscussPosts(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDisscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
