/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.ResponseEntity
 *  org.springframework.http.ResponseEntity$BodyBuilder
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestHeader
 */
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public class CorsController {
    @GetMapping(value={"/endpoint"})
    public ResponseEntity<String> endpoint(@RequestHeader(value="Origin") String string) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", string);
        httpHeaders.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        httpHeaders.add("Access-Control-Allow-Headers", "Content-Type");
        return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().headers(httpHeaders)).body((Object)"Response body");
    }

    public static void main(String[] stringArray) {
    }
}
