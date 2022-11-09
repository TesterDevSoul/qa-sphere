package top.testeru.qasphere.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.entity.User;

import java.security.Key;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import static java.lang.invoke.MethodHandles.lookup;

@Component
public class JWTUtils {
	static final Logger logger = getLogger(lookup().lookupClass());

	private static String TOKEN_ISSUER = "qasphere";


	private static String BASE_SECRET_STRING = "asdfghjkl";

	private final Long EXPIRE_DURATION = TimeUnit.HOURS.toMillis(2); //token过期时间



	public String generateAccessToken(UserDto user){
		final Claims claims = new DefaultClaims();
		claims.put("user_id", user.getId());
//		claims.put("account_creation_timestamp",
//				user.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		claims.put("ename", user.getEmail());
		claims.put("password", user.getPassword() + BASE_SECRET_STRING);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuer(TOKEN_ISSUER)
				.setSubject(user.getId() + "," + user.getUsername())
//				.setAudience("localhost")
				.setIssuedAt(new Date(System.currentTimeMillis()))//签发时间
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))//过期时间
				.signWith(SignatureAlgorithm.HS256, BASE_SECRET_STRING)
				.compact();
	}


	public boolean validateAccessToken(final String token) {
		try {
			Jwts
				.parser()
				.setSigningKey(BASE_SECRET_STRING)
				.parseClaimsJws(token)
				.getBody();

			return true;
		}catch (ExpiredJwtException e){
			logger.error("JWT解析异常：", e);
		}catch (IllegalArgumentException e){
			logger.error("token 为空，null，或空白：",e);
		}catch (MalformedJwtException e){
			logger.error("JWT令牌无效：",e);
		}catch (UnsupportedJwtException e){
			logger.error("不支持JWT令牌：",e);
		}catch (SignatureException e){
			logger.error("令牌签名无效：",e);
		}
		return false;
	}

	public String getSubject(String token){
		return parseClaims(token).getSubject();
	}

	private Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(BASE_SECRET_STRING)
				.parseClaimsJws(token)
				.getBody();
	}


}