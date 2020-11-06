package com.biz.dripbag.service;

import com.biz.dripbag.model.NoticeVO;

public interface NoticeService extends GenericService<NoticeVO, Long>
{
	public boolean hit(long pk);
}
