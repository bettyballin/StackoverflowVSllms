function getDiscount(category, customerType) {\n    switch (category) {\n        case 'electronics':\n            switch (customerType) {\n                case 'regular':\n                    return 5;\n                case 'premium':\n                    return 10;\n                default:\n                    return 0;\n            }\n        case 'clothing':\n            switch (customerType) {\n                case 'regular':\n                    return 2;\n                case 'premium':\n                    return 5;\n                default:\n                    return 0;\n            }\n        default:\n            return 0;\n    }\n}