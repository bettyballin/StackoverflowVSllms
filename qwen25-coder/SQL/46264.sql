SELECT * FROM YourTable WHERE KeyField > @LastKey FETCH NEXT 50 ROWS ONLY;