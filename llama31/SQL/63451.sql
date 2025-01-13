SELECT     strings.*, translations.text\nFROM         strings\nLEFT OUTER JOIN (\n  translations INNER JOIN language ON translations.language_id = language.id\n) ON translations.string_id = strings.id\nWHERE     (language.handle = 'english' OR translations.string_id IS NULL)