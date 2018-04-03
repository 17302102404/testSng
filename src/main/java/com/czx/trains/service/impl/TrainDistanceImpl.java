package com.czx.trains.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import com.czx.trains.model.TrainMinRoute;
import com.czx.trains.model.TrainPassRoute;
import com.czx.trains.model.TrainPreNode;
import com.czx.trains.service.TrainDistance;

public class TrainDistanceImpl implements TrainDistance{
	    private HashMap<Integer, HashMap<Integer, Integer>> stepLength;  
	    //非独立节点个数  
	    private int nodeNum;  
	    //移除节点  
	    private HashSet<Integer> outNode;  
	    //起点到各点的步长，key为目的节点，value为到目的节点的步长  
	    private HashMap<Integer, TrainPreNode> nodeStep;  
	    //下一次计算的节点  
	    private LinkedList<Integer> nextNode;  
	    //起点、终点  
	    private int startNode;  
	    private int endNode;  
	      
	    /** 
	     * @param start 
	     * @param end 
	     * @param stepLength 
	     * @return 
	     * @Author:czx  
	     * @Description: start 到 end 的最短距离 
	     */  
	    public TrainMinRoute getMinStep(int start, int end, final HashMap<Integer, HashMap<Integer, Integer>> stepLength) {  
	        this.stepLength = stepLength;  
	        this.nodeNum = this.stepLength != null ? this.stepLength.size() : 0;  
	        //起点、终点不在目标节点内，返回不可达  
	        if (this.stepLength == null || (!this.stepLength.containsKey(start)) || (!this.stepLength.containsKey(end))) {  
	            return UNREACHABLE;  
	        }  
	        initProperty(start, end);  
	        step();  
	        if (nodeStep.containsKey(end)) {  
	            return changeToMinStep();  
	        }  
	        return UNREACHABLE;  
	    }  
	      
	    /** 
	     * 返回最短距离以及路径 
	     */  
	    private TrainMinRoute changeToMinStep() {  
	    	TrainMinRoute minStep = new TrainMinRoute();  
	        minStep.setMinStep(nodeStep.get(endNode).getNodeStep());  
	        minStep.setReachable(true);  
	        return minStep;  
	    }  
	      
	    /** 
	     * @param start 
	     * @Author:czx  
	     * @Description: 初始化属性 
	     */  
	    private void initProperty(int start, int end) {  
	        outNode = new HashSet<Integer>();  
	        nodeStep = new HashMap<Integer, TrainPreNode>();  
	        nextNode = new LinkedList<Integer>();  
	        nextNode.add(start);  
	        startNode = start;  
	        endNode = end;  
	    }  
	      
	    /** 
	     * @param end 
	     * @Author:czx 
	     * @Description: 
	     */  
	    private void step() {  
	    	if(nextNode.size()==1 && nextNode.get(0)== endNode && outNode.size()>0){
	    		return;
	    	}
	        if (nextNode == null || nextNode.size() < 1) {  
	            return;  
	        }  
	        if (outNode.size() == nodeNum) {  
	            return;  
	        }  
	        //获取下一个计算节点  
	        int start = nextNode.removeFirst();  
	        //到达该节点的最小距离  
	        int step = 0;  
	        if (nodeStep.containsKey(start)) {  
	            step = nodeStep.get(start).getNodeStep();  
	        }  
	        //获取该节点可达节点  
	        HashMap<Integer,Integer> nextStep = stepLength.get(start);  
	        Iterator<Entry<Integer, Integer>> iter = nextStep.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Entry<Integer, Integer> entry = iter.next();  
	            Integer key = entry.getKey();  
//	            //如果是起点到起点，不计算之间的步长  
//	            if (key == startNode) {  
//	                continue;  
//	            }  
	            //起点到可达节点的距离  
	            Integer value = entry.getValue() + step;  
	            if ((!nextNode.contains(key)) && (!outNode.contains(key))) {  
	                nextNode.add(key);  
	            }  
	            if (nodeStep.containsKey(key)) {  
	                if (value < nodeStep.get(key).getNodeStep()) {  
	                    nodeStep.put(key, new TrainPreNode(start, value));  
	                }  
	            } else {  
	                nodeStep.put(key, new TrainPreNode(start, value));  
	            }  
	        }  
	        //将该节点移除  
	        outNode.add(start);  
	        //计算下一个节点  
	        step();  
	    } 
	    
	
	    
	    /**
	     * @param end 
	     * @Author:czx  
	     * @Description: 校验连个节点之间是否可达
	     */
	    private  boolean chargeReached(int start,int end,final HashMap<Integer, HashMap<Integer, Integer>> stepLength){
	    	HashMap<Integer, Integer> nextNode = stepLength.get(start);
	    	if(nextNode.containsKey(end)){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }

	    /**
	     * @param end 
	     * @Author:czx  
	     * @Description: 就算各个点之间的距离
	     */
		public TrainPassRoute calTrainPassRoute(List<Integer> routes,final HashMap<Integer, HashMap<Integer, Integer>> stepLength) {
			TrainPassRoute trainPassRoute = new TrainPassRoute();
	    	int passStep = 0;
	    	List<Integer> step = new ArrayList<Integer>();
	    	Boolean flag =true;
	    	if(routes==null){
	    		return null;
	    	}
	    	for(int i=0;i<routes.size();i++){
	    		if(i<routes.size()-1){
	    			if(chargeReached(routes.get(i),routes.get(i+1),stepLength)){
	    				passStep+= stepLength.get(routes.get(i)).get(routes.get(i+1));
	    				step.add(stepLength.get(routes.get(i)).get(routes.get(i+1)));
	    			}else{
	    				flag = false;
	    				break;
	    			}
	    		}	    		
	    	}
	    	if(flag){
	    		trainPassRoute.setReachable(true);
	    		trainPassRoute.setPassStep(passStep);
	    		trainPassRoute.setStep(step);
	    	}
	    	return trainPassRoute;
		}
		

}
