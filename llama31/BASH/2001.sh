# Create a new task\nschtasks /create /tn "MyTask" /tr "C:\Path\To\Task.exe" /sc daily /st 02:00\n\n# Run the task\nschtasks /run /tn "MyTask"