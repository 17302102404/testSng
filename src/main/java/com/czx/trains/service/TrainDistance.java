package com.czx.trains.service;

import java.util.HashMap;
import java.util.List;

import com.czx.trains.model.TrainMinRoute;
import com.czx.trains.model.TrainPassRoute;

public interface TrainDistance {
	
	public static final TrainMinRoute UNREACHABLE = new TrainMinRoute(false, -1); 
    /** 
     * @param start 
     * @param end 
     * @param stepLength 
     * @return 
     * @Author:czx  
     * @Description: 起点到终点的最短路径 
     */  
    public TrainMinRoute getMinStep(int start, int end, final HashMap<Integer, HashMap<Integer, Integer>> stepLength);  
    
    /** 
     * @param routes 
     * @param stepLength 
     * @return 
     * @Author:czx  
     * @Description: 路径距离
     */ 
    public TrainPassRoute calTrainPassRoute(List<Integer> routes,final HashMap<Integer, HashMap<Integer, Integer>> stepLength);
}
