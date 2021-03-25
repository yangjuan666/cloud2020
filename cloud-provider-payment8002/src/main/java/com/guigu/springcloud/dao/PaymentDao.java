package com.guigu.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/19
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}
