package com.xicheng.javabase.t07_zookeeper;

import com.alibaba.fastjson.JSON;
import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.DefaultZkWatcher;
import com.xicheng.javabase.t07_zookeeper.common.ZkConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 06:48
 */
@Slf4j
public class C01_Connection {

    /**
     * 非阻塞方式，使用CountDownLatch实现阻塞
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zookeeper = new ZooKeeper(ZkConstant.HOST_PORT, ZkConstant.ZK_TIMEOUT, new DefaultZkWatcher());
        countDownLatch.countDown();
        LogUtil.info(log, "zookeeper: {}", JSON.toJSONString(zookeeper));
    }
}
