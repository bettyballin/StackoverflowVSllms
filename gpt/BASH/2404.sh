# File: ~/.ssh/load-ssh-agent.sh\nif [ -f ~/.ssh-agent-info ]; then\n    eval $(cat ~/.ssh-agent-info)\n    if ! kill -0 $SSH_AGENT_PID 2>/dev/null; then\n        echo "Stale ssh-agent found. Starting a new one..."\n        eval `ssh-agent -s` > ~/.ssh-agent-info\n        ssh-add\n    fi\nelse\n    echo "Starting a new ssh-agent..."\n    eval `ssh-agent -s` > ~/.ssh-agent-info\n    ssh-add\nfi