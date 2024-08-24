package com.angelhack.moneygement.common.filter;

import com.angelhack.moneygement.common.wrapper.RequestWrapper;
import com.angelhack.moneygement.common.wrapper.ResponseWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.IOException;

import static com.angelhack.moneygement.common.util.LoggingUtil.printOneLineLog;

@Slf4j
@Component
public class LoggingFilter implements Filter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();
    private static final String[] EXCLUDE_PATHS = {
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**"
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
        ResponseWrapper responseWrapper = new ResponseWrapper(httpResponse);

        // Swagger UI 및 OpenAPI 문서 경로를 제외
        String path = httpRequest.getRequestURI();
        for (String excludePath : EXCLUDE_PATHS) {
            if (pathMatcher.match(excludePath, path)) {
                log.info("exclude path matched: {}", excludePath);
                chain.doFilter(httpRequest, httpResponse);
                return;
            }
        }

        chain.doFilter(requestWrapper, responseWrapper);

        String requestBody = requestWrapper.getRequestBody();
        String responseBody = responseWrapper.getResponseBody();
        printOneLineLog(httpRequest, httpResponse, requestBody, responseBody);

        response.getOutputStream().write(responseWrapper.toByteArray());
    }
}
