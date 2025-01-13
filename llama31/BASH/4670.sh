#!/bin/bash\n\n# Set test email sender and recipient\nSENDER="test@example.com"\nRECIPIENT="test@example.com"\n\n# Set Postfix server IP and port\nPOSTFIX_SERVER="127.0.0.1"\nPOSTFIX_PORT="25"\n\n# Send test email using swaks\nswaks --to $RECIPIENT --from $SENDER --server $POSTFIX_SERVER:$POSTFIX_PORT --body "Test email"\n\n# Check if email was delivered successfully\nif [ $? -eq 0 ]; then\n  echo "Email delivered successfully"\nelse\n  echo "Email delivery failed"\n  # Send alert notification (e.g., via email or SMS)\nfi