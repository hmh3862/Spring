package kr.green.boot;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class ScheduledJob extends QuartzJobBean{
 
    private AnotherBean anotherBean; 
     
    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        anotherBean.printAnotherMessage();
    }

	public AnotherBean getAnotherBean() {
		return anotherBean;
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}
    
    
}