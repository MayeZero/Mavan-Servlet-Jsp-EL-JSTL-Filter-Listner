package com.study;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.List;

@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

//    下载文件
//    http://localhost:8080/ServletTest/FileServlet?fileName=cat.png
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath("/file/");
        String fileName = req.getParameter("fileName");
        resp.setHeader("content-disposition","attachment;filename=" + fileName);
//response.setHeader("content-disposition", "attachment;filename=" +
//        URLEncoder.encode(fileName, "UTF-8")); //处理文件名中文乱码
        InputStream in = new FileInputStream(realPath + fileName);
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = resp.getOutputStream();
        while((len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
        in.close();
    }

//    上传文件
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(req)) {
// 如果不是则停止
            PrintWriter writer = resp.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024*1024*40);
        upload.setHeaderEncoding("UTF-8");
        String path = this.getServletContext().getRealPath("/file/");
        File file = new File(path);
        if(!file.exists()&&!file.isDirectory()){
            file.mkdir();
        }

        try{
//            解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(req);
            if(formItems != null && formItems.size() > 0){
                for(FileItem item : formItems){
                    if(!item.isFormField()){
                        String fileName = new File(item.getName()).getName();
                        item.write(new File(path + fileName));
                        req.setAttribute("message","文件上传成功!");
                    }
                }
            }
        }catch (Exception e){
            req.setAttribute("message","错误信息：" + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/message.jsp").forward(req,resp);
    }

//    Servlet 3.0 直接上传文件
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Collection<Part> parts = req.getParts();
//        for (Part part : parts) {
//            String filename = part.getSubmittedFileName();
//            String path = req.getServletContext().getRealPath("/file/") + filename;
//            part.write(path);
//        }
//    }
}
