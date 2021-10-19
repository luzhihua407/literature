package com.aiyo407.literature.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 实体基类
 */
@Data
@Accessors(chain = true)
public abstract class BaseEntity implements Serializable{

	@Id
	@TableId(type = IdType.AUTO)
	@JsonSerialize(using = ToStringSerializer.class)
	Long id;


//	Timestamp createTime=new Timestamp(System.currentTimeMillis());
//
//
//	Timestamp lastUpdateTime;
//
//	Integer orderno =1;
//
//	/**
//	 * 是否有效用于逻辑删除
//	 */
//	boolean valid = true;
//
//	@Version
//	int version;


}
