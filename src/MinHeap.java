
/**
 *
 * @author OMER
 */
public class MinHeap {

    public int[] heapArray;
    public int size;
    public int maxSize;

    /**
     *
     * @param maxSize initialize size of the minHeap array
     */
    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heapArray = new int[this.maxSize + 1];

        this.heapArray[0] = Integer.MIN_VALUE;
    }

    /**
     * Mission: Shift the current mark to the right. Adds the data to the current sign index.
     * @param data To be added.
     * 
     */
    public void insertData(int data) {
        size += 1;
        heapArray[size] = data;

        int currentPosition = size;
        int parentPosition = getParent(currentPosition);

        while (heapArray[currentPosition] < heapArray[parentPosition]) {
            exchange(currentPosition, parentPosition);
            currentPosition = parentPosition;
            parentPosition = getParent(currentPosition);

        }
    }

    /**
     * Mission: Swapping data between parent and child.
     * @param childPosition
     * @param parentPosition 
     */
    public void exchange(int childPosition, int parentPosition) {
        int chidlValue = heapArray[childPosition];
        heapArray[childPosition] = heapArray[parentPosition];
        heapArray[parentPosition] = chidlValue;
    }

    /**
     * Mission: Getting minimum integer value from the heap. And Shrink minheap size.
     * @return minimum integer value
     */
    public int getMinValue() {
        int minVal = heapArray[1];
        heapArray[1] = heapArray[size];
        size -= 1;
        if (size == 0) {
            System.out.println(" End of the MinHeap");
        } else {
            downPerculate(1);
        }

        return minVal;
    }

    /**
     * Mission: If parent value is bigger than child than exchange data with smallest child data
     * @param position 
     */
    public void downPerculate(int position) {

        if (!isLeaf(position)) {
            int leftChild = getLeftChild(position);
            int rightChild = getRightChild(position);

            if (heapArray[position] > heapArray[leftChild] || heapArray[position] > heapArray[rightChild]) {
                if (heapArray[leftChild] < heapArray[rightChild]) {
                    exchange(leftChild, position);
                    downPerculate(leftChild);
                } else {
                    exchange(rightChild, position);
                    downPerculate(rightChild);
                }

            }

        }
    }

    /**
     * Mission: Returns parent of the position.
     * @param position
     * @return parent
     */
    public int getParent(int position) {

        return position / 2;
    }

    /**
     * Mission: Returns left child of the position.
     * @param positon
     * @return 
     */
    public int getLeftChild(int positon) {

        return positon * 2;
    }

    /**
     * Mission: Returns right child of the position.
     * @param position
     * @return 
     */
    public int getRightChild(int position) {

        return position * 2 + 1;
    }

    /**
     * Mission: If this position is leaf than returns true.
     * @param position
     * @return 
     */
    public boolean isLeaf(int position) {

        int halfSize = size / 2;
        return position > halfSize && position <= size;
    }
}
