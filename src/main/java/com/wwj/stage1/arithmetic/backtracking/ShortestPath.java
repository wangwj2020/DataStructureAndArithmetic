package com.wwj.stage1.arithmetic.backtracking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 最短路径：
 * 求：地图上两个点最短路径
 * 回溯法
 * 时间复杂度：O（E*log(v))
 * auth sherry
 * data created in 2021/10/24 10:48 下午
 */
@Data
public class ShortestPath {
    private int v;
    private List<Edge>[] roads;

    public ShortestPath(int v) {
        this.v = v;
        this.roads = new List[v];
        for (int i = 0; i < v; i++) {
            roads[i] = new ArrayList<>();
        }
    }

    /**
     * s点到t点距离
     *
     * @param s 起点
     * @param t 终点
     * @param w 距离
     */
    public void add(int s, int t, int w) {
        Edge edge = new Edge(s, t, w);
        roads[s].add(edge);
    }

    /**
     * 计算s到t到最短路径
     *
     * @param s 起点
     * @param t 终点
     */
    public String dijkstra(int s, int t) {
        Vertex vertexNodes[] = new Vertex[v];
        for (int i = 0; i < v; i++) {
            vertexNodes[i] = new Vertex(i, Integer.MAX_VALUE);
        }

        //记录最短路径
        int[] path = new int[v];
        Vertex currentVertex = new Vertex(s, 0);
        vertexNodes[s] = currentVertex;
        calMinPath(vertexNodes, path, currentVertex, t);
        String result = print(s, t, path);
        System.out.println(result);
        System.out.println("distance:" + vertexNodes[t].getDist());
        return result;
    }

    private void calMinPath(Vertex[] vertexArray, int[] path, Vertex currentVertex, int targetId) {
        int currentVertexId = currentVertex.getId();
        if (currentVertexId == targetId) {
            return;
        }
        for (int i = 0; i < roads[currentVertexId].size(); i++) {
            Edge edge = roads[currentVertexId].get(i);
            int nextVertexId = edge.getT();
            Vertex nextVertex = vertexArray[nextVertexId];
            if (nextVertex.dist > currentVertex.dist + edge.getW()) {
                vertexArray[nextVertexId].setDist(currentVertex.dist + edge.getW());
                path[nextVertexId] = currentVertexId;
            }
            calMinPath(vertexArray, path, nextVertex, targetId);
        }
    }

    private String print(int start, int target, int[] path) {
        StringBuilder sb = new StringBuilder();
        sb.append(target);
        while (path[target] != start) {
            sb.append("<-").append(path[target]);
            target = path[target];
        }
        return sb.toString();
    }


    @Data
    private static class Edge {
        //起点
        private int s;
        //终点
        private int t;
        //权重
        private int w;

        public Edge(int s, int t, int w) {
            this.s = s;
            this.t = t;
            this.w = w;
        }
    }

    @Data
    private static class Vertex {
        private int id;
        //起点到此点的距离
        private int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
