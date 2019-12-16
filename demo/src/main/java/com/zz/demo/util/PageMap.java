package com.zz.demo.util;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
/*
 * 数据类
 * */
public class PageMap<e> {
    private List<e> data;
    /*页码*/
    private Integer pageNum;
    /*页数*/
    private Integer pageSize;
    /*总条数*/
    private Long total;
    /*返回状态*/
    private Integer code = 200;
    /*错误信息*/
    private String message;

    public PageMap() {
    }

    public PageMap(List<e> data) {
        PageInfo<e> pageInfo = new PageInfo<e> (data);
        this.data = data;
        this.pageNum = pageInfo.getPageNum ( );
        this.total = pageInfo.getTotal ( );
        this.pageSize = pageInfo.getPages ( );
    }

    public PageMap(List<e> data, Integer pageNum, Integer pageSize, Long total) {
        this.data = data;
        this.pageNum = pageNum;
        this.total = total;
        this.pageSize = pageSize;
    }
}
