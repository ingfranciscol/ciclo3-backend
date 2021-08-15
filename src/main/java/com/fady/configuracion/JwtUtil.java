package com.fady.configuracion;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static java.util.Collections.emptyList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

class JwtUtil {

    private static final Log logger = LogFactory.getLog(JwtUtil.class);

    static void addAuthentication(HttpServletResponse res, String name) {
        long now = (new Date()).getTime();
        Date validity;
        validity = new Date(now + 36000);

        String token = Jwts.builder()
                .setSubject(name)
                //.setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, "FADY").compact();
        logger.info(token);
        res.setHeader("Content-Type", "application/json");
        //res.setHeader("FADY", "Hola");
        res.addHeader("Authorization", "Bearer " + token);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String usuario = Jwts.parser()
                    .setSigningKey("FADY")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody().getSubject();
            return usuario != null ? new UsernamePasswordAuthenticationToken(usuario, null, emptyList()) : null;
        }
        return null;
    }
}
