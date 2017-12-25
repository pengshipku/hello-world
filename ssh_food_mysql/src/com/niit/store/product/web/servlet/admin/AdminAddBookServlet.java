package com.niit.store.product.web.servlet.admin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

import com.niit.store.product.domain.Book;
import com.niit.store.product.service.BookService;
import com.niit.store.category.domain.Category;
import com.niit.store.category.service.CategoryService;

public class AdminAddBookServlet extends HttpServlet {

	private BookService service = new BookService();
	private CategoryService categoryService = new CategoryService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory(15*1024,new File("c:/my"));
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(15*1024);
		try {
			List<FileItem> fileItemList= sfu.parseRequest(req);
			Map<String,String> map = new HashMap<String,String>();
			for(FileItem fileItem : fileItemList){//�����������ͨ����浽Map��
				if(fileItem.isFormField()){
					map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}
			}
			Book book = CommonUtils.toBean(map, Book.class);
			book.setCategory(CommonUtils.toBean(map, Category.class));
			book.setBid(CommonUtils.uuid());
			//����image���book����������
			//��ؼ�һ������ȡimage,�����浽Ŀ¼
			String savepath = this.getServletContext().getRealPath("/book_img");
			String filename = CommonUtils.uuid()+"_"+fileItemList.get(1).getName();//��ȡ�ļ���
			if(!filename.endsWith(".jpg")){
				req.setAttribute("msg", "�ļ����ͱ���Ϊ.jpg");
				req.setAttribute("categoryList", categoryService.findAll());
				req.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(req, resp);
			}
			File imageFile = new File(savepath,filename);
			book.setImage("book_img/"+filename);
			fileItemList.get(1).write(imageFile);
			//У��ߴ�
			Image image = new ImageIcon(imageFile.getAbsolutePath()).getImage();
			if(image.getWidth(null)>200||image.getHeight(null)>200){
				imageFile.delete();
				req.setAttribute("msg", "�ļ��ߴ糬������");
				req.setAttribute("categoryList", categoryService.findAll());
				req.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(req, resp);
			}
			service.add(book);
			req.getRequestDispatcher("/admin/AdminBookServlet?method=findAll").forward(req, resp);
		} catch (Exception e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException){
				req.setAttribute("msg", "�ļ���С����15KB");
				req.setAttribute("categoryList", categoryService.findAll());
				req.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(req, resp);
			}
			e.printStackTrace();
		}
	}
	

}
