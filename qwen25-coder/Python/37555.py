import shutil\n\n# Replace '/folder_name' with the path to your directory\ndirectory_path = "/folder_name"\n\ntry:\n    shutil.rmtree(directory_path)\nexcept Exception as e:\n    print(f"An error occurred: {e}")