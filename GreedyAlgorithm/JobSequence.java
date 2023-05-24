import java.util.*;

public class JobSequence {
    // Define a nested class Job to represent each job
    static class Job {
        int deadline; // Deadline of the job
        int profit; // Profit of the job
        int Job_id; // Job ID

        // Constructor to initialize the job attributes
        public Job(int i, int d, int p) {
            Job_id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int[][] jobsInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } }; // 2D Array with (Deadline, Profit)

        ArrayList<Job> jobs = new ArrayList<>();

        // Create Job objects and add them to the jobs list
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort the jobs in descending order of profit using a lambda expression
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>(); // List to store the selected job sequence
        int time = 0; // Current time or slot

        // Iterate through the sorted jobs
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.Job_id); // Add the job ID to the sequence
                time++;
            }
        }

        // Print the result
        System.out.println("Maximum job = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
