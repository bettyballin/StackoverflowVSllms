SELECT product_id, prod.name name, sample_id\nFROM (SELECT sample_id, product_id FROM lims.sample) JOIN lims.product prod\nUSING (product_id);