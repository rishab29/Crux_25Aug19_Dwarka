package Lecture11;

import Lecture10.QueueUsingArrays;

public class DynamicQueue extends QueueUsingArrays {

	public DynamicQueue() throws Exception {
		this(DEFAULT_CAPACITY);
	}

	public DynamicQueue(int capacity) throws Exception {
		super(capacity);
	}

	public void enqueue(int element) throws Exception {
		if(this.data.length==this.size()) {
			int[] arr=new int[2*this.data.length];
			for(int i=0;i<this.size();i++) {
				int ai=(this.front+i)%this.data.length;
				arr[i]=this.data[ai];
			}
			
			this.data=arr;
			this.front=0;
		}
		
		super.enqueue(element);
  	}

}
