class User:\n    def __init__(self, id, permissions=None):\n        self.id = id\n        self.permissions = permissions or set()\n\n    def add_permission(self, permission):\n        self.permissions.add(permission)\n\n    def remove_permission(self, permission):\n        self.permissions.discard(permission)\n\n    def has_permission(self, permission):\n        return permission in self.permissions\n\nclass Group:\n    def __init__(self, id, permissions=None):\n        self.id = id\n        self.permissions = permissions or set()\n\n    def add_permission(self, permission):\n        self.permissions.add(permission)\n\n    def remove_permission(self, permission):\n        self.permissions.discard(permission)\n\n    def has_permission(self, permission):\n        return permission in self.permissions\n\n# Example usage:\nuser = User(1)\ngroup = Group(1)\n\n# Add permissions to user and group\nuser.add_permission('read_page_1')\ngroup.add_permission('read_page_2')\n\n# Check if user has permission\nprint(user.has_permission('read_page_1'))  # True\n\n# Check if group has permission\nprint(group.has_permission('read_page_2'))  # True