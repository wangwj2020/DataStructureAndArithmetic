package com.wwj.stage1.test.拓扑;

import com.wwj.stage1.dataStructure.graph.Topological;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/10/22 11:02 下午
 */
class TopologicalTest {

    @Test
    public void test() throws Exception {
        Topological topological = new Topological(10);
        topological.add(1,3);
        topological.add(1,5);
        topological.add(5,8);
        topological.add(5,3);
        topological.add(6,1);

        String s = topological.sortByKahn();
        assertEquals("->0->2->4->6->7->9->1->5->8->3",s);

        s = topological.sortByDFS();
        assertEquals("->0->6->1->2->5->3->4->7->8->9",s);
    }
}
