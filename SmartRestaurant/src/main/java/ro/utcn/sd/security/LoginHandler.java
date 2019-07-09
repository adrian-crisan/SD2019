package ro.utcn.sd.security;

import java.io.IOException;
import java.util.Collection;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class LoginHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determinteTargetUrl(authentication);
		
		if (response.isCommitted()) {
			System.out.println("can't redirect");
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determinteTargetUrl(Authentication authentication) {
		
		boolean isUser = false;
        boolean isAdmin = false;
        
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                isAdmin = true;
                break;
            }
        }
 
        if (isUser) {
            return "/index";
        } else if (isAdmin) {
            return "/admin";
        } else {
            throw new IllegalStateException();
        }
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}

