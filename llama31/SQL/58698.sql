SELECT (payment1_paid AND payment2_paid) AS paid_in_full\nFROM denormalized_payments\nWHERE payment1_type = 'check';