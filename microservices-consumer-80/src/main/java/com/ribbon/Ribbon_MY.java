package com.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定义ribbon算法
 * <p>
 *     https://github.com/Netflix/ribbon/tree/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer
 * 每个服务轮询调用5次
 */

public class Ribbon_MY extends AbstractLoadBalancerRule {


    private int total = 0;         //每个服务调用的次数
    private int currentIndex = 0;  //服务的指针


    /**
     * Randomly choose from all living servers
     */
    //   @edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }


/**
 * 改变原先的方法
 */
//                int index = chooseRandomInt(serverCount);
//                server = upList.get(index);


            /**  自己定义算法---------  */

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;

                //当指针大于服务的个数时，循环
                if (currentIndex >= upList.size()) currentIndex = 0;
            }


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    /**
     * 改变随机的方式
     */
//    protected int chooseRandomInt(int serverCount) {
//            return ThreadLocalRandom.current().nextInt(serverCount);
//        }


    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub
    }

}
