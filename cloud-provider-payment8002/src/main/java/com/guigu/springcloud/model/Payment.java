package com.guigu.springcloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("payment")
public class Payment implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String serial;

}
