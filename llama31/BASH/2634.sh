# Create a branch from the trunk\nsvn copy ^/trunk ^/branches/release-1.0\n\n# Switch to the branch\nsvn switch ^/branches/release-1.0\n\n# Merge specific revisions from the trunk into the branch\nsvn merge -r 100:102 ^/trunk/file1.txt\nsvn merge -r 105 ^/trunk/file2.txt\n\n# Ignore files that shouldn't be included in the release\nsvn propset svn:ignore file3.txt .