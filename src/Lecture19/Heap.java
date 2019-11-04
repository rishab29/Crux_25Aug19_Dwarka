package Lecture19;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
	public ArrayList<T> data;
	public boolean isMin;

	public Heap() {
		this(false);
	}

	public Heap(boolean isMin) {
		this.data = new ArrayList<>();
		this.isMin = isMin;
	}
	
	public Heap(boolean isMin,T[] arr) {
		this(isMin);
		for(T value:arr) {
			this.data.add(value);
		}
		
		for(int i=(this.data.size()/2)-1;i>=0;i--) {
			this.downheapify(i);
		}
	}
	public int size() {
		return this.data.size();
	}
	
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public T getHP() {
		return this.data.get(0);
	}
	
	public void add(T data) {
		this.data.add(data);
		this.upheapify(this.data.size()-1);
	}
	
	public void upheapify(int ci) {
		if(ci==0) {
			return;
		}
		
		int pi=(ci-1)/2;
		if(!this.isLarger(pi, ci)) {
			this.swap(pi, ci);
			this.upheapify(pi);
		}
	}
	
	public boolean isLarger(int pi,int ci) {
		T parent=this.data.get(pi);
		T child=this.data.get(ci);
		
		if(this.isMin) {
			return parent.compareTo(child)<0;

		}else {
			return parent.compareTo(child)>0;
		}
	}
	
	public void swap(int pi,int ci) {
		T parent=this.data.get(pi);
		T child=this.data.get(ci);
		
		this.data.set(pi,child);
		this.data.set(ci, parent);
	}
	
	public T remove() {
		T rv=this.data.get(0);
		this.swap(0, this.data.size()-1);
		this.data.remove(this.data.size()-1);
		this.downheapify(0);
		return rv;
	}
	
	public void downheapify(int pi) {
		
		int lci=2*pi+1;
		int rci=2*pi+2;
		int mi=pi;
		
		if(lci<this.data.size()&&this.isLarger(lci, mi)) {
			mi=lci;
		}
		
		if(rci<this.data.size()&&this.isLarger(rci, mi)) {
			mi=rci;
		}
		
		if(mi!=pi) {
			this.swap(mi, pi);
			this.downheapify(mi);
		}
	}
	
	public void display() {
		this.display(0);
	}
	
	private void display(int pi) {
		int lci=2*pi+1;
		int rci=2*pi+2;
		
		String str="";
		if(lci<this.data.size()) {
			T lc=this.data.get(lci);
			str=str+lc+"=>";
		}else {
			str=str+"END=>";
		}
		
		str=str+this.data.get(pi);
		
		if(rci<this.data.size()) {
			T rc=this.data.get(rci);
			str=str+"<="+rc;
		}else {
			str=str+"<=END";
		}
		
		System.out.println(str);
		if(lci<this.data.size()) {
			this.display(lci);
		}
		
		if(rci<this.data.size()) {
			this.display(rci);
		}
	}
}
