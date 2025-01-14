CREATE OR REPLACE FUNCTION mask_to_cidr(mask IN NUMBER) RETURN NUMBER IS\nBEGIN\n  RETURN 32 - LOG(2,(POWER(2, 32) - mask));\nEND;\n/\n\nSELECT mask_to_cidr(ip_mask) AS cidr FROM subnets;