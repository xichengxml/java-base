package com.xicheng.javabase.t07_zookeeper;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.ZkClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-09 22:13
 */
@Slf4j
public class C08_WatchChildChange {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = ZkClient.getConnection();
        while (true) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            zooKeeper.getChildren("/baseNode", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (Event.EventType.NodeChildrenChanged.equals(event.getType())) {
                        LogUtil.info(log, "子节点发生变化");
                        countDownLatch.countDown();
                    }
                }
            }, null);
            countDownLatch.await();
        }
    }
}
