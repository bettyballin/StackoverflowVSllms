# Create a test plan with 200 users, 10 iterations, and a 5-second delay between requests\njmeter -n -t test_plan.jmx -l results.jtl -e -o output.log -j jmeter.log