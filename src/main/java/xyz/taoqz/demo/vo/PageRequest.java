package xyz.taoqz.demo.vo;

import lombok.Data;

/**
 * @author :almostTao
 * @date :Created in 2019/11/21 20:01
 */
@Data
public class PageRequest {

    private Integer pageNum;

    private Integer pageSize;

    private String key;

}
