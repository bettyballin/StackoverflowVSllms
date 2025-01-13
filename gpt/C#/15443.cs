using Prometheus;\n\n    var counter = Metrics.CreateCounter("items_processed_total", "Number of items processed");\n    counter.Inc();\n\n    // Start HTTP server to expose metrics\n    var server = new MetricServer(port: 1234);\n    server.Start();