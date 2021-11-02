package com.wwj.test.动态规划;

import com.wwj.arithmetic.backtracking.ShortestPath;
import com.wwj.arithmetic.dynamicProgramming.shortestPath.ShortestPath2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * auth sherry
 * data created in 2021/10/25 11:56 上午
 */
class ShortestPathTest {

    @Test
    public void test() throws Exception {
        ShortestPath shortestPath = new ShortestPath(6);
        shortestPath.add(0, 1, 10);
        shortestPath.add(0, 4, 15);
        shortestPath.add(4, 5, 10);
        shortestPath.add(1, 2, 15);
        shortestPath.add(1, 3, 2);
        shortestPath.add(2, 5, 5);
        shortestPath.add(3, 5, 12);
        shortestPath.add(3, 2, 1);
        String dist = shortestPath.dijkstra(0, 5);
        assertEquals(dist, "5<-2<-3<-1");
    }

    @Test
    public void test2() throws Exception {
        ShortestPath2 shortestPath = new ShortestPath2(6);
        shortestPath.add(0, 1, 10);
        shortestPath.add(0, 4, 15);
        shortestPath.add(4, 5, 10);
        shortestPath.add(1, 2, 15);
        shortestPath.add(1, 3, 2);
        shortestPath.add(2, 5, 5);
        shortestPath.add(3, 5, 12);
        shortestPath.add(3, 2, 1);
        String dist = shortestPath.dijkstra(0, 5);
        assertEquals(dist, "5<-2<-3<-1");
    }
}
