package com.wwj.stage1.dynamicProgramming.shortestPath;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 最短路径：
 * 求：地图上两个点最短路径
 * 动态规划
 * 时间复杂度：todo
 * auth sherry
 * data created in 2021/10/24 10:48 下午
 */
@Data
public class ShortestPath2 {
    //顶点个数
    private int v;
    //表示每个节点对应的有几条路
    private List<Edge>[] roads;

    public ShortestPath2(int v) {
        this.v = v;
        this.roads = new List[v];
        for (int i = 0; i < v; i++) {
            roads[i] = new ArrayList<>();
        }
    }

    /**
     * 添加节点
     *
     * @param start 起点
     * @param end   终点
     * @param dis   距离
     */
    public void add(int start, int end, int dis) {
        Edge edge = new Edge(start, end, dis);
        roads[start].add(edge);
    }

    /**
     * 计算2个点间最短距离
     *
     * @param start 起点
     * @param end   终点
     */
    public String dijkstra(int start, int end) {
        Vertex[] vertexNote = new Vertex[v];
        for (int i = 0; i < v; i++) {
            vertexNote[i] = new Vertex(i, Integer.MAX_VALUE);
        }

        int[] path = new int[v];

        Vertex startVertex = new Vertex(start, 0);
        vertexNote[start] = startVertex;


        PriorityQueue priorityQueue = new PriorityQueue(v);
        priorityQueue.add(startVertex);

        Vertex v = null;
        while ((v = priorityQueue.poll()) != null) {
            List<Edge> roadTos = roads[v.id];
            for (Edge road : roadTos) {
                int nextRoadIndex = road.end;
                int currentRoadIndex = road.start;
                Vertex nextVertex = vertexNote[nextRoadIndex];
                if (nextVertex.dist > vertexNote[currentRoadIndex].dist + road.dist) {
                    vertexNote[nextRoadIndex].dist = vertexNote[currentRoadIndex].dist + road.dist;
                    path[nextVertex.id] = vertexNote[currentRoadIndex].id;
                    if (priorityQueue.isHas(nextVertex)) {
                        priorityQueue.update(nextVertex);
                    } else {
                        priorityQueue.add(nextVertex);
                    }
                }
            }
        }
        return print(start, end, path);
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


    private class Edge {
        private int start;
        private int end;
        private int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    private class Vertex {
        private int id;
        private int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    /**
     * 根据vertex disc的优先级队列
     */
    private class PriorityQueue {
        private int count;
        private int capacity;
        private final Vertex[] vertexs;
        private final HashSet<Integer> set = new HashSet<>();


        private PriorityQueue(int capacity) {
            this.capacity = capacity;
            this.vertexs = new Vertex[capacity + 1];
            for (int i = 0; i < vertexs.length; i++) {
                Vertex vertex = new Vertex(i, 0);
                vertexs[i] = vertex;
            }
            this.count = 0;
        }

        private void add(Vertex vertex) {
            set.add(vertex.id);
            int index = ++count;
            vertexs[index] = vertex;
            while (vertexs[index / 2].dist > vertexs[index].dist) {
                if (index == 0) {
                    return;
                }
                swap(vertexs, index / 2, index);
                index = index / 2;
            }
        }

        /**
         * 更新节点
         *
         * @param vertex 顶点
         */
        private void update(Vertex vertex) {
            // TODO: 2021/11/1 可优化，根据id 进行hash存储
            for (int i = 0; i < vertexs.length; i++) {
                if (vertexs[i].id == vertex.id) {
                    vertexs[i] = vertex;
                }
            }
        }

        /**
         * 从队列中获取堆顶最小vertex
         *
         * @return Vertex
         */
        public Vertex poll() {
            if (count == 0) {
                return null;
            }
            Vertex vertex = vertexs[1];
            removeMin();
            return vertex;
        }

        /**
         * 移除堆顶元素
         */
        private void removeMin() {
            if (count == 0) {
                return;
            }
            set.remove(vertexs[1].id);
            int index = 1;
            vertexs[index] = vertexs[count];
            vertexs[count] = null;
            count--;

            while (2 * index <= count && 2 * index + 1 <= count) {
                int maxPos = index;
                if (vertexs[index].dist > vertexs[2 * index].dist) {
                    maxPos = 2 * index;
                }
                if (vertexs[maxPos].dist > vertexs[2 * index + 1].dist) {
                    maxPos = 2 * index + 1;
                }
                swap(vertexs, index, maxPos);
                index = maxPos;
            }

        }

        private void swap(Vertex[] vertexs, int a, int b) {
            Vertex vertex = vertexs[a];
            vertexs[a] = vertexs[b];
            vertexs[b] = vertex;
        }

        public boolean isHas(Vertex vertex) {
            return set.contains(vertex.id);
        }
    }
}
