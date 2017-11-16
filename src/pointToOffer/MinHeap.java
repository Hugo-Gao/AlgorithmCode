package pointToOffer;

public class MinHeap extends Heap
{

    public MinHeap(int[] data)
    {
        super(data);
    }

    public MinHeap()
    {
        super();
    }

    @Override
    public Heap buildHeap()
    {
        int node = getParentIndex(length - 1);
        for (; node >= 0; node--)
        {
            adjustDownHeap(node);
        }
        return this;
    }

    @Override
    public int remove()
    {
        int target = data[0];
        swap(0, length - 1);//将最后一个与堆顶交换
        int[] newData = new int[length - 1];
        System.arraycopy(data, 0, newData, 0, length - 1);
        this.data = newData;
        this.length--;
        adjustDownHeap(0);
        return target;
    }

    @Override
    public Heap insert(int value)
    {
        int[] newData = new int[length + 1];
        System.arraycopy(data, 0, newData, 0, length);
        newData[length] = value;
        this.data=newData;
        length++;
        adjustUpHeap(length-1);
        return this;
    }

    @Override
    public void adjustDownHeap(int node)
    {
        int left = getLeftChildIndex(node);
        int right = getRightChildIndex(node);
        int min = node;
        if (left < length && data[min] > data[left])
        {
            min = left;
        }
        if (right < length && data[min] > data[right])
        {
            min = right;
        }
        if (min != node)
        {
            swap(node, min);
            adjustDownHeap(min);
        }
    }

    @Override
    public void adjustUpHeap(int node)
    {
        int parent = getParentIndex(node);
        if (parent >= 0 && data[parent] > data[node])
        {
            swap(node, parent);
            adjustUpHeap(parent);
        }
    }
}
