package com.example.server.service.impl;

import com.example.server.exception.BizBaseException;
import com.example.server.model.dto.AirDTO;
import com.example.server.model.dto.CityDTO;
import com.example.server.model.dto.DailyDTO;
import com.example.server.model.dto.NowDTO;
import com.example.server.model.eum.WeatherErrorCode;
import com.example.server.model.vo.JsonResult;
import com.example.server.model.vo.WeatherRequest;
import com.example.server.service.IWeatherService;
import com.example.server.utils.HttpUtils;
import com.example.server.utils.JsonUtils;
import com.example.server.utils.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <功能描述>
 *
 * @author
 * @date 2021/8/20 14:20
 */
@Service
public class WeatherServiceImpl implements IWeatherService {
    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private final String key = "0034a65bd228446d97d65b32f15cf9cc";

    @Override
    public JsonResult getWeatherOfDays(WeatherRequest weatherRequest) throws Exception {
        String url = "https://devapi.qweather.com/v7/weather/3d?" + "location=" + weatherRequest.getLocation() + "&key=" + key + "&unit=" + weatherRequest.getUnit();
        String result = HttpUtils.get(url);
        DailyDTO dailyDTO = JsonUtils.jsonToObject(result, DailyDTO.class);
        ArrayList weatherList = (ArrayList) dailyDTO.getDaily();
        return JsonResult.success(weatherList.get(0));
    }

    @Override
    public JsonResult getCurrentWeather(WeatherRequest weatherRequest) throws Exception {
        String url = "https://devapi.qweather.com/v7/weather/now?" + "location=" + weatherRequest.getLocation() + "&key=" + key + "&unit=" + weatherRequest.getUnit();
        String result = HttpUtils.get(url);
        NowDTO nowDTO = JsonUtils.jsonToObject(result, NowDTO.class);

        return JsonResult.success(nowDTO.getNow());
    }

    @Override
    public JsonResult getAirQuality(WeatherRequest weatherRequest) throws Exception {
        String url = "https://devapi.qweather.com/v7/air/now?" + "location=" + weatherRequest.getLocation() + "&key=" + key;
        String result = HttpUtils.get(url);
        AirDTO airDTO = JsonUtils.jsonToObject(result, AirDTO.class);
        return JsonResult.success(airDTO.getNow());
    }

    @Override
    public JsonResult<List> getCityList(WeatherRequest weatherRequest) throws Exception {
        String cityUrl = "https://geoapi.qweather.com/v2/city/lookup?" + "location=" + weatherRequest.getLocation() + "&key=" + key;
        String result = HttpUtils.get(cityUrl);
        CityDTO cityDTO = JsonUtils.jsonToObject(result, CityDTO.class);
        if (Integer.valueOf(cityDTO.getCode()) != 200) {
            WeatherErrorCode error = WeatherErrorCode.getError(Integer.valueOf(cityDTO.getCode()));
            return JsonResult.error(error.getCode(), error.getMsg());
        }

        List cityList = (List) cityDTO.getLocation();
        return JsonResult.success(cityList);
    }
}
