package com.xicheng.javabase.t07_zookeeper;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.ZkClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 07:15
 */
@Slf4j
public class C03_Update {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = ZkClient.getConnection();
        zooKeeper.setData("/create", "update node".getBytes(), -1);
        LogUtil.info(log, "更新成功");
    }
}
