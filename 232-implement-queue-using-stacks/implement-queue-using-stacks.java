class MyQueue {
    int[] arr;
    int front, rear, size;

    public MyQueue() {
        size = 100000;
        arr = new int[size];
        front = 0;
        rear = -1;
    }
    public void push(int x) {
        arr[++rear] = x;
    }
    public int pop() {
        return arr[front++];
    }
    public int peek() {
        return arr[front];
    }
    public boolean empty() {
        return front > rear;
    }
}