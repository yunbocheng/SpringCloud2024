package com.yunbocheng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-03-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private Long id;

    private Long productId;

    private Integer total;

    private Integer residue;

}
