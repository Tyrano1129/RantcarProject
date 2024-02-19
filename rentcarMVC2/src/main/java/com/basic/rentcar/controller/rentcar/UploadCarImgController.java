package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontController.Controller;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadCarImgController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saveDirectory= request.getServletContext().getRealPath("/img");
		
		Path saveDirPath = Paths.get(saveDirectory);
		
		if(!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println("saveDirectroy=" + saveDirectory);
		MultipartRequest multi = new MultipartRequest(request,saveDirPath.toString(),5*1024*1024,"UTF-8",
				new DefaultFileRenamePolicy());
		String sFileName = null;
		String oFileName = null;
		System.out.println(multi.getFilesystemName("fileimg"));
		
		
		if(multi.getFilesystemName("fileimg") != null) {
			sFileName = multi.getFilesystemName("fileimg");
			oFileName = multi.getFilesystemName("fileimg");
			
			String fileType = multi.getContentType("fileimg");
			System.out.println("fileType="+fileType);
			 
			response.setCharacterEncoding("UTF-8");
			
			response.getWriter().print(sFileName);
		}else {
			response.getWriter().print("fail");
		}
		return null;
	}

}
