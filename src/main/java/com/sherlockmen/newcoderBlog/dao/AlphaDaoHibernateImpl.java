package com.sherlockmen.newcoderBlog.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "hibernate";
    }
}
