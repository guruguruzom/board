package com.guruguruzom.boader.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guruguruzom.boader.util.ResultUtil;
import com.guruguruzom.boader.valueset.ServiceCode;
import com.guruguruzom.boader.vo.BoaderSummary;
import com.guruguruzom.boader.vo.BoaderMember;

@Controller
//@RequestMapping()
public class BoaderController {
	/*
	 * api : 1001
	 * �������� boader ��ü api
	 * @param1 page : ������ ��ȣ
	 * @return boader ������
	 * */
	@GetMapping("/boader")
	public String boader(HttpServletRequest request,@RequestParam("page") int page) {
		
		List<BoaderSummary> boaderSummaries = Collections.emptyList();
		
		request.setAttribute("boaderSummaries", boaderSummaries);
		
		return "boader";
	}
	
	/*
	 * api : 1002
	 * �������� boader ��ü api
	 * @param1 page : �� ����
	 * @return boader ������
	 * */
	@PostMapping("/boader")
	public Map<String,Object> setBoader(HttpServletRequest request,@RequestParam("item") BoaderMember item) {
		System.out.println("test");
		System.out.println(ServiceCode.SUCCESS_CODE.getCode());
		
		return ResultUtil.ResultToMap(ServiceCode.SUCCESS_CODE, null, request);
	}
}