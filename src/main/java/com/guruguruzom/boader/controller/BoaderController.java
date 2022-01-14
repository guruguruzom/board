package com.guruguruzom.boader.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.guruguruzom.boader.util.ResultUtil;
import com.guruguruzom.boader.valueset.ServiceCode;
import com.guruguruzom.boader.vo.BoaderSummary;
import com.guruguruzom.boader.vo.BoaderMember;

@Controller
//@RequestMapping()
public class BoaderController {
	/*
	 * api : 1001
	 * 페이지별 boader 객체 api
	 * @param1 page : 페이지 번호
	 * @return boader 페이지
	 * */
	@GetMapping("/boader")
	public String boader(HttpServletRequest request,@RequestParam("page") int page) {
		
		List<BoaderSummary> boaderSummaries = Collections.emptyList();
		
		request.setAttribute("boaderSummaries", boaderSummaries);
		
		return "boader";
	}
	
	/*
	 * api : 1002
	 * 페이지별 boader 객체 api
	 * @param1 page : 글 정보
	 * @return boader 페이지
	 * */
	@PostMapping("/boader")
	public Map<String,Object> setBoader(HttpServletRequest request,@RequestParam("item") BoaderMember item) {
		System.out.println("test");
		System.out.println(ServiceCode.SUCCESS_CODE.getCode());
		
		return ResultUtil.ResultToMap(ServiceCode.SUCCESS_CODE, null, request);
	}
	
	@PostMapping("/file")
	public Map<String, Object> handleUpload(HttpServletRequest request, @RequestParam("data") MultipartFile multipartFile, @RequestParam("fileType") String fileType) {
		String fileName = multipartFile.getOriginalFilename();
		byte[] fineNameByte = new byte[] {};
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
		
		String date = format.format(new Date());
		return null;
	}
}
