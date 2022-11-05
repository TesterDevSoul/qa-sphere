package top.testeru.qasphere.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.stereotype.Component;
import top.testeru.qasphere.entity.User;

import java.security.Key;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtils {
	public static String AUTH_LOGIN_URL = "/auth/login";

	public static String TOKEN_HEADER = "Authorization";

	public static String TOKEN_PREFIX = "Bearer ";

	public static String TOKEN_ISSUER = "qasphere";

	private static String BASE_SECRET_STRING = "asdfghjkl";
//			"dSF*F*()SD)(*()9032190898gfsd980*(F*(DS(*()*#@*(*#()!@*()#*(!)@";

//	private static Key KEY = Keys.hmacShaKeyFor(BASE_SECRET_STRING.getBytes());
//			"093617ebfa4b9af9700db274ac204ffa34195494d97b9c26c23ad561de817926";


	private final Long EXPIRE_DURATION = TimeUnit.SECONDS.toMillis(10);//token过期时间



	public String generateAccessToken(User user){
		final Claims claims = new DefaultClaims();
		claims.put("user_id", user.getId());
		claims.put("account_creation_timestamp",
				user.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		claims.put("ename", user.getEmail());
		claims.put("password", user.getPassword() + BASE_SECRET_STRING);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuer(TOKEN_ISSUER)
				.setSubject(user.getId() + "," + user.getEmail())
//				.setAudience("localhost")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS256, BASE_SECRET_STRING)
				.compact();




	}

}