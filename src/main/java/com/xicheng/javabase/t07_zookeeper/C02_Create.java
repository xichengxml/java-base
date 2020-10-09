package com.xicheng.javabase.t07_zookeeper;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.ZkClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 07:05
 */
@Slf4j
public class C02_Create {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = ZkClient.getConnection();
        zooKeeper.create("/create", "create node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        LogUtil.info(log, "添加成功");
    }
}
