package always.online.common.security;

import lombok.Data;

@Data
public class JwtUserPrincipal {
    private final Long userId;
    private final String username;
}
