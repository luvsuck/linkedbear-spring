package com.luvsic.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: zyy
 * @Date: 2024/6/27 18:28
 * @Version:
 * @Description: 通过@Component声明一个bean相当于在xml里<bean class=com.luvsic.bean.Skill"/>
 * 倘若想指定bean的id和名称,可以用 @Component(value="mySkill"),不指定value时默认会以类名转换驼峰为bean的名称
 */
@Component(value = "mySkill")
@Data
@NoArgsConstructor //这里由于类里包含一个属性name，因此需要手动指定一个无参构造供spring初始化bean用
@AllArgsConstructor
public class Skill {
    private String name;
}
