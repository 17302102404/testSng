package czx_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.czx.trains.model.TrainMinRoute;
import com.czx.trains.model.TrainPassRoute;
import com.czx.trains.service.TrainDistance;
import com.czx.trains.service.impl.TrainDistanceImpl;

public class TestTrainProble {
	
	final static HashMap<Integer, HashMap<Integer,Integer>> stepLength = new HashMap<Integer, HashMap<Integer,Integer>>();
	static{
		HashMap<Integer,Integer> step1 = new HashMap<Integer, Integer>();  
	    stepLength.put(1, step1);  
	    step1.put(2, 5);  
	    step1.put(4, 5);  
	    step1.put(5, 7);  
	      
	    HashMap<Integer,Integer> step2 = new HashMap<Integer, Integer>();  
	    stepLength.put(2, step2);  
	    step2.put(3, 4); 
	      
	    HashMap<Integer,Integer> step3 = new HashMap<Integer, Integer>();  
	    stepLength.put(3, step3);  
	    step3.put(4, 8);  
	    step3.put(5, 2);  

	      
	    HashMap<Integer,Integer> step4 = new HashMap<Integer, Integer>();  
	    stepLength.put(4, step4);  
	    step4.put(3, 8);  
	    step4.put(5, 6);  

	      
	    HashMap<Integer,Integer> step5 = new HashMap<Integer, Integer>();  
	    stepLength.put(5, step5);  
	    step5.put(2, 3); 
	}
	
	/**
	 * 
	 * @param List param
	 * @return Object
	 * @Description:指定路线的输出距离
	 */
	private Object passStepprint(List param){
		TrainDistance distance = new TrainDistanceImpl(); 
	    TrainPassRoute  trainPassRoute = distance.calTrainPassRoute(param,stepLength);
	    if(!trainPassRoute.getReachable()){
	    	return "没有这样的路径";
	    }else{
	    	return trainPassRoute.getPassStep();
	    }
	} 
	
	/**
	 * 
	 * @param List param
	 * @return Object
	 * @Description:两点之间的最短距离问题
	 */
	private Object minStepprint(int start, int end, final HashMap<Integer, HashMap<Integer, Integer>> stepLength){
		TrainDistance distance = new TrainDistanceImpl(); 
	    TrainMinRoute  trainMinRoute = distance.getMinStep(start,end,stepLength);
	    if(!trainMinRoute.getReachable()){
	    	return "没有这样的路径";
	    }else{
	    	return trainMinRoute.getMinStep();
	    }
	} 
	
	
	/**
	 * @Author:czx  
	 * @Description: 测试A-B-C的距离 
	 */
	@Test
	public void test1(){
	    List param = new ArrayList<Integer>();
	    param.add(1);
	    param.add(2);
	    param.add(3);
	    System.out.println(passStepprint(param).toString());
	}


	/**
	 * @Author:czx  
	 * @Description: 测试A-D距离
	 */
	@Test
	public void test2(){
	    List param = new ArrayList<Integer>();
	    param.add(1);
	    param.add(4);
	    System.out.println(passStepprint(param).toString());
	}
	/**
	 * @Author:czx  
	 * @Description: 测试A-D—C距离 
	 */
	@Test
	public void test3(){
	    List param = new ArrayList<Integer>();
	    param.add(1);
	    param.add(4);
	    param.add(3);
	    System.out.println(passStepprint(param).toString());
	}
	/**
	 * @Author:czx  
	 * @Description: 测试A-E-B-C-D的距离 
	 */
	@Test
	public void test4(){
	    List param = new ArrayList<Integer>();
	    param.add(1);
	    param.add(5);
	    param.add(2);
	    param.add(3);
	    param.add(4);
	    System.out.println(passStepprint(param).toString());
	}
	/**
	 * @Author:czx  
	 * @Description: 测试A-E-D的距离
	 */
	@Test
	public void test5(){
	    List param = new ArrayList<Integer>();
	    param.add(1);
	    param.add(5);
	    param.add(4);
	    System.out.println(passStepprint(param).toString());
	}
	/**
	 * @Author:czx  
	 * @Description: start 到 end 的最短距离 
	 */
	@Test
	public void test6(){

	}
	/**
	 * @Author:czx  
	 * @Description: start 到 end 的最短距离 
	 */
	@Test
	public void test7(){
		
	}
	/**
	 * @Author:czx  
	 * @Description: start 到 end 的最短距离 
	 */
	@Test
	public void test8(){
		int start = 1;
		int end = 3;
		System.out.println(minStepprint(start, end, stepLength));
	}
	/**
	 * @Author:czx  
	 * @Description: A-C的最短路径求解 
	 */
	@Test
	public void test9(){
		int start = 2;
		int end = 2;
		System.out.println(minStepprint(start, end, stepLength));
	}
	
	/**
	 * @Author:czx  
	 * @Description: start 到 end 的最短距离 
	 */
	@Test
	public void test10(){
		
	}

	  
}
