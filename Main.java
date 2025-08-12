import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n====== Task Prioritization App ======");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Highest Priority Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Search Task by Description");
            System.out.println("6. Clear All Tasks");
            System.out.println("7. Count Total Tasks");
            System.out.println("8. View Completed Tasks");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter priority (lower = higher): ");
                    int prio = sc.nextInt();
                    sc.nextLine();
                    manager.addTask(desc, prio);
                    break;
                case 2:
                    manager.removeHighestPriorityTask();
                    break;
                case 3:
                    manager.viewAllTasks();
                    break;
                case 4:
                    System.out.print("Enter description to mark as completed: ");
                    String completeDesc = sc.nextLine();
                    manager.markTaskAsCompleted(completeDesc);
                    break;
                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    manager.searchTask(keyword);
                    break;
                case 6:
                    manager.clearAllTasks();
                    break;
                case 7:
                    manager.countTasks();
                    break;
                case 8:
                    manager.viewCompletedTasks();
                    break;
                case 9:
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
