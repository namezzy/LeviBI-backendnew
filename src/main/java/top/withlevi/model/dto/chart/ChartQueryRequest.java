package top.withlevi.model.dto.chart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.withlevi.common.PageRequest;

import java.io.Serializable;

/**
 * 查询请求
 *

 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChartQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 分析目标数据
     */
    private String goal;


    /**
     * 图表类型
     */
    private String chartType;


    /**
     * 用户id
     */
    private Long userId;


    private static final long serialVersionUID = 1L;
}