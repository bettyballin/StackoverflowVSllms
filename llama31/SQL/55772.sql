ALTER TABLE Orders\nADD CONSTRAINT chk_CloseReasonID CHECK (CloseReasonID IS NULL OR Closed = TRUE);