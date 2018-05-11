package com.cn.base.quartz;

import java.util.Date;

import org.apache.log4j.Logger;

public class QuartzJob {

	private static Logger logger = Logger.getLogger(QuartzJob.class);

	/**
	 * @Description: 任务执行获取token
	 * @param
	 */
	public void workForToken() {
		try {
			System.out.println("定时任务开始！");
			System.out.println(new Date());
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}
