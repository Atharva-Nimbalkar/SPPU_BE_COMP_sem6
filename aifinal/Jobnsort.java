package atharva.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jobnsort{

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

    // Method to perform selection sort
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to print an array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method to run the combined program
    public static void main(String[] args) {
        System.out.println("Welcome to the Job Sequencing Program!");

        // Prompt user to choose between job scheduling and sorting
        System.out.println("Choose an option:");
        System.out.println("1. Job Scheduling");
        System.out.println("2. Sorting");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Job Scheduling
            System.out.println("Enter the total number of jobs:");
            int N = scanner.nextInt();

            // Create an ArrayList to store Job objects
            ArrayList<Job> jobs = new ArrayList<>(N);

            // Get job details from the user
            for (int i = 0; i < N; i++) {
                System.out.println("Enter details for job " + (i + 1) + ":");
                System.out.println("Enter job ID for job " + (i + 1) + ":");
                String jobID = scanner.next();
                System.out.println("Enter deadline for job " + (i + 1) + ":");
                int deadline = scanner.nextInt();
                System.out.println("Enter profit for job " + (i + 1) + ":");
                int profit = scanner.nextInt();
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
        } else if (choice == 2) {
            // Sorting
            Jobnsort ob = new Jobnsort();

            System.out.println("Enter the number of elements in the array:");
            int size = scanner.nextInt();

            int arr[] = new int[size];

            System.out.println("Enter the elements of the array:");

            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            ob.sort(arr);

            System.out.println("Sorted array:");
            ob.printArray(arr);
        } else {
            System.out.println("Invalid choice.");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}

