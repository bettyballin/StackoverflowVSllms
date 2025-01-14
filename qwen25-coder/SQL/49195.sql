CREATE OR REPLACE PROCEDURE calculate_discount(\n    IN amount DECIMAL(10,2),\n    OUT discounted_amount DECIMAL(10,2)\n)\nLANGUAGE SQL\nBEGIN\n    SET discounted_amount = amount * 0.9; -- Example logic: apply 10% discount\nEND;