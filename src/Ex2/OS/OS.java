package Ex2.OS;


import Ex2.Job.Job;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OS {

    /**
     * sleepingJobs - hashmap which represent jobs which put to sleep, grouped
     * by the time that they having left - HashMap<Long, Set<Job>>
     *
     * key: time left to sleep - Long
     * value: list of jobs to wake up in specified time left - Set<Job>
     */
    private static HashMap<Long, HashSet<Job>> sleepingJobs = new HashMap<>();
    private static Lock lock = new ReentrantLock(); // eliminate race condition on shared data - sleepingJobs

    /**
     * sleepingJobs getter.
     * @return hashmap of sleeping jobs - HashMap<Long, HashSet<Job>>
     */
    public static HashMap<Long, HashSet<Job>> getSleepingJobs() {
        return sleepingJobs;
    }

    /**
     * sleepingJobs setter.
     * @param sleepingJobs - new hashmap for updated sleeping jobs.
     */
    public static void setSleepingJobs(HashMap<Long, HashSet<Job>> sleepingJobs) {
        OS.sleepingJobs = sleepingJobs;
    }

    /**
     * add job to sleeping Jobs in appropriate group.
     * @param timeInMilliSeconds - length of the time the job need to sleep.
     * @param jobToSleep - the actual job
     */
    public static synchronized void putJobToSleep(Long timeInMilliSeconds, Job jobToSleep) {
        try {
            lock.lock();
            // add job to appropriate group of jobs, that need to wake up in same time:

            if(sleepingJobs.containsKey(timeInMilliSeconds)) {
                // there are jobs to be wake up in the exact time as current one.
                OS.getSleepingJobs().get(timeInMilliSeconds).add(jobToSleep);

            } else {
                // no other jobs to wake in the exact time - yet.
                HashSet<Job> newJobSet = new HashSet<>(); // creating empty set of jobs
                newJobSet.add(jobToSleep);
                OS.getSleepingJobs().put(timeInMilliSeconds, newJobSet );
            }

        } finally {
            lock.unlock();
        }
    }


    /**
     * reduce all keys of sleepingJobs by 1.
     */
    private synchronized void updateTimeLeftOfSleepingJobs() {
        HashMap<Long, HashSet<Job>> tempSleepingJobs = new HashMap<>();

        for (Long key : sleepingJobs.keySet()) {
            tempSleepingJobs.put(key - 1, sleepingJobs.remove(key));
        }

        setSleepingJobs(tempSleepingJobs);
    }

    /**
     * get all jobs which are ready to run and run them.
     * remove them from sleepingJobs.
     */
    public synchronized void awake() {
        try {
            lock.lock();

            // wake jobs that are ready:
            Set<Job> jobsToWakeUp = sleepingJobs.remove(0);

            /* run jobs which woke up */
            // Run, Forrest, Run!

            // update hashmap by decreasing each key by 1
            updateTimeLeftOfSleepingJobs();
        } finally {
            lock.unlock();
        }
    }

}
