-- Check if widget is already processed in ProcessedWidgets table\nIF NOT EXISTS (SELECT 1 FROM ProcessedWidgets WHERE WidgetId = @WidgetId)\nBEGIN\n    -- Add row to YourWidgetTable if not yet added\n    INSERT INTO YourWidgetTable (WidgetId, OtherColumns)\n    VALUES (@WidgetId, @OtherValues);\n    \n    -- Record the widget as processed\n    INSERT INTO ProcessedWidgets (WidgetId)\n    VALUES (@WidgetId);\nEND;