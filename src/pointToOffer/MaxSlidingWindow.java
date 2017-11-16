package pointToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 */
public class MaxSlidingWindow
{
    public static void main(String[] args)
    {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.pushBack(5);
        queue.pushBack(3);
        queue.pushBack(4);
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
    }

    public static int[] maxInWindows(int[] data, final int size)
    {
        if (data == null || data.length == 0 || data.length < size)
        {
            return new int[0];
        }
        int[] result = new int[data.length - size + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < size - 1; i++)
        {
            while (!deque.isEmpty() && data[i] >= data[deque.getLast()]) deque.removeLast();
            deque.addLast(i);
        }
        for (int i = size - 1; i < data.length; i++)
        {
            while (!deque.isEmpty() && i - deque.getFirst() + 1 > size) deque.removeFirst();//滑动窗口已经滑过first

            while (!deque.isEmpty() && data[deque.getLast()] <= data[i]) deque.removeLast();

            deque.addLast(i);
            result[i - (size - 1)] = data[deque.getFirst()];
        }
        for (int i : result)
        {
            System.out.print(i + ",");
        }
        return result;
    }


    /**
     * 队列中的最大值
     * @param <T>
     */
    public static class QueueWithMax<T extends Comparable>
    {
        private Deque<InternalData<T>> queueData;
        private Deque<InternalData<T>> queueMax;
        private int currentIndex;

        public QueueWithMax()
        {
            this.queueData = new ArrayDeque<>();
            this.queueMax = new ArrayDeque<>();
            this.currentIndex = 0;
        }

        public T max()
        {
            if (queueMax.isEmpty())
            {
                return null;
            }
            return queueMax.getFirst().value;
        }

        public void pushBack(T value)
        {
            while (!queueMax.isEmpty() && value.compareTo(queueMax.getLast().value) >= 0) queueMax.removeLast();
            InternalData<T> addData = new InternalData<>(value, currentIndex);
            queueMax.addLast(addData);
            queueData.addLast(addData);
            currentIndex++;
        }

        public T popFront()
        {
            if (queueData.isEmpty())
            {
                return null;
            }
            InternalData<T> delData = queueData.removeFirst();
            if (delData.index == queueMax.getFirst().index)
            {
                queueMax.removeFirst();
            }
            return delData.value;
        }

        private static class InternalData<M extends Comparable>
        {
            public M value;
            public int index;

            public InternalData(M value, int index)
            {
                this.value = value;
                this.index = index;
            }
        }
    }
}
