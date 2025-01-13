-- Create table to store unread counts\nCREATE TABLE UserFeedUnreadCount (\n  user_id INT,\n  feed_id INT,\n  num_unread INT,\n  PRIMARY KEY (user_id, feed_id)\n);\n\n-- Trigger to update unread count when a new item is added\nCREATE TRIGGER after_item_insert\nAFTER INSERT ON Items\nFOR EACH ROW\nBEGIN\n  INSERT INTO UserFeedUnreadCount (user_id, feed_id, num_unread)\n  SELECT user_id, NEW.feed_id, COUNT(*)\n  FROM Users\n  GROUP BY user_id\n  ON DUPLICATE KEY UPDATE num_unread = num_unread + 1;\nEND;\n\n-- Trigger to update unread count when an item is marked as read\nCREATE TRIGGER after_read_item\nAFTER INSERT ON UserReadItems\nFOR EACH ROW\nBEGIN\n  UPDATE UserFeedUnreadCount\n  SET num_unread = num_unread - 1\n  WHERE user_id = NEW.user_id AND feed_id = (SELECT feed_id FROM Items WHERE item_id = NEW.item_id);\nEND;