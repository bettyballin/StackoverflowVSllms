context.ObjectStateManager.GetObjectStateEntries(EntityState.Added | EntityState.Modified | EntityState.Unchanged).Select(o => o.Entity).OfType<YourObjectType>()