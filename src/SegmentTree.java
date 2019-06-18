/**
 * Created by Hobbes on 7/24/17.
 */

public class SegmentTree {
    void constructTree(int[] input, int[] segmentTree, int low, int high, int pos){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructTree(input, segmentTree,low, mid, 2 * pos + 1);
        constructTree(input, segmentTree,mid, high, 2 * pos + 1);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2*pos + 2]);
    }
    int rangeminquery(int[] segTree, int qlow, int qhigh, int high, int low, int pos){
        if(qlow <= low && qhigh >= high){ // total overlap
            return segTree[pos];
        }

        if(qlow > high || qhigh < low){ // no overlap
            return Integer.MAX_VALUE;
        }

        int mid = (low + high) / 2;
        return Math.min(rangeminquery(segTree,qlow,qhigh,low,mid, 2 *pos + 1),
                    rangeminquery(segTree, qlow, qhigh, mid, high, 2 * pos + 2));
    }
}
