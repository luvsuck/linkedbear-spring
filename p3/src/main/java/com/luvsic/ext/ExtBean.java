package com.luvsic.ext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: zyy
 * @Date: 2024/6/27 19:13
 * @Version:
 * @Description:
 */
@Component("myExtBean")
@NoArgsConstructor
@AllArgsConstructor
public class ExtBean {
    private Long id;
}
