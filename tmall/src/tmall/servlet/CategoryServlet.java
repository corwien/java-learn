package tmall.servlet;
 
import java.awt.image.BufferedImage;   
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import tmall.bean.Category;
import tmall.util.ImageUtil;
import tmall.util.Page;

public class CategoryServlet extends BaseBackServlet {
	
	/**
	 * 【Date:2020-01-18】
	 * 说明：当filter 过滤器进入到CategoryServlet这个类时，首先会进入到父类BaseBackServlet service()方法中，
	 * 然后根据反射机制，调用该类（CategoryServlet）的list方法，然后根据返回的信息进行服务端跳转、客户端跳转、或者直接输出字符串。
	 * 
	 * 父类BaseBackServlet 的 this 指代的就是子类CategoryServlet。
	 * 
	 * 这里有一个巧妙的设计技巧：子类继承父类，执行子类时，在父类service()中根据反射机制调用子类的方法，
	 * 一般往往是子类调用父类的方法。这样做的好处是如果有多个子类，那么就可以共用通用的方法，
	 * 子类单独的业务类自己实现，提高了代码的可复用和易扩展性。
	 * 
	 */
	
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		Map<String,String> params = new HashMap<>();
		InputStream is = super.parseUpload(request, params);
		
		String name = params.get("name");
		Category c = new Category();
		c.setName(name);
		categoryDAO.add(c);
		
		File  imageFolder= new File(request.getSession().getServletContext().getRealPath("img/category"));
	    File file = new File(imageFolder,c.getId()+".jpg");
	    
	    // 绝对路径获取
	    // File path = file.getAbsoluteFile();
         
        try {
            if(null!=is && 0!=is.available()){
                try(FileOutputStream fos = new FileOutputStream(file)){
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.flush();
                    //通过如下代码，把文件保存为jpg格式
                    BufferedImage img = ImageUtil.change2jpg(file);
                    ImageIO.write(img, "jpg", file);       
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        
        return "@admin_category_list";
		
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDAO.delete(id);
        return "@admin_category_list";
    }
 
    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category c = categoryDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editCategory.jsp";       
    }
 
    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);
         
        System.out.println(params);
        String name= params.get("name");
        int id = Integer.parseInt(params.get("id"));
 
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        categoryDAO.update(c);
         
        File  imageFolder= new File(request.getSession().getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        file.getParentFile().mkdirs();
         
        try {
            if(null!=is && 0!=is.available()){
                try(FileOutputStream fos = new FileOutputStream(file)){
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.flush();
                    //通过如下代码，把文件保存为jpg格式
                    BufferedImage img = ImageUtil.change2jpg(file);
                    ImageIO.write(img, "jpg", file);       
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "@admin_category_list";
 
    }
 
    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Category> cs = categoryDAO.list(page.getStart(),page.getCount());
        int total = categoryDAO.getTotal();
        page.setTotal(total);
         
        request.setAttribute("thecs", cs);
        request.setAttribute("page", page);
         
        return "admin/listCategory.jsp";
    }
	
}