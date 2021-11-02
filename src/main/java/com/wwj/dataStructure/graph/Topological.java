package com.wwj.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 拓扑排序
 * 时间复杂度：O(V+E) v顶点，e边
 * auth sherry
 * data created in 2021/10/22 5:48 下午
 */
public class Topological {
    private int v;//顶点个数
    private List<Integer> adj[];

    public Topological(int v) {
        this.v = v;
        this.adj = new ArrayList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    /**
     * s->t s先于t
     */
    public void add(int s, int t) {
        adj[s].add(t);
    }

    /**
     * 拓扑排序
     * s->t s先于t
     */
    public String sortByKahn() {
        int inDeep[] = new int[v];
        for (int s = 0; s < adj.length; s++) {
            for (int i = 0; i < adj[s].size(); i++) {
                int t = adj[s].get(i);
                inDeep[t]++;
            }
        }

        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(v);

        for (int i = 0; i < inDeep.length; i++) {
            if (inDeep[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer point = queue.remove();
            sb.append("->").append(point);
            for (int i = 0; i < adj[point].size(); i++) {
                Integer child = adj[point].get(i);
                inDeep[child]--;
                if (inDeep[child] == 0) {
                    queue.add(child);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 拓扑排序
     * s->t s依赖t
     *
     * @return 排序后str
     */
    public String sortByDFS() {
        List<Integer> vertexArray[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            vertexArray[i] = new ArrayList<>();
        }

        for (int s = 0; s < adj.length; s++) {
            for (int i = 0; i < adj[s].size(); i++) {
                Integer t = adj[s].get(i);
                vertexArray[t].add(s);
            }
        }

        Boolean visited[] = new Boolean[v];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexArray.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, vertexArray, visited,sb);
            }
        }
        return sb.toString();
    }

    private void dfs(int vertex, List<Integer> vertexArray[], Boolean visited[],StringBuilder sb) {
        for (int i = 0; i < vertexArray[vertex].size(); i++) {
            Integer w = vertexArray[vertex].get(i);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, vertexArray, visited,sb);
        }
//        System.out.print("->" + vertex);
        sb.append("->").append(vertex);
    }
}
