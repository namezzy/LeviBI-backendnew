package top.withlevi.model.dto.chart;

import lombok.Data;

import java.io.Serializable;

/**
 * 编辑图表
 *
 */
@Data
public class ChartEditRequest implements Serializable {

    /**
     * id
     */

    private Long id;


    /**
     * 图表名称
     */
    private String name;

    /**
     * 分析目标数据
     */
    private String goal;

    /**
     * 图表数据
     */
    private String chartData;

    /**
     * 图表类型
     */
    private String chartType;


    private static final long serialVersionUID = 1L;
}