import subprocess\n\ndef apply_patch(patch_path, old_binary_path, new_binary_path):\n    subprocess.run(['bspatch', old_binary_path, new_binary_path, patch_path], check=True)