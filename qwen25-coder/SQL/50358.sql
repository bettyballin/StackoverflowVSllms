-- Title: Retrieve User Data with Orders\n-- Description: This script retrieves user information along with their order details.\n-- Date Created: 2023-10-05\n-- Author: Your Name\n-- Parameters:\n--   - @startDate (datetime): The start date for filtering orders.\n-- Usage Example:\n--   EXEC GetUserOrderData '2023-10-01'\n\nSELECT u.UserID, u.UserName, o.OrderID, o.OrderDate\nFROM Users u\nJOIN Orders o ON u.UserID = o.UserID\nWHERE o.OrderDate >= @startDate;