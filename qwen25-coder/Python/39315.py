# Extract user IDs from USERS list\nuser_ids = [user.id for _, user in USERS]\n\n# Filter Log objects with user_id in the extracted user IDs\nlogs = Log.objects.filter(user_id__in=user_ids)