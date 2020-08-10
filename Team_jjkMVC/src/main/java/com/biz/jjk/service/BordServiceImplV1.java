package com.biz.jjk.service;

import org.springframework.stereotype.Service;

@Service
public class BordServiceImplV1 implements BordService{

	@Override
	public String strRank() {
		String praise = "태양 만세!!!";
		return praise;
	}

	@Override
	public String strLgd() {
		String reversNo = "에엫따..!";
		return reversNo;
	}

	@Override
	public String strWord() {
		String nong = "돌다리를 신명나게 두들기는 기능";
		return nong;
	}

	@Override
	public String strBlList() {
		String tel = "010-222-2222";
		return tel;
	}
	
}
