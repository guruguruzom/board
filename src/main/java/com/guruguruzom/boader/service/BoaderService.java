package com.guruguruzom.boader.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.guruguruzom.boader.vo.BoaderMember;
import com.guruguruzom.boader.vo.BoaderSummary;


public class BoaderService {
	public List<BoaderSummary> getBoaderMembers() {
		
		List<BoaderSummary> boaderSummaries = Collections.emptyList();
		
		return boaderSummaries;
	}
	
	public BoaderMember getBoaderMember() {
		return null;
	}
	
	public void setBoaderMember(BoaderMember boaderMember) {
		
	}
	
	public String setImage(ServletContext servletContext, MultipartFile file, String type, int productkey) throws IOException {
		String directoryPath = "";
		
		if(type.equals("promotion")) {
			directoryPath = "/promotions";
		} else if(type.equals("banner")) {
			directoryPath = "/banner";
		} else if(type.equals("story")) {
			directoryPath = "/story";
			//스토리의 경우 파일명을 변경하여 저장한다(다른 소스와 합쳐지는 여부에 대해서 고민필요)
			return filePath(file,getPath(servletContext,directoryPath));
		} else {
			directoryPath = "/items/v10/"+productkey;
		}
		
		String imagePath = getPath(servletContext,directoryPath);
		System.out.println(imagePath);
		if(!duplicateFile(imagePath,file)) {
			return "failer";
		} 
		// parent directory를 찾는다.
		Path directory = Paths.get(imagePath).toAbsolutePath().normalize();

		// directory 해당 경로까지 디렉토리를 모두 만든다.
		Files.createDirectories(directory);
	    
		// 파일명을 바르게 수정한다.
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		// 파일명에 '..' 문자가 들어 있다면 오류를 발생하고 아니라면 진행(해킹및 오류방지)
		Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
		// 파일을 저장할 경로를 Path 객체로 받는다.
		Path targetPath = directory.resolve(fileName).normalize();

		// 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
		Assert.state(!Files.exists(targetPath), fileName + " File alerdy exists.");
		file.transferTo(targetPath);
		return "success";
	}
	
	private String filePath(MultipartFile uploadFile, String path) {

		String orgFilename = uploadFile.getOriginalFilename();
		int idx = orgFilename.lastIndexOf(".");
		String filename = orgFilename.substring(0, idx);
		String extension = orgFilename.substring(idx);
		String saveFilename = filename + "_" + System.currentTimeMillis() + extension;
		
		
		try {
			byte[] fileBytes = uploadFile.getBytes();		
			File file = new File(path + "/" + saveFilename);
			OutputStream os = new FileOutputStream(file);
			os.write(fileBytes);
			os.close();
			return saveFilename;
		} catch (Exception e) {
			return "failer";
		}
	}
	
	private String getPath(ServletContext servletContext, String directoryPath) {
		String indexDir = servletContext.getRealPath("/");

		indexDir = new File(indexDir).getParentFile().getPath() + directoryPath;
		return indexDir;
	}
	
	public Boolean duplicateFile(String indexPath, MultipartFile file) {
		File Folder = new File(indexPath + "/" + file.getOriginalFilename());
		
		if (!Folder.exists()) {
			return true;
		} 
		return false;
		
	}
}
