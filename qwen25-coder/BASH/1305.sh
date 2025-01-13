# Step 1: Download TinyMCE new version and extract it temporarily.\ncd /tmp/\nwget http://download.tinymce.com/tinymce-X.XX.zip\nunzip tinymce-4.XX.zip\n\n# Step 2: Compare the old files with the new ones.\ndiff -ruN /path/to/your/repo/tinymce /tmp/tinymce > tinymce-update.patch\n\n# Step 3: Apply the patch to your working copy.\ncd /path/to/your/repo/\npatch -p1 < /tmp/tinymce-update.patch\n\n# Step 4: Resolve any conflicts and commit.\nsvn status\nsvn resolve --accept=working *\nsvn commit -m "Updated TinyMCE to version X.XX"