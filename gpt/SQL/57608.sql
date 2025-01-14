SELECT app_contracts.*, app_customers.id as customer, app_boards.id as board\nFROM app_contracts\nJOIN app_customers ON app_customers.id = app_contracts.customer_id\nJOIN app_boards ON app_boards.id = app_contracts.board_id\nORDER BY app_contracts.id DESC;