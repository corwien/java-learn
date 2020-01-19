package tmall.servlet;


import java.io.InputStream;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tmall.dao.CategoryDAO;
import tmall.dao.OrderDAO;
import tmall.dao.OrderItemDAO;
import tmall.dao.ProductDAO;
import tmall.dao.ProductImageDAO;
import tmall.dao.PropertyDAO;
import tmall.dao.PropertyValueDAO;
import tmall.dao.ReviewDAO;
import tmall.dao.UserDAO;
import tmall.util.Page;

public abstract class BaseBackServlet extends HttpServlet {

	public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page) ;
	
	
	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected OrderDAO orderDAO = new OrderDAO();
	protected OrderItemDAO orderItemDAO = new OrderItemDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected ProductImageDAO productImageDAO = new ProductImageDAO();
	protected PropertyDAO propertyDAO = new PropertyDAO();
	protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
	protected ReviewDAO reviewDAO = new ReviewDAO();
	protected UserDAO userDAO = new UserDAO();

	public void service(HttpServletRequest request, HttpServletResponse response) {
	try {
		/*获取分页信息*/
        int start= 0;
        int count = 5;
        try {
            start = Integer.parseInt(request.getParameter("page.start"));
        } catch (Exception e) {
             
        }
        try {
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }
        Page page = new Page(start,count);
        
        System.out.println("-------输出语句测试v3 BaseBack -------------");
        
        /*借助反射，调用对应的方法*/
        // String method = (String)request.getParameter("method");  // 该方法不能获取method,会报错
        String method = (String) request.getAttribute("method"); // 只能通过该方法获取method参数
        
        // null 
        System.out.println(method);
        
        // 反射（三种获取类对象方法，类对象，就是用于描述这种类，都有什么属性，什么方法的，获取类对象的时候，会导致类属性被初始化）
        // 1、Class pClass1=Class.forName(className);
        // 2、Class pClass2=Hero.class;
        // 3、Class pClass3=new Hero().getClass();
        
        // 打印：class tmall.servlet.CategoryServlet
        // System.out.println(this.getClass());
        
        // 这里的this,表示哪个类调用继承父类，就是哪个子类的对象，如CategoryServlet调用，则this指代的就是该类CategoryServlet
        Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
        		javax.servlet.http.HttpServletResponse.class, Page.class);
        
        //根据反射，获取attackHero方法，并且调用hero1的这个方法，参数是hero2
        // Method attackHeroMethod = hero1Class.getMethod("attackHero", Hero.class);
        // attackHeroMethod.invoke(hero1, hero2);
        
        // 子类方法返回的结果（在父类里边通过反射调用子类的方法，
        // 如http://127.0.0.1:8080/tmall/admin_category_list 最终调用CategoryServlet.list方法返回"@admin_category_list"）
        String redirect = m.invoke(this, request, response, page).toString();
        
        /*根据方法的返回值，进行相应的客户端跳转，服务端跳转，或者仅仅是输出字符串*/
        if(redirect.startsWith("@"))
        	response.sendRedirect(redirect.substring(1));
        else if(redirect.startsWith("%"))
        	response.getWriter().print(redirect.substring(1));
        else
        	request.getRequestDispatcher(redirect).forward(request, response);
        
	} catch(Exception e) {
		  // TODO Auto-generated catch block
        e.printStackTrace();
        throw new RuntimeException(e);
		
	}
	}
	
	
	public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
			InputStream is =null;
			try {
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            // 设置上传文件的大小限制为10M
	            factory.setSizeThreshold(1024 * 10240);
	             
	            List items = upload.parseRequest(request);
	            Iterator iter = items.iterator();
	            while (iter.hasNext()) {
	                FileItem item = (FileItem) iter.next();
	                if (!item.isFormField()) {
	                    // item.getInputStream() 获取上传文件的输入流
	                    is = item.getInputStream();
	                } else {
	                	String paramName = item.getFieldName();
	                	String paramValue = item.getString();
	                	paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");
	                	params.put(paramName, paramValue);
	                }
	            }
	             
	
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return is;
		}
	
	 
	

}
