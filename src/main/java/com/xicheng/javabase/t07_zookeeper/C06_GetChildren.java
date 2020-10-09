package com.xicheng.javabase.t07_zookeeper;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.t07_zookeeper.common.ZkClient;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-02 07:28
 */
@Slf4j
public class C06_GetChildren {

    public static void main(String[] args) throws KeeperException, InterruptedException {
        Pair<String, String> baseNode = new Pair<>("/baseNode", "base node");
        Pair<String, String> node01 = new Pair<>("/baseNode/node01", "node01");
        Pair<String, String> node02 = new Pair<>("/baseNode/node02", "node02");
        Pair<String, String> node03 = new Pair<>("/baseNode/node03", "node03");
        ArrayListProxy<Pair<String, String>> nodeList = new ArrayListProxy<>();
        ArrayListProxy<Pair<String, String>> listProxy = nodeList.addObject(baseNode).addObject(node01).addObject(node02).addObject(node03);
        ZkClient.batchCreateNode(listProxy);

        ZooKeeper zooKeeper = ZkClient.getConnection();
        List<String> children = zooKeeper.getChildren("/baseNode", null);
        if (CollectionUtils.isNotEmpty(children)) {
            for (String child : children) {
                LogUtil.info(log, "child: {}", child);
            }
        }
    }

    private static class ArrayListProxy<T> extends ArrayList<T> {

        public ArrayListProxy() {
            super();
        }

        private ArrayListProxy<T> addObject(T t) {
            this.add(t);
            return this;
        }
    }
}
