class MinStack {
    int min;
    Deque<Integer> deque;
    
    /** initialize your data structure here. */
    public MinStack() {
        deque = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            deque.push(min);
            min=x;
        }
        deque.push(x);
    }
    
    public void pop() {
        if(deque.pop()==min)
            min=deque.pop();
    }
    
    public int top() {
        return deque.getFirst();
    }
    
    public int getMin() {
        return min;
    }
}
