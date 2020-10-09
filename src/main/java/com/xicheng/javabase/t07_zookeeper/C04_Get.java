package com.xicheng.javabase.t07_zookeeper;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.ZkClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 07:16
 */
@Slf4j
public class C04_Get {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = ZkClient.getConnection();
        byte[] data = zooKeeper.getData("/create", null, null);
        LogUtil.info(log, "get result: {}", new String(data));
    }
}
