package com.xicheng.javabase.t07_zookeeper.common;

import com.xicheng.javabase.common.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 06:51
 */
@Slf4j
public class DefaultZkWatcher implements Watcher {

    /**
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState state = watchedEvent.getState();
        switch (state) {
            case SyncConnected:
                LogUtil.info(log, "zk 连接成功");
                break;
            default:
                break;
        }
    }
}
