/*
 * Decompiled with CFR 0.152.
 */
class HttpServletRequest {
    HttpServletRequest() {
    }

    public String getRequestURI() {
        return "/path/to/resource";
    }

    public String getQueryString() {
        return "param1=value1&param2=value2#label";
    }
}
