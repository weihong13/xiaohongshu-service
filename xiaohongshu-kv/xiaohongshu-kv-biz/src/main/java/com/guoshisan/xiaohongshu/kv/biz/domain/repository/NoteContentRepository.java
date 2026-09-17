package com.guoshisan.xiaohongshu.kv.biz.domain.repository;

import com.guoshisan.xiaohongshu.kv.biz.domain.dto.NoteContentDO;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/**
 * @author: 郭拾叁
 * @date: 2026/9/17 21:45
 * @version: v1.0.0
 * @description: TODO
 **/
public interface NoteContentRepository extends CassandraRepository<NoteContentDO, UUID> {

}

