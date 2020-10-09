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
 * @date 2020-10-09 22:05
 */
@Slf4j
public class C07_WatchDataChange {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = ZkClient.getConnection();
        for(;;) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            zooKeeper.getData("/park01", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType().equals(Event.EventType.NodeDataChanged)) {
                        LogUtil.info(log, "数据发生变化");
                        countDownLatch.countDown();
                    }
                }
            }, null);
            countDownLatch.await();
        }
    }
}
