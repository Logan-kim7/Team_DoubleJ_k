package com.biz.dripbag.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.GoogleCommentDAO;
import com.biz.dripbag.model.GoogleCommentVO;
import com.biz.dripbag.model.NewsCommentVO;
import com.biz.dripbag.service.GoogleCommentService;

@Service("gcServiceV1")
public class GoogleCommentServicelV1 implements GoogleCommentService {

	@Autowired
	GoogleCommentDAO gcDao;

	@Override
	public List<GoogleCommentVO> selectAll() {
		List<GoogleCommentVO> gcList = gcDao.selectAll();
		return gcList;
	}

	public List<NewsCommentVO> findBySelect(long PK) {
		System.out.println(gcDao.findBySelect(PK));
		return gcDao.findBySelect(PK);
	}

	@Override
	public List<GoogleCommentVO> selectForForm(Long seqJ) {
		List<GoogleCommentVO> gcList = gcDao.selectForForm(seqJ);
		return gcList;
	}

	@Override
	public GoogleCommentVO findById(Long id) {

		GoogleCommentVO gcVO = gcDao.findById(id);

		return gcVO;
	}

	@Override
	public GoogleCommentVO findById(String id) {

		long seq = Long.valueOf(id);
		GoogleCommentVO gcVO = gcDao.findById(id);

		return gcVO;
	}

	@Override
	public int insert(GoogleCommentVO gcVO) {

		LocalDateTime date = LocalDateTime.now();
		String writeDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
		String writeTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(date);

		gcVO.setDates(writeDate);
		gcVO.setTimes(writeTime);
		System.out.println(gcVO.toString());
		int ret = gcDao.insert(gcVO);
		return ret;
	}

	@Override
	public int update(GoogleCommentVO gcVO) {
		return gcDao.update(gcVO);
	}

	@Override
	public int delete(Long id) {
		int ret = gcDao.delete(id);
		return ret;
	}

	@Override
	public List<GoogleCommentVO> selectTop() {
		List<GoogleCommentVO> gcList = gcDao.selectTop();
		return gcList;
	}

	@Override
	public int hit(GoogleCommentVO gcVO) {
		return gcDao.hit(gcVO);
	}

}
