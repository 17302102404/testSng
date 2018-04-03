package com.czx.trains.model;

import java.util.List;

public class TrainMinRoute {
	private boolean reachable;//是否可达  
    private int minStep;//最短步长  
    private List<Integer> step;//最短路径  
  
    public TrainMinRoute() {  
    }  
      
    public TrainMinRoute(boolean reachable, int minStep) {  
        this.reachable = reachable;  
        this.minStep = minStep;  
    }  
  
    public boolean getReachable() {  
        return reachable;  
    }  
    public void setReachable(boolean reachable) {  
        this.reachable = reachable;  
    }  
    public int getMinStep() {  
        return minStep;  
    }  
    public void setMinStep(int minStep) {  
        this.minStep = minStep;  
    }  
    public List<Integer> getStep() {  
        return step;  
    }  
    public void setStep(List<Integer> step) {  
        this.step = step;  
    }  
}
