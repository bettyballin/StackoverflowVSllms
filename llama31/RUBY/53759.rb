# Perform mediation analysis\nmodel.m <- lm(m ~ x, data = df)\nmodel.y <- lm(y ~ x + m, data = df)\nmed.fit <- mediate(model.m, model.y, treat = "x", mediator = "m", \n                   robustSE = TRUE, sims = 1000)\n\n# Summary of the mediation analysis\nsummary(med.fit)