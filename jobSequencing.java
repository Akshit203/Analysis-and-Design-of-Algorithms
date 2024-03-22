import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class jobSequencing {
    static void printJobSequence(Job[] jobs) {

        // Sort the jobs based on profit in non-increasing order using bubble sort
        for (int i = 0; i < jobs.length - 1; i++) {
            for (int j = 0; j < jobs.length - i - 1; j++) {
                if (jobs[j].profit < jobs[j + 1].profit) {
                    Job temp = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = temp;
                }
            }
        }

        // maximum deadline 
        int maxDeadline = 0;
        for (int i = 0; i < jobs.length; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        // Initialize an array to store the result job sequence
        char[] result = new char[maxDeadline];
        for (int i = 0; i < result.length; i++) {
            result[i] = ' ';
        }

        boolean[] slot = new boolean[maxDeadline];

        // Traverse through all the jobs and fill the result array
        for (int i = 0; i < jobs.length; i++) {
            // Find a slot for this job (from its deadline to 0)
            for (int j = Math.min(maxDeadline, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }

        System.out.println("Job Sequence:");
        for (char c : result) {
            if (c != ' ') {
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[5];
        jobs[0] = new Job('A', 2, 100);
        jobs[1] = new Job('B', 1, 19);
        jobs[2] = new Job('C', 2, 27);
        jobs[3] = new Job('D', 1, 25);
        jobs[4] = new Job('E', 3, 15);

        printJobSequence(jobs);
    }
}

