import os\nimport stat\nimport pwd\nimport grp\n\ndef is_secure_path(path, user, group):\n    """Check if the path is secure."""\n    try:\n        st = os.stat(path)\n        file_uid = st.st_uid\n        file_gid = st.st_gid\n\n        # Check if the file is owned by the expected user and group\n        if file_uid != pwd.getpwnam(user).pw_uid:\n            return False\n\n        if file_gid != grp.getgrnam(group).gr_gid:\n            return False\n\n        # Check file permissions (ensure no public write access)\n        if (st.st_mode & (stat.S_IWGRP | stat.S_IWOTH)) != 0:\n            return False\n\n        return True\n    except Exception as e:\n        print(f"Error checking path security: {e}")\n        return False\n\n# Example usage:\nPQRHOME = os.getenv('PQRHOME')\nif PQRHOME and is_secure_path(PQRHOME, 'pqrusr', 'pqrgrp'):\n    print("The directory is secure.")\nelse:\n    print("The directory is not secure.")