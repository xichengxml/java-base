package com.xicheng.javabase.t07_zookeeper.common;

import com.xicheng.javabase.common.LogUtil;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 07:06
 */
@Slf4j
public class ZkClient {

    public static ZooKeeper getConnection() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(ZkConstant.HOST_PORT, ZkConstant.ZK_TIMEOUT, new DefaultZkWatcher());
        } catch (IOException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        return zooKeeper;
    }

    public static void createNode(String nodePath, String nodeData) {
        ZooKeeper zooKeeper = getConnection();
        try {
            zooKeeper.create(nodePath, nodeData.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.info(log, "{}节点创建成功", nodePath);
    }

    public static void batchCreateNode(List<Pair<String, String>> nodeList) {
        if (CollectionUtils.isEmpty(nodeList)) {
            return;
        }
        ZooKeeper zooKeeper = getConnection();
        for (Pair<String, String> node : nodeList) {
            try {
                String nodePath = node.getKey();
                String nodeData = node.getValue();
                zooKeeper.create(nodePath, nodeData.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                LogUtil.info(log, "{}节点创建成功", nodePath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
