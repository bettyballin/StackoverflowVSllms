# Perform Mediation Analysis with bootstrapping for indirect effects (recommended)\nmed_results <- mediate(model.m = M_model, model.y = Y_model,\n                       treat = "income", mediator = "prestige",\n                       sims = 500) # Number of bootstrap replication\n\n# Summary of mediation analysis\nsummary(med_results)\n\n# Plot the confidence intervals of indirect effects and ACME/ATE\nplot(med_results)