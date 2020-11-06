package com.biz.dripbag.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.dripbag.mapper.GCommentDAO;
import com.biz.dripbag.model.GCommentVO;
import com.biz.dripbag.service.GCommentService;

@Service("gcServiceV1")
public class GCommentServiceImplV1 implements GCommentService {

	@Autowired
	GCommentDAO gcDao;

	@Override
	public List<GCommentVO> selectAll() {
		List<GCommentVO> gcList = gcDao.selectAll();
		return gcList;
	}

	@Override
	public GCommentVO findById(Long id) {

		GCommentVO gcVO = gcDao.findById(id);

		return gcVO;
	}

	@Override
	public GCommentVO findById(String id) {

		long seq = Long.valueOf(id);
		GCommentVO gcVO = gcDao.findById(id);

		return gcVO;
	}

	@Override
	public int insert(GCommentVO gcVO) {

		LocalDateTime date = LocalDateTime.now();
		String writeDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
		String writeTime = DateTimeFormatter.ofPattern("HH:mm:ss").format(date);

		gcVO.setGc_date(writeDate);
		gcVO.setGc_time(writeTime);

		int ret = gcDao.insert(gcVO);
		return ret;
	}

	@Override
	public int update(GCommentVO gcVO) {
		return gcDao.update(gcVO);
	}

	@Override
	public int delete(Long id) {

		int ret = gcDao.delete(id);
		return ret;
	}

	@Override
	public List<GCommentVO> selectTop() {
		List<GCommentVO> gcList = gcDao.selectTop();
		return gcList;
	}
	
	@Override
	public int hit(GCommentVO gcVO) {
		return gcDao.hit(gcVO);
	}

}
