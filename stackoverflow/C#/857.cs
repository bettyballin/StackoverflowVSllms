try {\n    userId = new Guid(Request.QueryString["id"]);\n} catch (FormatException e) {\n    /*\n     * It's possible that the guid is not properly formatted and an\n     * exception will be thrown, so handle that here.\n     */\n}