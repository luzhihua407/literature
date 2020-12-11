package com.aiyo407.literature.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;

import java.util.List;

/**
 * 分页信息
 *
 * @param <P> 请求参数对象
 * @param <T> 结果集对象
 * @author luzh
 * @version V1.0
 * @time 2018年3月19日上午10:55:36
 * @contact 670177230
 */
public class PageInfo<P, T> implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 请求参数对象
     */
//    @JsonIgnore
    private P param;
    /**
     * 结果集合
     */
    private List<T> data;

    private Boolean success=true;
    /**
     * 总条数
     */
    private Long total = 0L;

    /**
     * 总页数
     */
    private Integer pageCount = 1;
    /**
     * 页码
     */
    private Integer pageNumber = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    public PageInfo() {

    }

    public static PageInfo builder(){
        return new PageInfo();
    }
    /**
     * 构造Page实例
     *
     * @param data
     * @param total
     * @param pageCount
     * @param pageNumber
     * @param pageSize
     */
    public PageInfo(List<T> data, Long total, Integer pageCount, Integer pageNumber, Integer pageSize) {
        this.data = data;
        this.total = total;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public P getParam() {
        return param;
    }

    /**
     * 设置请求参数
     *
     * @param param
     * @author luzh
     */
    public void setParam(P param) {
        this.param = param;
    }

    /**
     * 获取结果集
     *
     * @return
     * @author luzh
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 设置结果集
     *
     * @param data
     * @author luzh
     */
    public void setData(List<T> data) {
        // 提取分页信息
        if (data instanceof PageInfo) {
            // Page page=(Page)data;
            // this.pageCount=page.getPages();
            // this.total=page.getTotal();
        }
        this.data = data;
    }

    /**
     * 获取总条数
     *
     * @return
     * @author luzh
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置总条数
     *
     * @param total
     * @author luzh
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取总页数
     *
     * @return
     * @author luzh
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * 设置总页数
     *
     * @param pageCount
     * @author luzh
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 获取页码
     *
     * @return
     * @author luzh
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * 设置页码
     *
     * @param pageNumber
     * @author luzh
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * 获取每页条数
     *
     * @return
     * @author luzh
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页条数
     *
     * @param pageSize
     * @author luzh
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 转换成Mybatis-plus Page 对象
     *
     * @return
     * @author luzh
     */
    public Page<T> toMybatisPlusPage() {
        Page<T> page = new Page<T>();
        page.setPages(this.pageCount);
        page.setSize(this.getPageSize());
        page.setTotal(this.getTotal());
        page.setCurrent(this.getPageNumber());
        return page;
    }

    public PageInfo<?, T> from(Page<T> page) {

        long current = page.getCurrent();
        long pages = page.getPages();
        List<T> records = page.getRecords();
        long size = page.getSize();
        long total = page.getTotal();
        this.setPageCount((int) pages);
        this.setPageNumber((int) current);
        this.setPageSize((int) size);
        this.setData(records);
        this.setTotal(total);
        return null;

    }

    public PageInfo<?, T> from(AggregatedPage<T> page) {
        long current = page.getNumber();
        long pages = page.getTotalPages();
        List<T> records = page.getContent();
        long size = page.getSize();
        long total = page.getTotalElements();
        this.setPageCount((int) pages);
        this.setPageNumber((int) current);
        this.setPageSize((int) size);
        this.setData(records);
        this.setTotal(total);
        return this;

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
