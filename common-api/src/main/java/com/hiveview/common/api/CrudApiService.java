package com.hiveview.common.api;

import java.util.List;

/**
 * Created by leo on 2017/11/3.
 */
public interface CrudApiService<D,P> {

     int saveData(D data);

     int deleteData(D data);

     List<D> findListData(P params);

     PageDto<D> findPageData(PageDto<D> page,P params);
}
