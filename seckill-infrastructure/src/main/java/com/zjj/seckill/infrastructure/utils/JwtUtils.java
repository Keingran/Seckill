package com.zjj.seckill.infrastructure.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zjj.seckill.domain.constants.SeckillConstants;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Map;


/**
 * JWT工具类
 *
 * @author zhujunjian
 */
public class JwtUtils {

    /**
     * 生成UserId JWT Token
     *
     * @param userId 用户名
     * @param secret 密钥
     * @return token
     */
    public static String sign(Long userId, String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(SeckillConstants.TOKEN_CLAIM_USER_ID, userId)
                .sign(algorithm);
    }

    /**
     * 生成JWT Token
     *
     * @param claims 用户名
     * @param secret secret
     * @return token
     */
    public static String sign(Map<String, Object> claims, String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTCreator.Builder jwtBuilder = JWT.create();
        claims.forEach((key, value) -> {
            if (value instanceof Boolean) {
                jwtBuilder.withClaim(key, (Boolean) value);
            }
            if (value instanceof Integer) {
                jwtBuilder.withClaim(key, (Integer) value);
            }
            if (value instanceof Long) {
                jwtBuilder.withClaim(key, (Long) value);
            }
            if (value instanceof Double) {
                jwtBuilder.withClaim(key, (Double) value);
            }
            if (value instanceof String) {
                jwtBuilder.withClaim(key, (String) value);
            }
        });
        return jwtBuilder.sign(algorithm);
    }

    /**
     * 校验token是否正确
     *
     * @param token  token
     * @param secret 密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String secret) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(SeckillConstants.TOKEN_CLAIM_USER_ID, getUserId(token))
                    .build();
            // 效验TOKEN
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @param token token
     * @return token中包含的用户名
     */
    public static DecodedJWT parse(String token) {
        try {
            return JWT.decode(token);
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @param token token
     * @return token中包含的用户名
     */
    public static Long getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(SeckillConstants.TOKEN_CLAIM_USER_ID).asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * jwt 分成3部分 Header Payload Signature
     * Header header典型的由两部分组成：token的类型（“JWT”）和算法名称（比如：HMAC SHA256或者RSA等等）
     * 例如:  { 'alg': "HS256", 'typ': "JWT" }
     * 然后，用Base64对这个JSON编码就得到JWT的第一部分
     * Payload JWT的第二部分是payload，它包含声明（要求）。声明是关于实体(通常是用户)和其他数据的声明。声明有三种类型: registered, public 和 private。
     * Registered claims : 这里有一组预定义的声明，它们不是强制的，但是推荐。比如：iss (issuer), exp (expiration time), sub (subject), aud (audience)等。
     * Public claims : 可以随意定义。
     * Private claims : 用于在同意使用它们的各方之间共享信息，并且不是注册的或公开的声明。
     * 例子：{
     * "sub": '1234567890',
     * "name": 'john',
     * "admin":true
     * }
     * Signature
     * 为了得到签名部分，你必须有编码过的header、编码过的payload、一个秘钥，签名算法是header中指定的那个，然对它们签名即可。
     */
    public static void main(String[] args) throws Exception {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();

        String secret = "abcdefghijklmnopqrstuvwxyz";
        String userId = UUID.fastUUID().toString();
        String jwt = sign(Long.parseLong(userId), secret);
        Long claims = getUserId(jwt);
        // 生成jwt
        System.out.println(jwt);
        // 解析jwt
        System.out.println(claims);
        // 获取jwt的字节
        System.out.println(new String(decoder.decodeBuffer(jwt), StandardCharsets.UTF_8));

        String header = "eyJhbGciOiJIUzUxMiJ9";
        String payload = "eyJsb2dpbl91c2VyX2tleSI6IjYzZTYyNmE4LTU0ZTktNDAwNi04OGJlLTM4NDk4ZWI4YmZlNiJ9";
        String signature = "V8naqHwMAiEaJ_XSO1aXu14Zpy4OEWDNtefyFGkQ3obh0RhL3Qgr8dtBZ-YbU7JNHf30ObEMp65DY_em8odx_A";
//        byte[] decode = BASE64.decode(header + "." + payload + "." + signature);
//        System.out.println(new String(decode, StandardCharsets.UTF_8));
        System.out.println(new String(decoder.decodeBuffer(header), StandardCharsets.UTF_8));
        System.out.println(new String(decoder.decodeBuffer(payload), StandardCharsets.UTF_8));
        System.out.println(new String(decoder.decodeBuffer(signature), StandardCharsets.UTF_8));
    }

}

