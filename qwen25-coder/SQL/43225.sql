DECLARE @SomeConfigValue BIT\n\n   SET @SomeConfigValue = \n       CASE WHEN @Configuration.value('/Configuration[1]/SomeConfigValue [1]', 'int') = -1 \n            THEN CAST(NULL AS BIT)\n            ELSE @Configuration.value('/Configuration[1]/SomeConfigValue [1]', 'bit')\n       END