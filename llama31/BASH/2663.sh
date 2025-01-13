aws autoscaling create-auto-scaling-group --auto-scaling-group-name my-asg \\n  --launch-configuration-name my-lc --min-size 1 --max-size 5 \\n  --desired-capacity 1 --vpc-zone-identifier subnet-12345678\n\naws autoscaling put-scaling-policy --policy-name cpu-scaling-policy \\n  --auto-scaling-group-name my-asg --policy-type StepScaling \\n  --metric-aggregation-type Average --step-adjustments '[\n    {"MetricAggregationType": "Average", "ScalingAdjustment": 1, "MetricIntervalLowerBound": 50, "MetricIntervalUpperBound": 60},\n    {"MetricAggregationType": "Average", "ScalingAdjustment": 2, "MetricIntervalLowerBound": 60, "MetricIntervalUpperBound": 80}\n  ]'