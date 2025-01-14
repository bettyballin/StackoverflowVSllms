class Task:\n    def __init__(self, name):\n        self.name = name\n        self.status = "To Do"\n\nclass KanbanBoard:\n    def __init__(self):\n        self.tasks = []\n\n    def add_task(self, task_name):\n        task = Task(task_name)\n        self.tasks.append(task)\n\n    def move_task_to_next_stage(self, task_name):\n        for task in self.tasks:\n            if task.name == task_name:\n                if task.status == "To Do":\n                    task.status = "In Progress"\n                elif task.status == "In Progress":\n                    task.status = "Done"\n                print(f"Moved {task.name} to {task.status}")\n                return\n        print("Task not found.")\n\n    def display_tasks(self):\n        for task in self.tasks:\n            print(f"{task.name}: {task.status}")\n\n# Example usage\nboard = KanbanBoard()\nboard.add_task("Design Database Schema")\nboard.add_task("Implement Authentication")\n\nboard.display_tasks()  # Before moving any tasks\nboard.move_task_to_next_stage("Design Database Schema")\nboard.display_tasks()  # After moving one task