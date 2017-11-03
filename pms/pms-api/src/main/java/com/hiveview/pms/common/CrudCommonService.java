package com.hiveview.pms.common;

/**
 * Created by leo on 2017/11/3.
 */
public interface CrudCommonService<T> {

    int saveData(T data);

    int deleteData(T data);

}
