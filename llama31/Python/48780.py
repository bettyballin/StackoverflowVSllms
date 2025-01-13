def format_and_display_data(file_path):\n    try:\n        with open(file_path, 'r') as file:\n            lines = file.readlines()\n            # Strip newline characters\n            lines = [line.strip() for line in lines]\n\n            # Find indices of days\n            days_indices = [i for i, line in enumerate(lines) if line in ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']]\n\n            # Process and print data\n            for i, start_index in enumerate(days_indices):\n                day = lines[start_index]\n                print(f"Day            Name               Type of exercise           Time")\n                print(f"{day:10}", end='')\n                entries = 4  # Each person's entry spans 4 lines\n                for offset in range(1, entries * ((days_indices[i+1] - start_index - 1) // entries + 1), entries):\n                    name = lines[start_index + offset]\n                    exercise = lines[start_index + offset + 1]\n                    time = lines[start_index + offset + 2]\n                    print(f"{name:20}{exercise:20}{time:20}")\n                print()\n\n    except FileNotFoundError:\n        print(f"File {file_path} not found.")\n    except Exception as e:\n        print(f"An error occurred: {e}")\n\n# Usage\nformat_and_display_data('input.txt')