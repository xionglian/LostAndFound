package com.xionglian.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xionglian.domain.City;
import com.xionglian.dubbo.CityDubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by bysocket on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
