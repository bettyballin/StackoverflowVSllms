CREATE PROCEDURE [dbo].[msp_AssociateEvent]\n(\n    @EventId int\n)\nAS\n\nUPDATE tblFoodMenus set\nEventID = @EventId\nWHERE FoodMenuID = IDENT_CURRENT('tblFoodMenus')