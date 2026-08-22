package com.guoshisan.xiaohongshu.auth;

import com.guoshisan.framework.common.util.JsonUtils;
import com.guoshisan.xiaohongshu.auth.domain.dto.UserDO;
import com.guoshisan.xiaohongshu.auth.mapper.UserDOMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class XiaohongshuAuthApplicationTests {

    @Resource
    private UserDOMapper userDOMapper;

//    /**
//     * 测试插入数据
//     */
//    @Test
//    void testInsert() {
//        UserDO userDO = UserDO.builder()
//                .username("犬小哈")
//                .createTime(LocalDateTime.now())
//                .updateTime(LocalDateTime.now())
//                .build();
//
//        userDOMapper.insert(userDO);
//    }
//
//
//    /**
//     * 查询数据
//     */
//    @Test
//    void testSelect() {
//        // 查询主键 ID 为 4 的记录
//        UserDO userDO = userDOMapper.selectByPrimaryKey(2L);
//        log.info("User: {}", JsonUtils.toJsonString(userDO));
//    }

}
