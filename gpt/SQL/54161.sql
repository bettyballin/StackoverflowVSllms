SUBSTRING([YourDateTimeColumn], FINDSTRING([YourDateTimeColumn], " ", 1) + 1, 100)