import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExtendedJobSequence {

    // Define a Job class to represent each job with its deadline and profit
    static class Job {
        int deadline;
        int profit;
        String id;

        // Constructor to initialize the job details
        public Job(String i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Job Sequencing Program!");

        // Prompt user to enter the total number of jobs
        System.out.println("Enter the total number of jobs:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Create an ArrayList to store Job objects
        ArrayList<Job> jobs = new ArrayList<>(N);

        // Get job details from the user
        for (int i = 0; i < N; i++) {
            System.out.println("Enter details for job " + (i + 1) + ":");
            System.out.println("Enter job ID for job " + (i + 1) + ":");
            String jobID = in.next();
            System.out.println("Enter deadline for job " + (i + 1) + ":");
            int deadline = in.nextInt();
            System.out.println("Enter profit for job " + (i + 1) + ":");
            int profit = in.nextInt();
            jobs.add(new Job(jobID, deadline, profit));
        }

        // Sort the jobs in descending order based on profit
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        // Perform job sequencing based on deadlines and maximum profit
        ArrayList<String> seq = new ArrayList<>();
        int time = 0;
        int totalProfit = 0;

        // Initialize an array to store the final job sequence
        String[] finalJobSequence = new String[N];

        // Iterate through the sorted jobs and select jobs with deadlines
        // that allow them to be performed within the available time
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                finalJobSequence[time] = curr.id;
                time++;
                totalProfit += curr.profit;
            }
        }

        // Display the results
        System.out.println("The number of jobs that can be performed is: " + seq.size());
        System.out.println("The sequence of jobs to be performed: " + String.join(", ", seq));

        // Display the final job sequence with placeholders for unperformed jobs
        System.out.print("Final Job Sequence: ");
        for (int i = 0; i < finalJobSequence.length; i++) {
            if (finalJobSequence[i] == null) {
                System.out.print("Null");
            } else {
                System.out.print(finalJobSequence[i]);
            }
            if (i < finalJobSequence.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\nMaximum Profit: " + totalProfit);
    }
}
