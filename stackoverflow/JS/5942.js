var xhr = null;\ntry { xhr = new XMLHttpRequest(); } catch (e) {}\ntry { xhr = new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) {}\ntry { xhr = new ActiveXObject("Msxml2.XMLHTTP"); } catch (e) {}\nreturn (xhr!=null);