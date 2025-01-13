library(e1071)\n\n# Create a data frame with two predictor variables for demonstration\n# We're using a simple linear progression for the second variable here, which doesn't add real value but allows us to plot\nday_of_week <- c(0,1,2,3,4,5,6)\nholiday <- factor(c(T, F, F, F, F, F, T))\ndf <- data.frame(x = day_of_week, y = seq(1, 7), holiday = holiday)\n\n# Train the SVM model\nmodel <- svm(holiday ~ x + y, data = df, scale = FALSE, kernel = "linear")\n\n# Plot the SVM model\nplot(model, df[, c("x", "y")], main = "SVM Classification Plot")