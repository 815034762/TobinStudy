package com.tobin.top.net;

import com.tobin.top.bean.RecipesBean;
import com.tobin.top.bean.RecipesClassBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

public class ApiManager {

    public static Flowable<BaseResult<RecipesBean>> recipesSearch(String keyword) {

        Map<String, Object> bodyMaps = new HashMap<>();
        bodyMaps.put("appkey",ApiStore.appKey);
        bodyMaps.put("keyword",keyword);  // 关键词
        bodyMaps.put("num",20);  // 获取数量，最大值为20

        return Api.getInstance().recipesSearch(bodyMaps);
    }

    public static Flowable<BaseResult<RecipesClassBean>> recipesClass() {
        Map<String, Object> bodyMaps = new HashMap<>();
        bodyMaps.put("appkey",ApiStore.appKey);
        return Api.getInstance().recipesClass(bodyMaps);
    }

    public static Flowable<BaseResult<RecipesClassBean>> byRecipesClass(int classId, int start, int num) {
        Map<String, Object> bodyMaps = new HashMap<>();
        bodyMaps.put("appkey",ApiStore.appKey);
        bodyMaps.put("classid",2);  // 分类ID
        bodyMaps.put("start",0);  // 起始条数
        bodyMaps.put("num",10);  // 获取数量，最大为20
        return Api.getInstance().byRecipesClass(bodyMaps);
    }

    public static Flowable<BaseResult<RecipesClassBean>> recipesDetail(int id) {
        Map<String, Object> bodyMaps = new HashMap<>();
        bodyMaps.put("appkey",ApiStore.appKey);
        bodyMaps.put("id",2);  // 菜谱ID
        return Api.getInstance().recipesDetail(bodyMaps);
    }


}
