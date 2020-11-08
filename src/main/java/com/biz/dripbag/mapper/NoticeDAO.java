package com.biz.dripbag.mapper;

import com.biz.dripbag.model.NoticeVO;

public interface NoticeDAO extends GenericDAO<NoticeVO, Long>
{
	public long hit(long seq);

	public int deletes(String[] seq);
}
