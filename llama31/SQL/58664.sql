CREATE FUNCTION MaraSizeCaseExample\n(\n    @ms varchar\n)\nRETURNS varchar\nAS\nBEGIN\n    RETURN \n        CASE @ms\n            WHEN '16-18' THEN '1'\n            WHEN '18-20' THEN '2'\n            WHEN '20-22' THEN '3'\n            WHEN '22+' THEN '4'\n            WHEN '24+' THEN '5'\n            WHEN '14-16' THEN '7'\n            ELSE 'BAD'\n        END;\nEND;