def create_message_owned_by(sender)\n  Factory(:message, :sender => sender)\nend