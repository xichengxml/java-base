package com.xicheng.javabase.t02_idempotence.service;

import com.xicheng.javabase.t02_idempotence.common.TokenConstant;
import com.xicheng.javabase.t02_idempotence.dao.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-05-16 22:18
 */
@Service
@Slf4j
public class TokenService {

    @Autowired
    private RedisDao redisDao;

    public String createToken() {
        UUID uuid = UUID.randomUUID();
        String token = String.format(TokenConstant.TOKEN_PREFIX, uuid);
        redisDao.setEx(token, token, 60);
        return token;
    }

    public boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader(TokenConstant.TOKEN_NAME);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TokenConstant.TOKEN_NAME);
        }
        if (StringUtils.isNotBlank(token)) {
            Object redisToken = redisDao.get(token);
            return token.equals(redisToken);
        }
        return false;
    }
}
