package com.xicheng.javabase.t07_zookeeper;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.ZkClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 07:25
 */
@Slf4j
public class C05_Delete {

    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZkClient.getConnection();
        zooKeeper.delete("/create", -1);
        LogUtil.info(log, "删除成功");
    }
}
