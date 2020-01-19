package tmall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;


public class BackServletFilter implements Filter {

	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 转换类型 ServletRequest -》 HttpServletRequest
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		// 获取请求的路径
		String contextPath = request.getServletContext().getContextPath();
		String uri = request.getRequestURI();  // 浏览器发出请求的资源名部分，去掉了协议和主机名"
		uri = StringUtils.remove(uri, contextPath);
		
		System.out.println("-------输出语句测试 Filter_v1 -------------");
		System.out.println("uri 为 "+uri);
		
		if(uri.startsWith("/admin_")) {
			String servletPath = StringUtils.substringBetween(uri, "_", "_") + "Servlet";
			System.out.println("servletPath 为 "+servletPath);
			String method = StringUtils.substringAfterLast(uri, "_");
			System.out.println("method 为 "+method);
			
			request.setAttribute("method", method);
			request.getRequestDispatcher("/" + servletPath).forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig arg0) throws ServletException {
	
	}
}
