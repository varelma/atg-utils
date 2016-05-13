package org.varelma.oc.service;

import atg.nucleus.ServiceException;

import atg.service.scheduler.Schedule;
import atg.service.scheduler.ScheduledJob;
import atg.service.scheduler.Scheduler;
import atg.service.scheduler.SingletonSchedulableService;


/**
 * Simple service that should be used to create basic services.  Hides a good
 * deal of the complexity of developing a scheduled service.
 * This service will only run on one server in a cluster.
 * 
 * @see atg.nucleus.GenericService
 * @author jon pallas
 */
 
public abstract class AbstractSingletonSchedulableService extends SingletonSchedulableService implements SimpleSchedulableService {
    private boolean mIsAlreadyRunning;
    private Scheduler scheduler;
    private Schedule schedule;
    private int jobId;
    private String jobName;
    private String jobDescription;

    /**
     * Simple service that should be used to create singleton services.  Hides a good
     * deal of the complexity of developing a scheduled service.
     *
     * @see atg.nucleus.GenericService
     */
    public AbstractSingletonSchedulableService() {
    }

    private synchronized boolean isAlreadyRunning() {
        return mIsAlreadyRunning;
    }

    private synchronized void setAlreadyRunning(boolean isAlreadyRunning) {
        mIsAlreadyRunning = isAlreadyRunning;
    }

    /** method that must be overriden by subclasses */
    public abstract void doScheduledTask();

    /** interface method which is called by the scheduler */
    public void doScheduledTask(Scheduler scheduler, ScheduledJob scheduledJob) {
        doScheduledTask();
    }

    /** interface method which is called by the scheduler */
     public void performScheduledTask(Scheduler scheduler, ScheduledJob scheduledJob) {
        if (isAlreadyRunning()) {
            return;
        } else {
            setAlreadyRunning(true);

            try {
                doScheduledTask();
            } finally {
                setAlreadyRunning(false);
            }
        }
    }

    /** @returns the jobname property */
    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String pJobName) {
        this.jobName = pJobName;
    }

    /** @returns the job description property */
    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String pJobDescription) {
        this.jobDescription = pJobDescription;
    }

    /** @returns the scheduler property */
    public Scheduler getScheduler() {
        return scheduler;
    }

    /** sets the scheduler property */
    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /** @returns the schedule time property */
    public Schedule getSchedule() {
        return schedule;
    }

    /** sets the schedule property - which specifies how and when this task is to be executed */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /** return this scheduled tasks job id */
    public int getJobId() {
        return jobId;
    }

    /** set this tasks job id */
    private void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /** Interface method.  Initialises the service when dynamo boots. */
    public void doStartService() throws ServiceException {
        ScheduledJob job = new ScheduledJob(this.getJobName(), this.getJobDescription(), getAbsoluteName(), getSchedule(), this, ScheduledJob.SEPARATE_THREAD);

        if (job != null) {
            setJobId(getScheduler().addScheduledJob(job));
        }  
    }

    /** The other interface method.  Called when dynamo is shut down gracefully. */
    public void doStopService() throws ServiceException {
        getScheduler().removeScheduledJob(getJobId());
    }
}
