package ru.Filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import ru.Token;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/user/*")
public class BalanceUserFilter implements Filter {
    final String key = "123";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String tokenStr = ((HttpServletRequest)servletRequest).getHeader("token");

        if (tokenStr != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Token token = objectMapper.readValue(tokenStr, Token.class);

            String signature = DigestUtils.sha256Hex(Integer.toString(token.getUserID())+token.getRole()+ key);

            if (token.getSignature().equals(signature)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        else {
            throw new ServletException("Токен мне быстро сделал!!!");
        }
    }

    @Override
    public void destroy() {

    }
}
