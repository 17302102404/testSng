package com.czx.trains.model;

import java.util.List;

public class TrainPassRoute {
	private boolean reachable;//是否可达  
    private int passStep;//路线步长  
    private List<Integer> step;//路线距离
    
	public boolean getReachable() {
		return reachable;
	}
	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
	public int getPassStep() {
		return passStep;
	}
	public void setPassStep(int passStep) {
		this.passStep = passStep;
	}
	public List<Integer> getStep() {
		return step;
	}
	public void setStep(List<Integer> step) {
		this.step = step;
	}
    
    
}
