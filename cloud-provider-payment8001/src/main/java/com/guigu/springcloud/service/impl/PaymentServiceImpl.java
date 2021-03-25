package com.guigu.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.springcloud.dao.PaymentDao;
import com.guigu.springcloud.model.Payment;
import com.guigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/19
 */

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao,Payment> implements PaymentService {

}