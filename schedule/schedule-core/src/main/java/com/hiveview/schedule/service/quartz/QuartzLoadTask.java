package com.hiveview.schedule.service.quartz;

import com.hiveview.base.util.IpUtils;
import com.hiveview.schedule.job.JobDubboServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 加载可执行的任务
 * 
 * @author CMM
 *
 *         2016年4月6日 下午7:15:30
 */
@Service
public class QuartzLoadTask {
	
	private final static Logger logger = LoggerFactory.getLogger(QuartzLoadTask.class);
	
	@Autowired
	private QuartzJobService quartzJobService;
	
	//@Autowired
//	private ScheduleJobService scheduleJobService;
	
	/**
	 * 在项目启动时,初始化需要执行的任务
	 * @throws Exception
	 */
	@PostConstruct
	public void initTask() throws Exception {
		
		//执行job的IP
		String jobIp = IpUtils.getRealIp();
		if(StringUtils.isEmpty(jobIp)){
			logger.error("Job初始化失败，获取不到服务IP。");
			return ;
		}
		
		// 这里从数据库中获取任务信息数据
		HashMap<String, Object> params = new HashMap<String, Object>();
//		params.put("jobStatus", ScheduleJob.STATUS_RUNNING);
//		List<ScheduleJob> jobList = scheduleJobService.findByBiz(params);
//		//List<ScheduleJob> jobList = getTestJob();
//		//List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
//
//		if(null == jobList || jobList.size() == 0){
//			return ;
//		}
//
//		for (ScheduleJob job : jobList) {
//			if(jobIp.equals(job.getRemarks())){//控制只有配置好的IP才能执行
//				//添加泛化服务对象到Map
//				if(ScheduleJob.DUBBO_IS.equals(job.getIsDubboService())){
//					try {
//						JobDubboServiceUtils.setService(job);
//					} catch (Exception e) {
//						logger.error("泛化获取Dubbo服务错误!!!!job的id：" + job.getId(), e);
//						continue ;
//					}
//				}
//
//				//添加任务
//				quartzJobService.addJob(job);
//			}
//		}
	}
	
//	/**
//	 * 测试数据
//	 * @return
//	 */
//	private List<ScheduleJob> getTestJob(){
//
//		List<ScheduleJob> testList = new ArrayList<ScheduleJob>();
//
//		//普通javaBean
//		ScheduleJob job1 = new ScheduleJob();
//		job1.setJobGroup("base-data");
//		job1.setJobName("javaBean1");
//
//		job1.setBeanClass("com.ffzx.basedata.job.TestBeanJob");
//		//job1.setSpringId("");
//		job1.setMethodName("exe");
//
//		job1.setCronExpression("0/5 * * * * ?");
//
//		job1.setIsConcurrent("1");//无状态
//		job1.setJobStatus("1");//启动
//
//		job1.setDescription("testBean desc");
//		testList.add(job1);
//
//
//
//		//springBean
//		ScheduleJob job2 = new ScheduleJob();
//		job2.setJobGroup("base-data");
//		job2.setJobName("springBean1");
//
//		//job2.setBeanClass("");
//		job2.setSpringId("testSpringBeanJob");
//		job2.setMethodName("exe");
//
//		job2.setCronExpression("0/5 * * * * ?");
//
//		job2.setIsConcurrent("0");//有状态
//		job2.setJobStatus("1");//启动
//
//		job2.setDescription("testBean desc");
//		testList.add(job2);
//
//
//		return testList;
//	}
}
