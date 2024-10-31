package tp.eni.enistore.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@RestController
public class AuthController {

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    public Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    @GetMapping("/login")
    public String login(
    ) {
        //Generer un token
        // Il faut :
        // 1)  la date ou ça a été créé (IssueAt)
        // 2)  une date d'expiration (Expiration)
        // 3) lui envoyer une données subjective(Subject)
        // 4) l'algo pour crypter (HS256)
        // 5) une clé secrète
        // Le code qui génère le token

        Map<String, Object> claims = new HashMap<>();


        String token = Jwts.builder().setClaims(claims)
                .setSubject("ismael@gmail.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, getKey())
                .compact();


        return token;
    }

    @GetMapping("/check")
    public String check(@RequestHeader("Authorization") String authorisation) {
    String token = authorisation.substring(7);
        try{
        Claims claims = Jwts.parser().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();

        //Récupérer la date d'expiration
        Function<Claims, Date> expirationFunction = Claims::getExpiration;
        Date expirationData= expirationFunction.apply(claims);

        String email = claims.getSubject();
            if(expirationData.before(new Date())){
                return "123";
            }
        }catch(Exception e){
            return "456";
        }

        return "test";



    }

}
