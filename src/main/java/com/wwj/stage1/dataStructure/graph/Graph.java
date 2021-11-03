package com.wwj.stage1.dataStructure.graph;

import java.util.LinkedList;

/**
 * 无向图
 * auth sherry
 * data created in 2021/9/18 2:42 下午
 */
public class Graph {

    /**
     * 顶点的数目
     */
    private int v;

    /**
     * 顶及边元素
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
    }

    /**
     * @param s 顶点
     * @param t 对应的边
     */
    public void add(int s, int t) {
        if (s > v) {
            throw new IllegalArgumentException("value must less than " + s);
        }
        adj[s].add(t);
        adj[t].add(s);

    }

    /**
     * s 到 t的路径(广度优先)
     *
     * @param s 顶点s
     * @param t 顶点t
     */
    public void bfs(int s, int t) {
        //已经访问的顶点
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //已访问，但是邻边未访问的的顶点
        LinkedList<Integer> visitedList = new LinkedList<>();
        visitedList.add(s);
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        while (visitedList.size() != 0) {
            int w = visitedList.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i);
                if (!visited[p]) {

                    visited[p] = true;
                    visitedList.add(p);
                    if (s == t) {
                        // TODO: 2021/9/18
                        return;
                    }
                }
            }
        }
    }
}
