import java.util.*;

public class TaskManager {
    private PriorityQueue<Task> taskQueue;

    public TaskManager() {
        taskQueue = new PriorityQueue<>();
    }

    public void addTask(String description, int priority) {
        taskQueue.add(new Task(description, priority));
        System.out.println("✅ Task added Successfully.");
    }

    public void removeHighestPriorityTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("⚠️ No tasks to remove.");
        } else {
            Task removed = taskQueue.poll();
            System.out.println("🗑 Removed: " + removed);
        }
    }

    public void viewAllTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("📭 No tasks available.");
            return;
        }
        System.out.println("📋 Task List:");
        for (Task task : taskQueue) {
            System.out.println(task);
        }
    }

    public void markTaskAsCompleted(String description) {
        boolean found = false;
        for (Task task : taskQueue) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                System.out.println("✅ Task marked as completed.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("⚠️ Task not found.");
    }

    public void searchTask(String keyword) {
        boolean found = false;
        for (Task task : taskQueue) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) System.out.println("🔍 No tasks matched the keyword.");
    }

    public void clearAllTasks() {
        taskQueue.clear();
        System.out.println("🧹 All tasks cleared.");
    }

    public void countTasks() {
        System.out.println("📊 Total tasks: " + taskQueue.size());
    }

    public void viewCompletedTasks() {
        boolean found = false;
        for (Task task : taskQueue) {
            if (task.isCompleted()) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) System.out.println("❌ No completed tasks.");
    }
}
