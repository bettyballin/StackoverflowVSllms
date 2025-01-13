import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerConfigurator {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        JobDetail masterJobDetail = JobBuilder.newJob(MasterJob.class)
                .withIdentity("MasterJob")
                .build();

        CronTrigger masterTrigger = TriggerBuilder.newTrigger()
                .withIdentity("MasterJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?")) // daily at midnight
                .build();

        scheduler.scheduleJob(masterJobDetail, masterTrigger);
    }
}