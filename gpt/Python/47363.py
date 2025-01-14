import subprocess\n\n# Check if dot is in the PATH\nresult = subprocess.run(["which", "dot"], capture_output=True, text=True)\ndot_path = result.stdout.strip()\n\nif dot_path:\n    print(f"dot found at: {dot_path}")\n    # Run the dot command\n    try:\n        subprocess.run(["dot", "-o9.png", "-Tpng", "./6.dot"], check=True)\n        print("dot command executed successfully.")\n    except subprocess.CalledProcessError as e:\n        print(f"dot command failed with error: {e}")\nelse:\n    print("dot not found in the PATH. Please install Graphviz or add it to your PATH.")