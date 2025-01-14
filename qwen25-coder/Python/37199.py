from django.db import models\n\nclass User(models.Model):\n    name = models.CharField(max_length=100)\n\n    def __str__(self):\n        return self.name\n\nclass Role(models.Model):\n    name = models.CharField(max_length=100)\n    users = models.ManyToManyField(User, through='UserRole')\n\n    def __str__(self):\n        return self.name\n\nclass Event(models.Model):\n    name = models.CharField(max_length=100)\n    participants = models.ManyToManyField(User, through='EventParticipantRole')\n\n    def __str__(self):\n        return self.name\n\n# Intermediate model linking Users and Roles\nclass UserRole(models.Model):\n    user = models.ForeignKey(User, on_delete=models.CASCADE)\n    role = models.ForeignKey(Role, on_delete=models.CASCADE)\n\n    class Meta:\n        unique_together = ('user', 'role')  # Ensure a user can have only one instance of a specific role\n\n# Intermediate model linking Events, Users, and Roles\nclass EventParticipantRole(models.Model):\n    event = models.ForeignKey(Event, on_delete=models.CASCADE)\n    user = models.ForeignKey(User, on_delete=models.CASCADE)\n    role = models.ForeignKey(Role, on_delete=models.CASCADE)\n\n    class Meta:\n        unique_together = ('event', 'user')  # Ensure a user has only one role per event