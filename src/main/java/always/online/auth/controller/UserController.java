package always.online.auth.controller;

import always.online.auth.service.UserService;
import always.online.auth.vo.UserInfoVO;
import always.online.common.api.ApiResponse;
import always.online.common.security.JwtUserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ApiResponse<UserInfoVO> me(Authentication authentication) {
        JwtUserPrincipal principal = (JwtUserPrincipal) authentication.getPrincipal();
        return ApiResponse.success(userService.getUserInfo(principal.getUserId()));
    }
}
