from Alert alert\nwhere alert.expiration > CURRENT_DATE\norder by alert.priority, alert.updated, alert.name