INSERT INTO target( A, B, C )\nSELECT SA, SB, SB FROM source\nWHERE NOT EXISTS (select A, B, C from TARGET where A = SA, B = SB, C = SC)