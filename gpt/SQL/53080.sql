SELECT \n    REPLACE(\n        REPLACE(\n            REPLACE(\n                textlong1, \n                'Arial Rounded MT Bold', \n                'Times New Roman'\n            ), \n            'Arial', \n            'Times New Roman'\n        ), \n        'AnotherFontName', -- Replace 'AnotherFontName' with other fonts you want to replace\n        'Times New Roman'\n    ) AS modified_text\nFROM exampletable