curl -X POST -H "Content-Type: application/json" \\n  -d '{"device": "eth0", "direction": "outgoing", "delay": "100ms"}' \\n  http://localhost:9999/tcset